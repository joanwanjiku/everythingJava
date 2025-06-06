package exceptionHandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

public class nio2 {
    public static void main(String[] args) {
        Path path = Path.of("files/testing.txt");
        printPathInfo(path);
        logStatement(path);

        extraInfo(path);
    }
    private static void printPathInfo(Path path){
        System.out.println("Path: " + path);
        System.out.println("fileName: " + path.getFileName());
        System.out.println("Parent: " + path.getParent());
        System.out.println("Root: " + path.getRoot());
        System.out.println("isAbsolute: " + path.isAbsolute());
        Path absPath = path.toAbsolutePath();
        System.out.println("AbsolutePath: " + absPath);
        System.out.println("Root: " + absPath.getRoot());
        int pathParts = absPath.getNameCount();
        for (int i = 0; i < pathParts; i++) {
            System.out.println(".".repeat(i + i) + " " + absPath.getName(i));
        }
        System.out.println("----------------------------------------------------------");

    }
    private static void logStatement(Path path){
        try{
            Path parent = path.getFileName();
            if (!Files.exists(parent)) {
                Files.createDirectory(parent);
            }
            Files.writeString(path, Instant.now() +
                            ": hello file world\n", StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    private static void extraInfo(Path path) {

        try {
            var atts = Files.readAttributes(path, "*");
            atts.entrySet().forEach(System.out::println);
            System.out.println(Files.probeContentType(path));
        } catch (IOException e) {
            System.out.println("Problem getting attributes");
        }
    }
}
