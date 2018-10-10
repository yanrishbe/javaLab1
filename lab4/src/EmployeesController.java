public class EmployeesController {
    private static int summarySalary;
    private static int countOfParents;

    public int getSalary() {
        return this.summarySalary;
    }

    public void addSalary(int salary) {
        this.summarySalary += salary;
    }

    public void addParent() {
        this.countOfParents++;
    }

    public int getCountOfParents() {
        return this.countOfParents;
    }
}
