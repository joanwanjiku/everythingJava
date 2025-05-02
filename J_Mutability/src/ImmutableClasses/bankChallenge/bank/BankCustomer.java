package ImmutableClasses.bankChallenge.bank;

import java.util.Arrays;
import java.util.List;

public class BankCustomer {
    private final String name;
    private static  int lastCustId = 10_000;
    private final int id;
    private List<BankAccount> accounts;

    BankCustomer(String name, double checkingBalance, double savingsBalance) {
        this.name = name;
        this.id = lastCustId++;
        this.accounts = List.of(new BankAccount(checkingBalance, Type.CHECKING), new BankAccount(savingsBalance, Type.SAVINGS));
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return "0".repeat(5) + id;
    }

    public List<BankAccount> getAccounts() {
        return List.copyOf(accounts); // returns an unmodifiable list
    }
    public BankAccount getAccount( Type type) {
        for (BankAccount account : accounts)
            if (account.getType() == type) {
                return account;
            }
        return null;
    }
    @Override
    public String toString() {
        String[] accountStrings = new String[accounts.size()];
        Arrays.setAll(accountStrings, i -> accountStrings[i] = accounts.get(i).getType().toString());
        return "BankCustomer: %s (%s) \n %20s $%.2f \n %20s $%.2f".formatted(name, getId(), accountStrings[0], accounts.get(0).getBalance(), accountStrings[1], accounts.get(1).getBalance());
    }
}
