package D_ArrayLists.src;


import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>(5000);
    }

    public Customer getCustomer(String customerName){
        for(Customer c : customers){
            if(c.getName().equalsIgnoreCase(customerName)){
                return c;
            }
        }
        return null;
    }
    public void addCustomer(String customerName, double initialDeposit) {
        if (getCustomer(customerName)== null) {
            Customer customer = new Customer(customerName, initialDeposit);
            customers.add(customer);
            System.out.println("Inheritance.src.banking.Customer Added");
        }
    }
    public void addTranscation(String name, double transactionAmnt) {
        Customer customer = getCustomer(name);
        if(customer!= null){
            customer.getTransactions().add(transactionAmnt);
        } else {
            System.out.println("Inheritance.src.banking.Customer not found");
        }

    }
    public void printStatement(String customerName) {
        Customer customer = getCustomer(customerName);
        if(customer!= null){
            System.out.println("Statement for " + customer.getName());
            System.out.println("Transaction History:");
            for(double transaction : customer.getTransactions()){
                System.out.printf("$%10.2f (%s)%n", transaction,transaction < 0 ?"debit":"credit");
            }
        } else {
            System.out.println("Inheritance.src.banking.Customer not found");
        }
    }
    @Override
    public String toString() {
        return String.format("Bank %s has %o cusomers", name, customers.size());
    }
}
