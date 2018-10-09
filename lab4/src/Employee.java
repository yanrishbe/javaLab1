// вывод информации в файл, статический метод чтения из файла
// и вывода прочитанной информации на экран.

//Подсчитать среднюю зарплату и количество служащих с детьми.
import java.io.*;

public class Employee {
    private String lastName;
    private int salary;
    private boolean children;

    Employee () throws IOException {

        String info;
        //открываем символьный поток ввода
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
       // BufferedWriter bw = new BufferedWriter(new FileWriter("document.doc"));
        System.out.println("Please input an employee's last name: ");
         while ((this.lastName=br.readLine())!=null) {
             System.out.println(this.lastName);
         }

        System.out.println("Please input an employee's salary: ");
            this.salary=Integer.parseInt(br.readLine());
            System.out.println(this.salary);

        while(true){
            System.out.println("Has children?(Y/N): ");
            int value;
            while ((value = br.read()) != -1) {
                info= new String(Character.toChars(value));
                System.out.println(info);
            }

            info=br.readLine();
            if("Y".equals(info)){
                this.children=true;
                break;
            }
            if("N".equals(info)){
                this.children=false;
                break;
            }
            System.out.println("Error! Please input a correct symbol");
        }
    }

    //записываем информацию в файл lab4.doc
    public void InputInFile()throws IOException{
        File file = new File("lab4.doc");
        System.out.println("A file has been created");
        file.deleteOnExit(); //файл удалится после завершения работы виртуальной машины Java
        //поток для записи в файл
        FileWriter fw = new FileWriter(file,true);
        fw.append("\nAn employee: "+this.lastName+"; salary: "+this.salary+"; ");
        if (this.children)
            fw.append("has children.\n");
        else fw.append("has no children.\n");
        fw.append("--------------------------------------------------------------------------------\n");
        fw.flush();
        fw.close();
    }

    
    //статический метод вывода информации из файла
    public static void OutputOfFile()throws IOException{
        File file = new File("lab4 .doc");
        //поток для вывода информации
        FileReader reader;
        char buffer[];
        int numb;
        buffer=new char[1];
        reader = new FileReader(file);
        do{
            numb=reader.read(buffer);
            System.out.print(buffer[0]);
        }while(numb==1);
        reader.close();
    }
    public static void main(String[] args) throws IOException{
        Drugstore[] drugstores;
        drugstores=new Drugstore[3];
        for (int i=0; i<3; i++)
            drugstores[i]=new Drugstore();
        for(int i=0;i<3;i++)
            drugstores[i].InputInFile();
        OutputOfFile();
    }


}


