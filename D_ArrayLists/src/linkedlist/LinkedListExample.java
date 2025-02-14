package D_ArrayLists.src.linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListExample {
    public static void main(String[] args) {
        var placesToVisit = new LinkedList<String>();
        placesToVisit.add("New York");
        placesToVisit.add(0,"Paris");
        addMoreCities(placesToVisit);
        printItenary(placesToVisit);
//        System.out.println(placesToVisit);
    }
    private static void addMoreCities(LinkedList<String> list) {
        list.addFirst("Tokyo");
        list.addLast("London");
//        queue
        list.offer("Sydney");
        list.offerFirst("Rome");
//        Stack methods
        list.push("Berlin");
    }
    private static void removeCities(LinkedList<String> list) {
        list.remove("Tokyo");
        String removed = list.removeLast();
//        queue
        String polled = list.pollFirst();
        list.pop(); // removes first element

    }

    private static void retrieve(LinkedList<String> list) {
        list.get(2);
        list.getFirst();
        list.indexOf("Tpkyp");
    }
    public static void printItenary(LinkedList<String> list) {
        String firstTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1);
        while(iterator.hasNext()) {
            var town = iterator.next();
            System.out.println("---> From: "+ firstTown+ " to " + town);
            firstTown = town;
        }
    }

    public static void testIterator(LinkedList<String> list) {
        var iterator = list.iterator(); // only allows the remove method
        var iterator2 = list.listIterator(); // allow set,add
    }
}
