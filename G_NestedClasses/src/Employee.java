import java.util.Comparator;

public class Employee {
    public static class EmployeeComparator <T extends B_Inheritance.src.hrDept.Employee> implements Comparator<B_Inheritance.src.hrDept.Employee> {

        private String sortType;
        public EmployeeComparator() {this("name");}
        public EmployeeComparator(String sortType) {
            this.sortType = sortType;
        }
        @Override
        public int compare(B_Inheritance.src.hrDept.Employee o1, B_Inheritance.src.hrDept.Employee o2) {
            if (sortType.equalsIgnoreCase("yearStarted")) {
                return o1.yearStarted - o2.yearStarted;
            }
            return o1.name.compareTo(o2.name);
        }
    }
    private String name;
    private int employeeId;
    private int yearStarted;

    public Employee(String name, int employeeId, int yearStarted) {
        this.name = name;
        this.employeeId = employeeId;
        this.yearStarted = yearStarted;
    }
    public Employee(){}

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "%d    %-15s    %d".formatted(employeeId, name, yearStarted);
    }
}
