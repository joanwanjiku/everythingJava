package ImmutableClasses.bankChallenge;

public class Main {
    public static void main(String[] args) {
        BankAccount checking = new BankAccount(1000, Type.CHECKING);
        System.out.println(checking);

        BankCustomer customer = new BankCustomer("John Doe", 1000, 2000);
        System.out.println(customer);

        System.out.println("------------------");

    }
}
