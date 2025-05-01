package ImmutableClasses.bankChallenge;

public class BankAccount {
    private final double balance;
    private final Type type;

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

    @Override
    public String toString() {
        return "BankAccount [balance=" + balance + ", type=" + type + "]";
    }
}
