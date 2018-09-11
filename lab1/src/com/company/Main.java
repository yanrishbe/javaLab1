package com.company;
import not_main.*;

public class Main {

    public static void main(String[] args) {
        Employee []employee = new Employee[5];
        employee[0] = new Employee("Ivanov", 1000, true );
        employee[1]= new Employee("Petrov",2000,false);
        employee[2]= new Employee();
        employee[2].setLastName("Fool");
        employee[2].setSalary(300);
        employee[3]= new Employee(employee[0]); // вызов конструктора копий, здесь мы копируем информацию, из первого объекта
        employee[3].setLastName("Petrov");
        employee[4]= new Employee();
        employee[4].setLastName("Kvashin");
        employee[4].setSalary(1500);
        employee[4].setChildren(true);


        for(int i=0;i<5;i++){
            employee[i].print();
        }
        System.out.println("Average salary "+ Employee.AverageSalary(employee));

        System.out.println("Employees with children "+ Employee.hasChildren(employee));
    }
}
