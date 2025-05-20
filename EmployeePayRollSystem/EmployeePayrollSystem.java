import java.sql.Array;
import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [Name : " + name + " , ID : " + id + " , Salary : " + calculateSalary() + "]";
    }
}

// FULL TIME EMPLOYEE
class FullTimeEmployee extends Employee {
    private double monthlysalary;

    public FullTimeEmployee(String name, int id, double monthlysalary) {
        super(name, id);
        this.monthlysalary = monthlysalary;
    }

    @Override
    public double calculateSalary() {
        return monthlysalary;
    }
}

// PART TIME EMPLOYEE
class PartTimeEmployee extends Employee {
    private double hoursWork;
    private double hourlyRate;
    private double monthlysalary;

    public PartTimeEmployee(String name, int id, double hourlyRate, double hoursWork) {
        super(name, id);
        this.hoursWork = hoursWork;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWork;
    }
}

// PAYROLL SYSTEM
class payroll {
    private ArrayList<Employee> employeeList;

    public payroll() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

// MAIN CLASS
public class EmployeePayrollSystem {
    public static void main(String[] args) {
        payroll payrollSystem = new payroll();

        FullTimeEmployee emp1 = new FullTimeEmployee("Shabnam Quadri", 101, 5000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Umar Quadri", 102, 20, 15);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Initial Employee Details:");

        payrollSystem.displayEmployees();

        System.out.println("\nRemoving Employee...");
        payrollSystem.removeEmployee(102);

        System.out.println("\nRemaining Employee Details:");

        payrollSystem.displayEmployees();
    }
}