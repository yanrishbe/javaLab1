import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;


public class Reader {
    JButton addButton, deleteButton, clearButton, similarButton, editButton, sortButton;
    static JTextField newName, newArticle, newYear, newSize, newPrice, newModel, newManufacturer, newColour;
    static JLabel nn, na, ny, ns, np, nm, nma, nc;

    JFrame frame;
    JPanel panelButton, panelButton1;
    JTable shopTable;

    ShopTableModel shoptablemodel;

    Shop clothing = null;
    Shop clothing1 = null, clothing2 = null, clothing3 = null, clothing4 = null;

    public Reader() {

        frame = new JFrame("Clothing shop");
        frame.setSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        addButton = new JButton("Add");
        addButton.addActionListener(new AddActionListener());

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteActionListener());

        editButton = new JButton("Edit");
        editButton.addActionListener(new EditActionListener());

        clearButton = new JButton("Clean");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shoptablemodel.clear();
                shoptablemodel.fireTableDataChanged();
            }
        });

        sortButton = new JButton("Sort");
        sortButton.addActionListener(new SortActionListener());

        similarButton = new JButton("Search same names");
        similarButton.addActionListener(new SearchActionListener());

        shoptablemodel = new ShopTableModel();
        shopTable = new JTable(shoptablemodel);
        frame.add(new JScrollPane(shopTable), BorderLayout.CENTER);
        frame.setVisible(true);

        try {
            clothing = new Shop("Dress", "1", "2017", "36", "100", "d",
                    "Poland", "black");
            clothing1 = new Shop("Skirt", "2", "2018", "34", "50", "s",
                    "Italy", "purple");
            clothing2 = new Shop("Jeans", "3", "2017", "36", "100", "j",
                    "UK", "dark blue");
            clothing3 = new Shop("Dress", "4", "2018", "42", "90", "d",
                    "Spain", "burgundy");
            clothing4 = new Shop("Trouseres", "5", "2018", "44", "70", "t",
                    "Russia", "green");

        } catch (DataExсeption DataExсeption) {
            DataExсeption.getInfo();
        }
        shoptablemodel.addData(clothing);
        shoptablemodel.addData(clothing1);
        shoptablemodel.addData(clothing2);
        shoptablemodel.addData(clothing3);
        shoptablemodel.addData(clothing4);

        newName = new JTextField(15);
        newArticle = new JTextField(15);
        newYear = new JTextField(15);
        newSize = new JTextField(15);
        newPrice = new JTextField(15);
        newModel = new JTextField(15);
        newManufacturer = new JTextField(15);
        newColour = new JTextField(15);

        nn = new JLabel("Name");
        na = new JLabel("Article");
        ny = new JLabel("Year");
        ns = new JLabel("Size");
        np = new JLabel("Price");
        nm = new JLabel("Model");
        nma = new JLabel("Manufacturer");
        nc = new JLabel("Colour");

        panelButton = new JPanel();
        panelButton.setLayout(new GridLayout());

        panelButton.add(addButton);
        panelButton.add(similarButton);
        panelButton.add(deleteButton);
        panelButton.add(clearButton);
        panelButton.add(editButton);
        panelButton.add(sortButton);


        panelButton.setVisible(true);
        frame.add(panelButton, BorderLayout.PAGE_END);

        panelButton1 = new JPanel();
        panelButton1.setLayout (new GridLayout(10, 1, 0, 0));

        panelButton1.add(nn);
        panelButton1.add(newName);
        panelButton1.add(na);
        panelButton1.add(newArticle);
        panelButton1.add(ny);
        panelButton1.add(newYear);
        panelButton1.add(ns);
        panelButton1.add(newSize);
        panelButton1.add(np);
        panelButton1.add(newPrice);
        panelButton1.add(nm);
        panelButton1.add(newModel);
        panelButton1.add(nma);
        panelButton1.add(newManufacturer);
        panelButton1.add(nc);
        panelButton1.add(newColour);

        panelButton1.setVisible(true);
        frame.add(panelButton1, BorderLayout.WEST);
        frame.pack();
        if (shopTable != null) {
            shopTable.addMouseListener(new ClickedActionListener() );
        }
    }

    public class SearchActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String searchInfo = JOptionPane.showInputDialog(null, "Input clothing name",
                    "Search same names", JOptionPane.QUESTION_MESSAGE);
            ArrayList<Shop> similarArrayList = shoptablemodel.findSimilar(searchInfo);
            SimilarData similarData = new SimilarData(similarArrayList);
            similarData.setVisible(true);
            similarData.setLocationRelativeTo(null);
        }
    }
    
    public class SortActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Collections.sort(shoptablemodel.getDataArrayList());
            shoptablemodel.fireTableDataChanged();
        }
    }
    
    public class AddActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nameText= newName.getText();
            String articleText= newArticle.getText();
            String yearText= newYear.getText();
            String sizeText= newSize.getText();
            String priceText= newPrice.getText();
            String modelText= newModel.getText();
            String manufacturerText= newManufacturer.getText();
            String colourText= newColour.getText();

            try {
                shoptablemodel.addData(new Shop(nameText,articleText,yearText,sizeText,priceText,modelText,manufacturerText
                , colourText));
            } catch (DataExсeption DataExсeption) {
                DataExсeption.getInfo();
            }
            shoptablemodel.fireTableDataChanged();

        }

    }

    public class DeleteActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = shopTable.getSelectedRow();
            if(i>=0){
                shoptablemodel.removeRow(i);
                shoptablemodel.fireTableDataChanged();
            }
            else JOptionPane.showMessageDialog(null, "Choose and item you'd like to delete",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public class EditActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            int i = shopTable.getSelectedRow();

            if (i >= 0) {
                Shop clothing = null;
                try {
                    clothing = new Shop(newName.getText(),newArticle.getText(), newYear.getText(), newSize.getText(),
                            newPrice.getText(), newModel.getText(), newManufacturer.getText(), newColour.getText());
                } catch (DataExсeption dataExсeption) {
                    dataExсeption.printStackTrace();
                }
                shoptablemodel.EditData(i, clothing);
                shoptablemodel.fireTableDataChanged();

            } else {
                System.out.println("Edit Error");
            }


        }
    }

    public class ClickedActionListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            int i = shopTable.getSelectedRow();

            newName.setText(shoptablemodel.getValueAt(i, 0).toString());
            newArticle.setText(shoptablemodel.getValueAt(i, 1).toString());
            newYear.setText(shoptablemodel.getValueAt(i, 2).toString());
            newSize.setText(shoptablemodel.getValueAt(i, 3).toString());
            newPrice.setText(shoptablemodel.getValueAt(i, 4).toString());
            newModel.setText(shoptablemodel.getValueAt(i, 5).toString());
            newManufacturer.setText(shoptablemodel.getValueAt(i, 6).toString());
            newColour.setText(shoptablemodel.getValueAt(i, 7).toString());

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}