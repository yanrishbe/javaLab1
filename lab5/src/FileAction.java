import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileAction {
    protected String outputFilename;
    protected String inputFilename;
    protected RandomAccessFile rafIn;
    protected BufferedReader br;
    protected String choice;
    protected String action;


    FileAction() throws FileNotFoundException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.outputFilename = "out.txt";
        this.inputFilename = "in.txt";
        this.rafIn = new RandomAccessFile(new File(this.inputFilename), "rw");
    }

    public void writeInTxt() {
        System.out.println("Please input information you'd like to add in the file");
        System.out.println("To finish the process please write `ESC`: ");
        try {
            String data;
            while(!(data=br.readLine()).equals("ESC")){
                rafIn.writeBytes(data + "\n");
            }
        } catch (IOException e) {
            System.out.println("ERROR! Writing in the txt.");
        }
    }

    public void writeInPosition() {
        try {
            System.out.println("Please input information you'd like to add in the file: ");
            String data = br.readLine();
            System.out.println("Please input the necessary file position: ");
            Integer pos = Integer.parseInt(br.readLine());
            RandomAccessFile rafOut = new RandomAccessFile(new File(this.outputFilename), "rw");
            rafOut.seek(pos);
            String info = rafOut.readLine();
            rafOut.seek(pos);
            rafOut.writeBytes(data);
            rafOut.writeBytes(info);
        } catch (IOException e) {
            System.out.println("ERROR! Writing at a random place in the txt.");
        }
    }

    public void writeInStart(){
        try {
            System.out.println("Please input information you'd like to add in the file: ");
            RandomAccessFile rafOut = new RandomAccessFile(new File(this.outputFilename), "rw");
            String info = rafOut.readLine();
            String data = br.readLine();
            rafOut.seek(0);
            rafOut.writeBytes(data);
            rafOut.seek(data.length());
            rafOut.writeBytes(info);
        } catch (IOException e){
            System.out.println("ERROR! Writing at the beginning of the txt.");
        }

    }

    public void writeInFinish(){
        try {
            RandomAccessFile rafOut = new RandomAccessFile(new File(this.outputFilename), "rw");
            long fileLength = rafOut.length();
            rafOut.seek(fileLength);
            System.out.println("Please input information you'd like to add in the file: ");
            String data = br.readLine();
            rafOut.writeBytes(data);
        } catch (IOException e){
            System.out.println("ERROR! Writing at the end of the txt.");
        }
    }

    public void readFromTxt() {
        String line;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(this.outputFilename), StandardCharsets.UTF_8))) {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("ERROR! Reading from the txt.");
        }
    }

    public Integer findWordInText(String word) {
        String line;
        int count = 0;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(this.outputFilename), StandardCharsets.UTF_8))) {
            while ((line = reader.readLine()) != null) {
                if (line.contains(word)) {
                    count++;
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR! Finding a word in the text.");
        }
        return count;
    }

    public void runConsole() throws IOException {
        while(true){
                showChoiceMenu();
                this.choice = br.readLine();
                if (this.choice.equals("1")) {
                    readFromTxt();
                    continue;
                }
                else if (this.choice.equals("2")) {
                    while(true) {

                        showActionMenu();
                        this.action = br.readLine();
                        if (this.action.equals("1")) {
                            writeInStart();
                            continue;

                        } else if (this.action.equals("2")) {
                            writeInFinish();
                            continue;
                        } else if (this.action.equals("3")) {
                            writeInPosition();
                            continue;
                        } else if (this.action.equals("4")) {
                            break;
                        } else {
                            System.out.println("Please input an integer from 1 to 4: ");
                            continue;
                        }
                    }


                }
                else if (this.choice.equals("3")){
                    System.out.print("Count of \"Java\" - ");
                    System.out.println(findWordInText("Java"));
                    System.out.print("Count of \"Hello\" - ");
                    System.out.println(findWordInText("Hello"));

                    continue;
                }
                else if (this.choice.equals("4")){
                    writeInTxt();
                    continue;
                }
                else if (this.choice.equals("5")){
                    rafIn.close();
                    br.close();
                    return;
                }
                else
                {
                    System.out.println("Please input an integer from 1 to 5: ");
                    continue;
                }
        }
    }

    public void showActionMenu() {
        System.out.println("Choose an action:");
        System.out.println("1. Add a text at the beginning of the file");
        System.out.println("2. Add a text at the end of the file");
        System.out.println("3. Add a text at any position in the file");
        System.out.println("4. Go back to the first menu");
    }

    public void showChoiceMenu() {
        System.out.println("Input your choice:");
        System.out.println("1.Read a text from a file");
        System.out.println("2.Edit the text right in the file");
        System.out.println("3.Read the text from the file and count the words 'Java' and 'Hello' if there any");
        System.out.println("4.Input a text and write it into the file");
        System.out.println("5.Finish the program");
    }
}