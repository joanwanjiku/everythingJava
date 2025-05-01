package ImmutableClasses.bankChallenge;

import java.util.Arrays;
import java.util.List;

public class BankCustomer {
    private final String name;
    private static  int lastCustId = 10_000;
    private final int id;
    private List<BankAccount> accounts;

    public BankCustomer(String name, double checkingBalance, double savingsBalance) {
        this.name = name;
        this.id = lastCustId++;
        this.accounts = List.of(new BankAccount(checkingBalance, Type.CHECKING), new BankAccount(savingsBalance, Type.SAVINGS));
    }

    public String getName() {
        return name;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
    @Override
    public String toString() {
        String[] accountStrings = new String[accounts.size()];
        Arrays.setAll(accountStrings, i -> accountStrings[i] = accounts.get(i).toString());
        return "BankCustomer [name=" + name + ", id=" + id + ", accounts=" + Arrays.toString(accountStrings) + "]";
    }
}
