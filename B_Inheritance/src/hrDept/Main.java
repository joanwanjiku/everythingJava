package B_Inheritance.src.hrDept;

public class Main {
    public static void main(String[] args) {
        Employee tim = new Employee("Tom", "12-08-1996", "06/08/2015");
        System.out.println("Age "+ tim.getAge());
        System.out.println("Pay " + tim.collectPay());

        SalariedEmployee joe = new SalariedEmployee("Joe", "12/07/1956", "02/01/1996", 35000);
        System.out.println("Joe paychech "+ joe.collectPay());
        joe.retire();
        System.out.println("Joe paycheck after retirement "+ joe.collectPay());
    }
}
