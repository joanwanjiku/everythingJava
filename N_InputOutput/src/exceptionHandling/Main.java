package exceptionHandling;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        String fileName = "testing.csv";
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("File exists");
        }

        useFile("testing.txt");
        System.out.println("----------------------------");
        usePath("pathFile.txt");
    }
    private static void useFile(String fileName){
        File file = new File(fileName);
        boolean exists = file.exists();
        System.out.printf("File %s %s%n", fileName, exists ? "exists" : "does not exist");
        if (exists) {
            System.out.println("Deleting file" + fileName);
            exists = !file.delete();
        }
        if (!exists) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("File " + fileName + " could not be created");;
            }
            System.out.println("File " + fileName + " created");
            if (file.canWrite()) {
                System.out.println("File " + fileName + " is writable");
            }
        }
    }
    private static void usePath(String fileName){
        Path path = Path.of(fileName);
        boolean exists = Files.exists(path);
        System.out.printf("File %s %s%n", fileName, exists ? "exists" : "does not exist");
        if (exists) {
            System.out.println("Deleting file" + fileName);
            try {
                Files.delete(path);
                exists = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!exists) {
            try {
                Files.createFile(path);
                System.out.println("File " + fileName + " created");
                if (Files.isWritable(path)) {
                    System.out.println("File " + fileName + " is writable");
                    Files.writeString(path, """
                            Hello World 
                            something great happened
                            """);
                }
                System.out.println("Readable: " + Files.isReadable(path));
                System.out.println("----------------------------");
                Files.readAllLines(path).forEach(System.out::println);
            } catch (IOException e) {
                System.out.println("File " + fileName + " could not be created");;
            }
        }
    }

}
