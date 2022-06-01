import java.io.*;
import java.util.Vector;


/**
 * a LogBook who list all actions in the application
 *
 * @author Isuf Hasani
 * @since 2022-06-01
 * @version 1.1
 *
 */
public class LogBook {

    private Vector<String> entries;
    private static LogBook instance;
    private File file;
    private BufferedReader reader;
    private BufferedWriter writer;
    private Boolean fileWritingEnabled = false;

    /**
     * constructor of the class LogBook without parameter
     */
    public LogBook(){
        file = new File("logboook.log");
        try {
            if (file.createNewFile() == false){
                reader = new BufferedReader(new FileReader(file));
                readFile();
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get the logbook instance
     * @return instance
     */
    public LogBook getLogBookInstance(){
        if (instance == null){
            instance = new LogBook();
        }
        return instance;
    }

    /**
     * add entry if writing the file is enable
     * @param entry
     */
    public void addEntry(String entry){
        if (fileWritingEnabled == true){
            writeFile(entry);
        }
    }

    /**
     * get the department that has been saved at the specified location
     * @param index
     * @return entry
     */
    public String getEntry(int index){
        return entries.get(index);
    }

    /**
     * get the size of the Vector
     * @return size of Vector
     */
    public Integer getSize(){
        return entries.size();
    }

    /**
     * Close logbook and end wrting
     */
    public void logBookClose(){
        try {
            writer.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    /**
     * methode for print the logbook data
     */
    public void printLog(){
        for (int i = 0; i < getSize(); i++){
            System.out.println(entries.get(i));
        }
    }

    /**
     * methode for wrting in entry in a file
     * @param entry
     */
    private void writeFile(String entry){
        try {
            writer.append(entry);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * methode for read the file
     */
    private void readFile(){
        while (true) {
            try {
                if (!(reader.ready() == true)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
