package B_Inheritance.src.banking;

public class BankAccount {
    private String accountNumber;
    private long balance;
    private String customerName;
    private String phoneNum;
    private String email;

    public BankAccount(String accountNumber, long balance, String customerName, String phoneNum, String email) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.phoneNum = phoneNum;
        this.email = email;
    }
    public BankAccount(){
    }
    public BankAccount(String phoneNum, String email) {
        this("4141583", 00, "name", phoneNum, email);
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public long deposit (long amount) {

        this.balance += amount;
        return this.balance;
    }

    public long withdraw (long amount) {
        if (amount > balance) {
            return this.balance;
        }
        this.balance -= amount;
        return this.balance;
    }
}
