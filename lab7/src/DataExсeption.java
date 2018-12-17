
import javax.swing.*;

public class DataExсeption extends Exception {
    private String info;

    public  DataExсeption (String str){
        info = str;
    }

    public void getInfo(){
        JOptionPane.showMessageDialog(null, this.info,
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}
