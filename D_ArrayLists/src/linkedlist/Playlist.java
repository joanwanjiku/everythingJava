package D_ArrayLists.src.linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

public class D_ArrayLists.src.linkedlist.Playlist {
    public static void main(String[] args) {
    LinkedList<Song> playlist = new LinkedList<>();
    addSong(playlist, new Song("Song 1", 3.5, "Artist 1"));
    addSong(playlist, new Song("Song 2", 2.5, "Artist 2"));
    addSong(playlist, new Song("Song 3", 4.0, "Artist 1"));
    addSong(playlist, new Song("Song 4", 2.3, "Artist 2"));
    System.out.println(playlist);

    var iterator = playlist.listIterator();
    Scanner scanner = new Scanner(System.in);
    boolean quitLoop = false;
    boolean forward = true;

    printMenu();

    while (!quitLoop) {
        if (!iterator.hasPrevious()) {
            System.out.println("Starting:- "+ iterator.next());
            forward = true;
        }
        if (!iterator.hasNext()) {
            System.out.println("Final:- "+ iterator.previous());
            forward = false;
        }
        System.out.println("Enter a value:- ");
        String choice = scanner.nextLine().toUpperCase().substring(0,1);
        switch (choice) {
            case "F" :
                System.out.println("User goes forward");
                if (!forward){
                    forward = true;
                    if (iterator.hasNext()){
                        iterator.next();
                    }
                }
                if (iterator.hasNext()){
                    System.out.println(iterator.next());
                }
                break;
            case "B" :
                System.out.println("User goes backward");
                if (forward){
                    forward = false;
                    if (iterator.hasNext()){
                        iterator.previous();
                    }
                }
                if (iterator.hasPrevious()){
                    System.out.println(iterator.previous());
                }
                break;
            case "M" :
                printMenu();
                break;
            case "L" :
                System.out.println(playlist);
                break;

            default:
                quitLoop = true;
                break;
        }
    }
    }
    private static void addSong(LinkedList<Song> list, Song song) {
        if (list.contains(song)){
            System.out.println("Found duplicate");
            return;
        }
        int matchedIndex = 0;
        for (var listSong: list) {
            if (song.length() < listSong.length()){
                list.add(matchedIndex, song);
                return;
            }
            matchedIndex++;
        }
        list.add(song);
    }
    private static  void printMenu(){
        System.out.println("""
                Playlist:
                Q - Stop
                A - Add a song
                R - Remove a song
                L - Print the list
                F - Move forward
                B - Move backward
                M - Menu
                """);
    }
    private static void listSongs(LinkedList<Song> songs){
        for (var song: songs) {
            System.out.println("Playing:- "+ song.name() + " by "+song.artist());
        }
    }
}
