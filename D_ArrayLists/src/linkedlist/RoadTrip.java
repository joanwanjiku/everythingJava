package D_ArrayLists.src.linkedlist;

import D_ArrayLists.src.Towns;

import java.util.LinkedList;
import java.util.Scanner;

public class RoadTrip {
    public static void main(String[] args) {
        LinkedList<Towns> towns = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            printMenu();
            switch (scanner.nextLine().toUpperCase()) {
                case "A" -> addPlace(towns);
                case "R" -> removePlace(towns);
                case "L" -> printList(towns);
                case "F" -> moveForward(towns);
                case "B" -> moveBackward(towns);
                case "M" -> printMenu();
                default -> flag = false;
            }
        }
        System.out.println(towns);

    }

    }
    private static void addPlace(LinkedList<Towns> towns){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name and distance:");
        String name = scanner.next();
        int distance = scanner.nextInt();
        Towns town = new Towns(name, distance);
        if (towns.contains(town)){
            System.out.println("Found duplicate");
            return;
        }
        int matchedIndex = 0;
        for (var listPlace: towns) {
        if (town.distance() < listPlace.distance()){
            towns.add(matchedIndex, town);
                return;
            }
        matchedIndex++;
        }
        towns.add(town);
    }
    private static void removePlace(LinkedList<Towns> towns){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of town");
        String name = scanner.next();
        for (Towns town: towns) {
            if (town.name().equalsIgnoreCase(name)){
                towns.remove(town);
                System.out.println("Town removed successfully");
                return;
            }
        }
        System.out.println("Town not found ");
    }
    private static void printList(LinkedList<Towns> towns){
        for (Towns town : towns) {
            System.out.println(town.name() + ": " + town.distance());
        }
    }
    private static void moveForward(LinkedList<Towns> towns){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of town to move forward:");
        String town = scanner.next();
        int placeIndex = 0;
        for (var listPlace:towns) {
            if (listPlace.name().equalsIgnoreCase(town)){
                placeIndex = towns.indexOf(listPlace);
                System.out.println("Index of current town:- "+placeIndex);
            }
        }
        var iterator = towns.listIterator(placeIndex);
        if (iterator.hasNext()){
            var nextTown = iterator.next();
            System.out.println("This is the next town:- "+ nextTown);
        }
        System.out.println("Moving forward...");

    }
    private static void moveBackward(LinkedList<Towns> towns) {
        var iterator = towns.listIterator(towns.size());
        if (iterator.hasPrevious()){
            var previousTown = iterator.previous();
            System.out.println("This is the previous town:- "+ previousTown);
        }
        System.out.println("Moving backward...");
    }
    private static  void printMenu(){
        System.out.println("""
                Menu:
                Q - Shut Down
                A - Add a town
                R - Remove a town
                L - Print the list
                F - Move forward
                B - Move backward
                M - Menu
                """);
    }

}
