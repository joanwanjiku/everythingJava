package ImmutableClasses.bankChallenge.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    public final int routingNumber;
    private long lastTransactionId = 1;
    private final Map<String, BankCustomer> customers = new HashMap<>();

    public Bank(int routingNumber) {
        this.routingNumber = routingNumber;
    }
    public BankCustomer getCustomer(String customerId) {
        return customers.get(customerId);
    }

    public void addCustomer(String name, double checkingDeposit, double savingsDeposit) {
        BankCustomer customer = new BankCustomer(name, checkingDeposit, savingsDeposit);
        customers.put(customer.getId(), customer);
    }
    public boolean doTransaction(String customerId, Type type, double amount) {
        BankCustomer customer = customers.get(customerId);
        if (customer == null) return false;
        BankAccount account = customer.getAccount(type);
        if (account == null) return false;
        if (account.getBalance() + amount < 0) return false; // insufficient funds
        account.commitTransaction(routingNumber, customerId, lastTransactionId++, amount);
        return true;
    }
}
