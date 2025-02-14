package C_Polymorphism.src.polymorphism.genre;

public class Scifi extends Movie {
    public Scifi(String title) {
        super(title);
    }

    @Override
    public void watchMovie(){
        super.watchMovie();
        System.out.printf("..%s%n".repeat(3), "Aliens", "lab", "blows up");
    }
}
