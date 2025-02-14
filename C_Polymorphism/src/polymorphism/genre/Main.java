package C_Polymorphism.src.polymorphism.genre;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Movie advMovie = new Adventure("Stranger danger");
        advMovie.watchMovie();

        Movie movie = Movie.getMovie("scifi", "Aliens");
        movie.watchMovie();

        Scanner s = new Scanner(System.in);
        while (true){
            System.out.println("Enter movie type (A/C/S) or 'exit' to quit:");
            String type = s.nextLine();
            if (type.equalsIgnoreCase("exit")) break;
            System.out.println("Enter movie title:");
            String title = s.nextLine();
            Movie movie2 = Movie.getMovie(type, title);
            movie.watchMovie();
        }
        s.close();
        var comedyMovie = Movie.getMovie("C", "laugh tracks");
        comedyMovie.watchMovie();
    }
}
