
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SimilarData extends JFrame{
    JTable similarTable;
    ShopTableModel gtm;

    public SimilarData(ArrayList<Shop> similarArrayList){
        super("Same name clothing");
        setSize(new Dimension(600, 300));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        gtm = new ShopTableModel();
        similarTable = new JTable(gtm);
        add(new JScrollPane(similarTable), BorderLayout.CENTER);
        for(int i = 0; i <  similarArrayList.size();i++){
            gtm.addData(similarArrayList.get(i));
        }
    }
}
