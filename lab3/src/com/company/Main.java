package com.company;
import not_main.*;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

     Stool stool = new Stool(true, false);
     stool.setRegulate(true);

     Bar_Stool bar_stool = new Bar_Stool();
     bar_stool.setSectional(false);
     bar_stool.setRegulate(false);

     Table table = new Table(4, 10, true);
     Table table1 = new Table();
     table1.setDrawers(2);
     table1.setArea(5);
     table1.setSectional(false);

     Wardrobe wardrobe = new Wardrobe(10,5,2,true);
     Wardrobe wardrobe1 = new Wardrobe(false);
     wardrobe1.setWidth(8);
     wardrobe1.setHeight(4);
     wardrobe1.setDepth(1);
     //корректно ли написать здесь интерфейс а не класс???
     ArrayList <Chair> arrayList = new ArrayList();

     Collections.addAll(arrayList, stool,bar_stool);
        for(int i=0; i<arrayList.size();i++){
            arrayList.get(i).print();
        }
     table.print();
     table1.print();
     wardrobe.print();
     wardrobe1.print();
    }
}
