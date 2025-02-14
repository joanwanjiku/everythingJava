import B_Inheritance.src.hrDept.Employee;

import java.util.Comparator;

public class StoreEmployee extends Employee {
    private String storeName;
    public StoreEmployee(String name, int employeeId, int yearStarted, String storeName) {
        super(name, employeeId, yearStarted);
        this.storeName = storeName;
    }
    public StoreEmployee(){

    }

    public class StoreComparator<T extends  StoreEmployee> implements Comparator<StoreEmployee> {
        @Override
        public int compare(StoreEmployee o1, StoreEmployee o2) {
            int result = o1.storeName.compareTo(o2.storeName);
            if (result == 0) {
                return new Employee.EmployeeComparator<>("yearStarted").compare(o1,o2);
            }
            return result;
        }
    }
    @Override
    public String toString() {
        return "10%s %-15s".formatted( super.toString(), storeName );
    }
}
