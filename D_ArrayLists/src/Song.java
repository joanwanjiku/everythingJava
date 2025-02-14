package D_ArrayLists.src;

public record Song(String name, double length, String artist) {
    @Override
    public String toString() {
        return String.format("%s - %.1f minutes by %s", name, length, artist);
    }
}
