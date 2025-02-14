package B_Inheritance.src.banking;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        BankAccount joanAcc = new BankAccount("836282993", 34444, "tim", "972671", "jo@gmail.com");
        joanAcc.deposit(67);
        joanAcc.getBalance();
        System.out.println(joanAcc.getBalance());

        BankAccount bobsAcc = new BankAccount();
        System.out.println(bobsAcc.getBalance());

        BankAccount timsAcc = new BankAccount("0775151551", "tim@gmail.com");
        timsAcc.getBalance();
        bankAccount.setBalance(1200);
        bankAccount.deposit(500);
        System.out.println(bankAccount.getBalance());
        bankAccount.withdraw(500);
        bankAccount.withdraw(700);
        bankAccount.withdraw(600);
        System.out.println(bankAccount.getBalance());

        //        customer
        Customer customer = new Customer();
        System.out.println(customer.getName());
        System.out.println(customer.getCreditLimit());

        Customer annCust  = new Customer("ann", "ann@gmail.com");
        System.out.println(annCust.getCreditLimit());

    }
}
