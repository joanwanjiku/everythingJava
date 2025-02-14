package D_ArrayLists.src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GroceryItem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> groceryItem = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            System.out.println("Enter 0- ShutDown, 1- To add, 2- To remove: ");

            switch (scanner.nextInt()) {
                case 1 -> addItems(groceryItem);
                case 2 -> removeItems(groceryItem);
                default -> flag = false;

            }
            groceryItem.sort(Comparator.naturalOrder());
            System.out.println(groceryItem);
        }

        System.out.println(groceryItem);
    }

    private static void removeItems(ArrayList<String> groceryItem) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the item to remove:");
        String itemToRemove = scanner.next();
        if (groceryItem.contains(itemToRemove)) {
            groceryItem.remove(itemToRemove);
            System.out.println("Item removed successfully!");
        } else {
            System.out.println("Item not found!");
        }
    }

    private static void addItems(ArrayList<String> groceries) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a grocery items separated by comma:");
        List<String> inputItems = List.of(scanner.nextLine().split(","));
        groceries.addAll(inputItems);
    }
}
