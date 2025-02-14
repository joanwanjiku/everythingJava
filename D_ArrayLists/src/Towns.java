package D_ArrayLists.src;

public record Towns(String name, int distance) {

    @Override
    public String toString() {
        return String.format("%s (%d)", name, distance);
    }

}
