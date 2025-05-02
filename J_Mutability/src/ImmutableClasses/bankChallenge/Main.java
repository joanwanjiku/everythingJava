package ImmutableClasses.bankChallenge;

import ImmutableClasses.bankChallenge.bank.Bank;
import ImmutableClasses.bankChallenge.bank.BankAccount;
import ImmutableClasses.bankChallenge.bank.BankCustomer;
import ImmutableClasses.bankChallenge.bank.Type;
import ImmutableClasses.bankChallenge.dto.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        BankAccount checking = new BankAccount(1000, Type.CHECKING);
//        System.out.println(checking);
//
//        BankCustomer customer = new BankCustomer("John Doe", 1000, 2000);
//        System.out.println(customer);
        Bank barclays= new Bank(1234);
        barclays.addCustomer("John Doe", 1000, 2000);
        BankCustomer joe = barclays.getCustomer("0000010000");
        System.out.println(joe);
        System.out.println("------------------");
        if (barclays.doTransaction(joe.getId(), Type.CHECKING, 100)) {
            System.out.println(joe);
        }
        if (barclays.doTransaction(joe.getId(), Type.CHECKING, -1100)) {
            System.out.println(joe);
        }
        BankAccount checking = joe.getAccount(Type.CHECKING);
        var transactions =  checking.getTransactionsImmutable();
        transactions.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("------------------");

    }
}
