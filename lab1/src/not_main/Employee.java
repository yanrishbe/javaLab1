package not_main;

//10. Состав класса Employee (служащий):
// фамилия, зарплата, наличие детей.
// Подсчитать среднюю зарплату и количество служащих с детьми.

public class Employee {
    private String lastName;
    private int salary;
    private boolean children;

    public Employee() {
    }

    public Employee(String lastName, int salary, boolean children) {
        this.lastName = lastName;
        this.salary = salary;
        this.children = children;
    }

    public Employee(Employee object) {
        this.lastName = object.lastName;
        this.salary = object.salary;
        this.children = object.children;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isChildren() {
        return children;
    }

    public void setChildren(boolean children) {
        this.children = children;
    }

    public static int AverageSalary(Employee[] employee){
        int avSal=0;
        for (int i=0; i<5; i++)
            avSal+=employee[i].salary;
        return avSal/5;
    }

    public static int hasChildren (Employee[] employee){
        int hChil = 0;
        for(int i=0;i<5;i++)
            if(employee[i].children)
                hChil++;
        return hChil;
    }

    public void print() {

        System.out.println("Last name: "+ this.getLastName()+"\n"+ "Salary: "+
                this.getSalary());

        if(this.isChildren()){
            System.out.println("Has children.");
        }
        if(!this.isChildren()){
            System.out.println("Doesn't have children.");
        }
        System.out.println("---------------------------------------------------");

    }


}

