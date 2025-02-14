package B_Inheritance.src.hrDept;

public class Employee extends Worker{
    private String employeeId;
    private String hireDate;

    private static int employeeNo = 1;

    public Employee(String name, String birthDate, String hireDate) {
        super(name, birthDate);
        this.employeeId = String.valueOf(Employee.employeeNo++);
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Inheritance.src.hrDept.Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", hireDate='" + hireDate + '\'' +
                "} " + super.toString();
    }
}
