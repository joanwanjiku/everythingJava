package C_Polymorphism.src.polymorphism.genre;

public class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void watchMovie(){
        String instanceType = this.getClass().getSimpleName();
        System.out.println("Watching movie: " + title+ " of instance " +instanceType);
    }
    public static Movie getMovie(String type, String title) {
        return switch (type.toUpperCase().charAt(0)){
            case 'A' -> new Adventure(title);
            case 'C' -> new Comedy(title);
            case 'S' -> new Scifi(title);
            default -> new Movie(title);
        };
    }
}
