package com.company;

import not_main.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Furniture furniture1 = new Furniture();
        furniture1.setManufacturer("China");
        furniture1.setPrice(100);
        furniture1.setMaterial("Wood");
        Furniture furniture2 = new Furniture("USA",200,"Oak");
        Furniture furniture3 = new Furniture(furniture2);
        furniture3.setMaterial("Birch");

        Wardrobe wardrobe1 = new Wardrobe();
        wardrobe1.setManufacturer("Belarus");
        wardrobe1.setPrice(70);
        wardrobe1.setMaterial("Ash");
        wardrobe1.setDepth(1);
        wardrobe1.setHeight(3);
        wardrobe1.setWidth(2);
        Wardrobe wardrobe2 = new Wardrobe("Canada", 150,"Maple",2,3,1);
        Wardrobe wardrobe3 = new Wardrobe(wardrobe1);
        wardrobe3.setManufacturer("Russia");
        wardrobe3.setPrice(65);

        Table table1 = new Table();
        table1.setManufacturer("Poland");
        table1.setMaterial("Glass");
        table1.setPrice(50);
        table1.setArea(2);
        table1.setDrawers(2);
        Table table2 = new Table("Lithuania", 40, "Plastic", 2, 2);
        Table table3 = new Table(table1);
        table3.setPrice(30);
        table3.setMaterial("Wood");

        Chair chair1 = new Chair();
        chair1.setManufacturer("Germany");
        chair1.setPrice(15);
        chair1.setMaterial("Wood");
        Chair chair2 = new Chair(chair1);
        chair2.setRegulate(true);
        Chair chair3 = new Chair("Korea", 20, "Metal", true);

        ArrayList<Furniture> arrayList = new ArrayList();
        arrayList.add(furniture1);
        arrayList.add(furniture2);
        arrayList.add(furniture3);
        arrayList.add(wardrobe1);
        arrayList.add(wardrobe2);
        arrayList.add(wardrobe3);
        arrayList.add(table1);
        arrayList.add(table2);
        arrayList.add(table3);
        arrayList.add(chair1);
        arrayList.add(chair2);
        arrayList.add(chair3);

        for(int i=0; i<arrayList.size();i++){
            arrayList.get(i).show();
        }

    }
}

