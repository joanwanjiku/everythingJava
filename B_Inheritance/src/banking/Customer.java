package B_Inheritance.src.banking;

public class Customer {

    private String name;
    private String email;
    private double creditLimit;

    public Customer(String name, String email, double creditLimit) {
        this.name = name;
        this.email = email;
        this.creditLimit = creditLimit;
    }
    public Customer() {
        this("duo","duo@gmail", 0);
    }
    public Customer(String name, String email) {
        this(name, email, 6);
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
}
