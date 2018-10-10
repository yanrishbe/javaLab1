import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws IOException {
        EmployeesController employeesController = new EmployeesController();
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(employeesController));
        employees.add(new Employee(employeesController));
        employees.add(new Employee(employeesController));
        Employee.OutputOfFile();

        System.out.println("Count of parents: " + employeesController.getCountOfParents());
        System.out.println("Average salary: " + (employeesController.getSalary() / employees.size()));
    }
}

