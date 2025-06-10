package managingFiles;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        File oldFile = new File("students.json");
//        File newFile = new File("student.json");
//        if (oldFile.exists()) {
//            oldFile.renameTo(newFile);
//            System.out.println("File renamed successfully!");
//        } else {
//            System.out.println("File does not exist!");
//        }
//
//        Path oldPath = Path.of("student.json");
//        Path newPath = Path.of("files/student.json");
//
//        try {
//            Files.createDirectories(newPath.subpath(0, newPath.getNameCount() - 1));
//            Files.move(oldPath, newPath);
//            System.out.println(oldPath + " moved (renamed to) --> " + newPath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Path fileDir = Path.of("files");
        Path resourceDir = Path.of("resources");
        try {
            recurseDelete(resourceDir);
            recurseCopy(fileDir, resourceDir); // copy method performs a shallow copy
            System.out.println("Directory copied to " + resourceDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void recurseCopy(Path source, Path target) throws IOException {
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        if (Files.isDirectory(source)) {
            try (Stream<Path> paths = Files.list(source)) {
                paths.toList().forEach(p -> {
                    try {
                        recurseCopy(p, target.resolve(p.getFileName()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

            }
        }
    }
    public static void recurseDelete(Path target) throws IOException {
        if (Files.isDirectory(target)) {
            try (Stream<Path> paths = Files.list(target)) {
                paths.toList().forEach(p -> {
                    try {
                        recurseDelete(p);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
        Files.delete(target);
    }
}
