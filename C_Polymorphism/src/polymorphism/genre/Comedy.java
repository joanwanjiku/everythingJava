package C_Polymorphism.src.polymorphism.genre;

public class Comedy extends Movie {
    public Comedy(String title) {
        super(title);
    }

    @Override
    public void watchMovie(){
        super.watchMovie();
        System.out.printf("..%s%n".repeat(3), "funny", "nice cast", "funniest");
    }
}
