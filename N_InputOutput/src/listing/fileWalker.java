package listing;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class fileWalker {
    public static void main(String[] args) {
        Path startingPath = Path.of("");
        FileVisitor<Path> visitor = new StatsVistitor();
        try {
            Files.walkFileTree(startingPath, visitor);
        } catch (IOException e) {
        }
    }

    private static  class StatsVistitor extends SimpleFileVisitor<Path> {
        private Path initialPath = null;
        private final Map<Path, Long> folderSizes = new LinkedHashMap<>();
        private int initialCount;

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            Objects.requireNonNull(file);
            Objects.requireNonNull(attrs);
            folderSizes.merge(file.getParent(), 0L, (o,n) -> o += attrs.size());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            Objects.requireNonNull(dir);
            if (dir.equals(initialPath)) {
                return FileVisitResult.TERMINATE;
            }
            int relativeLevel = dir.getNameCount() - initialCount;
            if (relativeLevel == 1) {
                folderSizes.forEach((key, value) -> {

                    int level = key.getNameCount() - initialCount - 1;
                        System.out.printf("%s[%s] - %,d bytes %n",
                                "\t".repeat(level), key.getFileName(), value);
                });

            } else {
                long folderSize = folderSizes.get(dir);
                folderSizes.merge(dir.getParent(), 0L, (o, n) -> o += folderSize);
            }
            return FileVisitResult.CONTINUE;        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            Objects.requireNonNull(dir);
            Objects.requireNonNull(attrs);
            if (initialPath == null) {
                initialPath = dir;
                initialCount = dir.getNameCount();
            } else {
                int relativeLevel = dir.getNameCount() - initialCount;
                if (relativeLevel == 1) {
                    folderSizes.clear();
                }
                folderSizes.put(dir, 0L);
            }
            return FileVisitResult.CONTINUE;
        }

    }
}
