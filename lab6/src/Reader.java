//TODO-my Регистрация поступлений в продуктовый магазин (учесть дату поступления).

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Reader extends JFrame {
    private int k=0,m=0, p =0;
    private Object boxA, boxB, boxC;
    private JComboBox box_1, box_2, box_3;
    private static String[] box1 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
            "19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private static String[] box2 = {"January","February","March","April","May","June","July","August","September",
            "October", "November","December"};
    private static String[] box3 = {"2017","2018","2019"};
    private JCheckBox flag1, flag2;
    private static JButton reg, del;
    private static JTextField text;
    private static JTextArea area;


    Reader(String str){
        super(str);
        setSize(470, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1, l2, l3, l4;
        l1 = new JLabel("Foodstuff");
        l1.setFont(getFont());
        l2 = new JLabel("Amount and description");
        l2.setFont(getFont());
        l3 = new JLabel("Delivery date");
        l3.setFont(getFont());
        l4 = new JLabel("Location");
        l4.setFont(getFont());
        reg = new JButton("Register");
        reg.setFont(getFont());
        del = new JButton("Clear the fields");
        del.setFont(getFont());
        text = new JTextField(5);
        text.setFont(getFont());
        area = new JTextArea(3, 5);
        area.setFont(getFont());
        box_1 = new JComboBox(box1);
        box_1.setFont(getFont());
        box_2 = new JComboBox(box2);
        box_2.setFont(getFont());
        box_3 = new JComboBox(box3);
        box_3.setFont(getFont());
        flag1 = new JCheckBox("Store");
        flag1.setFont(getFont());
        flag1.setSelected(false);
        flag2 = new JCheckBox("Warehouse");
        flag2.setFont(getFont());
        flag2.setSelected(true);
        /*ButtonGroup bg = new ButtonGroup();
        bg.add(flag1);
        bg.add(flag2);*/

       // setLayout(new GridLayout(5,2));
        setLayout(null);
        reg.setSize(80,30);
        reg.setLocation(275, 300);
        del.setSize(120, 30);
        del.setLocation(30, 300);
        text.setSize(200,25);
        text.setLocation(220, 20);
        area.setSize(200,90);
        area.setLocation(220,60);
        l1.setSize(200,25);
        l1.setLocation(30, 20);
        l2.setSize(220, 25);
        l2.setLocation(30, 60);
        l3.setSize(200, 25);
        l3.setLocation(30, 170);
        l4.setSize(200, 25);
        l4.setLocation(30, 230);
        box_1.setSize(40,25);
        box_1.setLocation(220,170);
        box_2.setSize(80, 25);
        box_2.setLocation(270, 170);
        box_3.setSize(60, 25);
        box_3.setLocation(360, 170);
        flag1.setSize(80,25);
        flag1.setLocation(218, 230);
        flag2.setSize(100, 25);
        flag2.setLocation(339, 230);

        add(reg);
        add(del);
        add(text);
        add(area);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(box_1);
        add(box_2);
        add(box_3);
        add(flag1);
        add(flag2);

//        reg.addActionListener(new ButtonActionListener());reg.addActionListener(new ButtonActionListener());
        flag1.addActionListener(new FlagActionListener());///////////////////////////////////////////////////////
        flag2.addActionListener(new FlagActionListener());///////////////////////////////////////////////////////
//        del.addActionListener(new DelActionListener());
        box_1.addActionListener(new BoxActionListener());
        box_2.addActionListener(new BoxActionListener());
        box_3.addActionListener(new BoxActionListener());
        reg.addActionListener(new ButtonActionListener());
        del.addActionListener(new DelActionListener());
    }
    public Font getFont() {
        try {
            InputStream is = Reader.class.getResourceAsStream("Roboto-Light.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            return font.deriveFont(12f);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
            return super.getFont();
        }
    }

    public class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
                File file = new File("./lab6.txt");
                if(!file.exists()){
                    file.createNewFile();
                }
                FileWriter out = new FileWriter(file, true);
                try{
                    String text1 = text.getText();
                    String area2 = area.getText();
                    out.write(text1 + " - ");
                    out.write(area2 + "\n");
                    if(k==1)
                        out.write("Foodstuff is warehoused " + "\n");
                    else if(k==2)
                        out.write("Foodstuff is in stock at store " + "\n");
                    else if(k==3)
                        out.write("Foodstuff is both warehoused and at store " + "\n");
                    out.write(" (Date of delivery: " + boxA + " " + boxB + " " + boxC + ")\n");
                    out.write("-----------------------------------------------------------\n");
                } finally{
                    out.close();
                }
            }catch(IOException e1){
                throw new RuntimeException(e1);
            }
        }
    }

//    public void itemStateChanged(ItemEvent e) {
//        int index = 0;
//        char c = '-';
//        Object source = e.getItemSelectable();
//
//        if (source == chinButton) {
//            index = 0;
//            c = 'c';
//        } else if (source == glassesButton) {
//            index = 1;
//            c = 'g';
//        } else if (source == hairButton) {
//            index = 2;
//            c = 'h';
//        } else if (source == teethButton) {
//            index = 3;
//            c = 't';
//        }
//        //Now that we know which button was pushed, find out
//        //whether it was selected or deselected.
//        if (e.getStateChange() == ItemEvent.DESELECTED) {
//            c = '-';
//        }
//        //Apply the change to the string.
//        choices.setCharAt(index, c);
//        updatePicture();
//    }

    public class FlagActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if(flag1.isSelected())
                k = 1;
            else if(flag2.isSelected())
                //m = 2;
                k=2;
            else if (flag1.isSelected()&& flag2.isSelected())
                k=3;
            //p=k+m;
        }
    }
    public class DelActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == del){
                text.setText(null);
                area.setText(null);

            }
        }
    }
    public class BoxActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == box_1){
                boxA = box_1.getSelectedItem();
            }
            if(e.getSource() == box_2){
                boxB = box_2.getSelectedItem();
            }
            if(e.getSource() == box_3){
                boxC = box_3.getSelectedItem();

            }
        }
    }
}
