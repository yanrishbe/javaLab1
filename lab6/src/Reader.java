//TODO-my Регистрация поступлений в продуктовый магазин (учесть дату поступления).

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reader extends JFrame {
    private Object selectedDay;

    private Object selectedMonth;

    private Object selectedYear;

    private JComboBox<String> daysComboBox;

    private JComboBox<String> monthsComboBox;

    private JComboBox<String> yearsComboBox;

    private JCheckBox storeCheckBox;

    private JCheckBox warehouseCheckBox;

    private JButton registerButton;

    private JButton deleteButton;

    private JLabel foodstuffLabel;
    private JLabel amountLabel;
    private JLabel deliveryDateLabel;
    private JLabel locationLabel;

    private JTextField text;

    private JTextArea area;

    private String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
            "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

    private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};

    private String[] years = {"2017", "2018", "2019"};

    private String pathToFile = "./lab6.txt";

    Reader(String str) {
        super(str);
        setLayout(null);
        setSize(470, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        registerButton = new JButton("Register");
        deleteButton = new JButton("Clear the fields");

        storeCheckBox = new JCheckBox("Store");
        warehouseCheckBox = new JCheckBox("Warehouse");

        foodstuffLabel = new JLabel("Foodstuff");
        amountLabel = new JLabel("Amount and description");
        deliveryDateLabel = new JLabel("Delivery date");
        locationLabel = new JLabel("Location");

        text = new JTextField(5);
        area = new JTextArea(3, 5);

        foodstuffLabel.setFont(getFont());
        amountLabel.setFont(getFont());
        deliveryDateLabel.setFont(getFont());
        locationLabel.setFont(getFont());
        registerButton.setFont(getFont());
        deleteButton.setFont(getFont());
        text.setFont(getFont());
        area.setFont(getFont());

        daysComboBox = createComboBox(days);
        monthsComboBox = createComboBox(months);
        yearsComboBox = createComboBox(years);

        storeCheckBox.setFont(getFont());
        storeCheckBox.setSelected(false);

        warehouseCheckBox.setFont(getFont());
        warehouseCheckBox.setSelected(true);

        setSizeElements();
        setLocationElements();
        addElements();

        setListeners();
    }

    public class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                File file = new File(pathToFile);
                if (!file.exists()) {
                    file.createNewFile();
                }
                try (FileWriter out = new FileWriter(file, true)) {
                    String text1 = text.getText();
                    String area2 = area.getText();
                    out.write(text1 + " - ");
                    out.write(area2 + "\n");
                    if (storeCheckBox.isSelected() && !warehouseCheckBox.isSelected()) {
                        out.write("Foodstuff is in stock at store "+ "\n");
                    } else if (warehouseCheckBox.isSelected() && !storeCheckBox.isSelected()) {
                        out.write("Foodstuff is warehoused " + "\n");
                    } else if (storeCheckBox.isSelected() && warehouseCheckBox.isSelected()) {
                        out.write("Foodstuff is both warehoused and at store " + "\n");
                    } else {
                        out.write("Foodstuff is somewhere..." + "\n");
                    }
                    out.write(" (Date of delivery: " + selectedDay + " " + selectedMonth + " " + selectedYear + ")\n");
                    out.write("-----------------------------------------------------------\n");
                }
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }
        }
    }

    public class DelActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == deleteButton) {
                text.setText(null);
                area.setText(null);

            }
        }
    }

    public class BoxActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == daysComboBox) {
                selectedDay = daysComboBox.getSelectedItem();
            }
            if (e.getSource() == monthsComboBox) {
                selectedMonth = monthsComboBox.getSelectedItem();
            }
            if (e.getSource() == yearsComboBox) {
                selectedYear = yearsComboBox.getSelectedItem();

            }
        }
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

    private JComboBox<String> createComboBox(String[] fill) {
        JComboBox<String> comboBox = new JComboBox<>(fill);
        comboBox.setFont(getFont());
        return comboBox;
    }

    private void setListeners(){
        daysComboBox.addActionListener(new BoxActionListener());
        monthsComboBox.addActionListener(new BoxActionListener());
        yearsComboBox.addActionListener(new BoxActionListener());
        registerButton.addActionListener(new ButtonActionListener());
        deleteButton.addActionListener(new DelActionListener());
    }

    private void setSizeElements(){
        registerButton.setSize(80, 30);
        deleteButton.setSize(120, 30);
        text.setSize(200, 25);
        area.setSize(200, 90);
        daysComboBox.setSize(40, 25);
        monthsComboBox.setSize(80, 25);
        yearsComboBox.setSize(60, 25);
        storeCheckBox.setSize(80, 25);
        warehouseCheckBox.setSize(100, 25);
        foodstuffLabel.setSize(200, 25);
        amountLabel.setSize(220, 25);
        deliveryDateLabel.setSize(200, 25);
        locationLabel.setSize(200, 25);
    }

    private void setLocationElements() {
        registerButton.setLocation(275, 300);
        deleteButton.setLocation(30, 300);
        text.setLocation(220, 20);
        area.setLocation(220, 60);
        daysComboBox.setLocation(220, 170);
        monthsComboBox.setLocation(270, 170);
        yearsComboBox.setLocation(360, 170);
        storeCheckBox.setLocation(218, 230);
        warehouseCheckBox.setLocation(339, 230);
        foodstuffLabel.setLocation(30, 20);
        amountLabel.setLocation(30, 60);
        deliveryDateLabel.setLocation(30, 170);
        locationLabel.setLocation(30, 230);
    }

    private void addElements(){
        add(registerButton);
        add(deleteButton);
        add(text);
        add(area);
        add(daysComboBox);
        add(monthsComboBox);
        add(yearsComboBox);
        add(storeCheckBox);
        add(warehouseCheckBox);
        add(foodstuffLabel);
        add(amountLabel);
        add(deliveryDateLabel);
        add(locationLabel);
    }
}