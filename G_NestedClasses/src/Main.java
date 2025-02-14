import B_Inheritance.src.hrDept.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Static nested Classes
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("John Doe", 11001, 2010),
                new Employee("Jane Smith", 10202, 2015),
                new Employee("Alice Johnson", 10003, 2012),
                new Employee("Bob Brown", 10304, 2013),
                new Employee("Charlie Davis", 13325, 2011)
        ));
//        var comparator = new EmployeeComparator<>();
//        employees.sort(comparator);
        employees.sort(new Employee.EmployeeComparator<>("yearStarted"));

        for (var employee: employees) {
            System.out.println(employee);
        }
        System.out.println("--------------------------------");

//        inner classes
        StoreEmployee storeEmployee1 = new StoreEmployee("John Doe", 11001, 2010, "Walmart");
        StoreEmployee storeEmployee2 = new StoreEmployee("Jane Smith", 10202, 2015, "Macys");
        StoreEmployee storeEmployee3 = new StoreEmployee("Alice Johnson", 10003, 2012, "Target");
        StoreEmployee storeEmployee4 = new StoreEmployee("Bob Brown", 10304, 2013, "Sams");
        StoreEmployee storeEmployee5 = new StoreEmployee("Charlie Davis", 13325, 2011, "Sprouts");
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                storeEmployee1, storeEmployee2, storeEmployee3, storeEmployee4, storeEmployee5
        ));
        var storeComparator = new StoreEmployee().new StoreComparator<>(); // creates an instance of an inner class
        storeEmployees.sort(storeComparator);
        for (var storeEmployee: storeEmployees) {
            System.out.println(storeEmployee);
        }

        System.out.println("----------------------");
        addPigLatinName(storeEmployees);



    }
// Local classes
    public static void addPigLatinName(List<? extends StoreEmployee> list) {


        class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee>{
            private String pigLatinName;
            private Employee originalInstance;



            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString() {
                return originalInstance.toString() + " "+ pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }
        List<DecoratedEmployee> newList = new ArrayList<>(list.size());
        for (StoreEmployee employee : list) {
            String name = employee.getName();
            String pigLatinName = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLatinName, employee));
        }
        newList.sort(null);
        for (var emp:newList) {
            System.out.println(emp);
        }
    }
}
