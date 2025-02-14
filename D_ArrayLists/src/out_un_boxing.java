package D_ArrayLists.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class out_un_boxing {
    public static void main(String[] args) {
        Integer[] wrapperArray = new Integer[5];
        wrapperArray[0] = 10;
        System.out.println(Arrays.toString(wrapperArray)); //

        var ourlist = getList(1,2,3,4,5);
        var ourlist2 = List.of(1, 2, 3, 4, 5);

        System.out.println(ourlist);

//        Inheritance.src.banking.Customer bob = new Inheritance.src.banking.Customer("bobby", 2400.00);
//        System.out.println(bob);

        Bank bank = new Bank("Co-op");
        bank.addCustomer("Alice", 5000.00);
        bank.addCustomer("Bob", 3000.00);
        bank.addTranscation("Alice", 1000.00);
        bank.addTranscation("Bob", -2000.00);
        bank.addTranscation("Bob s", -2000.00);
        bank.printStatement("Bob s");
        System.out.println(bank);


    }
    private static ArrayList<Integer> getList(Integer... varargs){
        ArrayList<Integer> alist = new ArrayList<>();
        for(int i: varargs){
            alist.add(i);
        }
        return alist;
    }
}
