package ImmutableClasses.bankChallenge.bank;

import ImmutableClasses.bankChallenge.dto.Transaction;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccount {
    private double balance;
    private final Type type;
    private Map<Long, Transaction> transactions = new LinkedHashMap<>();

    BankAccount(double balance, Type type) {
        this.balance = balance;
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public Type getType() {
        return type;
    }

    public Map<Long, Transaction> getTransactions() {
        return Map.copyOf(transactions); // returns an unmodifiable map
    }
//    this ensures the transcations map values(Map data) is immutable
    public Map<Long, String> getTransactionsImmutable() {
        Map<Long, String> txMap = new LinkedHashMap<>();
        for (var tx : transactions.entrySet()) {
            txMap.put(tx.getKey(), tx.getValue().toString());
        }
        return txMap;
    }
    public void commitTransaction(int routingNumber, String customerId, long transactionId, double transactionAmount) {
        Transaction tranc =  new Transaction(routingNumber, Integer.parseInt(customerId), transactionId, transactionAmount);
        balance += transactionAmount;
        transactions.put(transactionId, tranc);
    }

    @Override
    public String toString() {
        return "BankAccount [balance=" + balance + ", type=" + type + "]";
    }
}
