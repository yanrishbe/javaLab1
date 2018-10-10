import java.io.*;

public class Employee {
    private String lastName;
    private int salary;
    private boolean children;

    Employee(EmployeesController employeesController) throws IOException {
        File file = new File("lab4.doc");
        System.out.println("A file has been created.");
        file.deleteOnExit(); //файл удалится после завершения работы виртуальной машины Java

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));


        System.out.println("Please input an employee's last name: ");
        this.setEmployee(br, bw);

        System.out.println("Please input an employee's salary: ");
        this.setSalary(br, bw, employeesController);

        System.out.println("Has children?(Y/N): ");
        this.setHasChildren(br, bw, employeesController);

        bw.append("\n-------------------------------------------------------------------\n");
        bw.flush();
        bw.close();
    }

    /***
     * Cтатический метод вывода информации из файла
     * @throws IOException
     */
    public static void OutputOfFile() throws IOException {
        String info;
        File file = new File("lab4.doc");
        BufferedReader br = new BufferedReader(new FileReader(file)); //поток для вывода информации
        System.out.println("Reading from file: \n");
        while ((info = (br.readLine())) != null)
            System.out.println(info);
        br.close();
    }

    public void setEmployee(BufferedReader br, BufferedWriter bw) throws IOException {
        this.lastName = br.readLine();
        bw.append("An employee: " + this.lastName);
    }

    public void setSalary(BufferedReader br, BufferedWriter bw, EmployeesController employeesController) {
        String p;
        while (true) {
            try {
                p = br.readLine();
                this.salary = Integer.parseInt(p);
                employeesController.addSalary(this.salary);
                bw.append("; salary: " + this.salary + "; ");
                break;
            } catch (Exception e) {
                System.out.println("Wrong number! Please try again!");
                continue;
            }
        }
    }

    public void setHasChildren(BufferedReader br, BufferedWriter bw, EmployeesController employeesController)
            throws IOException {
        String info;
        while (true) {
            info = br.readLine();
            if (info.equals("Y")) {
                this.children = true;
                bw.append("has children.\n");
                employeesController.addParent();
                break;
            }
            if (info.equals("N")) {
                this.children = false;
                bw.append("has no children.\n");
                break;
            } else {
                System.out.println("Error! Please input a correct symbol!");
            }
        }
    }
}


