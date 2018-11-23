import java.util.*;
import java.io.*;

public class E15142Lab05{

    public static void main(String[] args) {
        // HashMap<String, Integer> contactList = new HashMap<String, Integer>();

        String CSV_File = "./MOCK_DATA.csv";
        BufferedReader BR = null;
        String row = "";
        String splitter = ",";

        try {

            BR = new BufferedReader(new FileReader(CSV_File));
            while ((row = BR.readLine()) != null) {

                // use comma as separator
                String[] data_row = row.split(splitter);
                if (data_row[0].equals("first_name")) {
                    continue;
                }
                System.out.println("Contact [ Name = " + data_row[0] + " , Mobile no. = " + data_row[3] + " ]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (BR != null) {
                try {
                    BR.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    

}