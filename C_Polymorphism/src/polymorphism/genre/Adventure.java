package C_Polymorphism.src.polymorphism.genre;

public class Adventure extends Movie {
    public Adventure(String title) {
        super(title);
    }

    @Override
    public void watchMovie(){
        super.watchMovie();
        System.out.printf("..%s%n".repeat(3), "Pleasant scene", "nice cast", "scary clothes");
    }
}
