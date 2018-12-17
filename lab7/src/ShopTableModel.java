import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;

public class ShopTableModel  extends AbstractTableModel {

    private int columnCount = 8;
    private ArrayList<Shop> dataArrayList;

    public ShopTableModel(){
        dataArrayList = new ArrayList<>();
    }

    public ArrayList<Shop> getDataArrayList() {
        return dataArrayList;
    }

    @Override
    public int getRowCount() {
        return dataArrayList.size(); // количество строк
    }
    public Shop getRow(int i) {
        return dataArrayList.get(i); // возвращает строку с данными объекта
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Shop rows = dataArrayList.get(rowIndex);
        switch(columnIndex){
            case 0: return rows.getName();
            case 1: return rows.getArticle();
            case 2: return rows.getYear();
            case 3: return rows.getSize();
            case 4: return rows.getPrice();
            case 5: return rows.getModel();
            case 6: return rows.getManufacturer();
            case 7: return rows.getColour();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Name";
            case 1: return "Article";
            case 2: return "Date of production";
            case 3: return "Size";
            case 4: return "Price";
            case 5: return "Model";
            case 6: return "Manufacturer";
            case 7: return "Colour";
        }
        return "";
    }

    public void addData(Shop row){
        dataArrayList.add(row);
        dataArrayList.sort(Comparator.comparing(Shop::getName));
    }

    public  ArrayList<Shop> findSimilar(String name){
        ArrayList<Shop>  similarArrayList = new ArrayList<>();
        for(int i = 0; i < dataArrayList.size();i++) {
            Shop row = dataArrayList.get(i);
            String currArtist = row.getName().toLowerCase();
            if (currArtist.equals(name)){
                similarArrayList.add(row);
            }
        }
        return similarArrayList;
    }
    public void EditData (int i, Shop clothing){
        dataArrayList.set(i, clothing);
    }

    public void clear() {
        dataArrayList.clear();
    }

    public void removeRow(int i) {
        dataArrayList.remove(i);
    }
}
