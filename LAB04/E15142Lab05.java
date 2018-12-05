import java.util.*;
import java.io.*;

class Contact{
    private String email, mobile_no;

    public Contact(String email, String mobile_no){
        this.email = email;
        this.mobile_no = mobile_no;
    }

    public String getEmail(){
        return this.email;
    }

    public String getMobileNo(){
        return this.mobile_no;
    }

}

public class E15142Lab05{

    public static Map<String, Integer> firstNameMap = new HashMap<>();
    public static Map<String, Integer> lastNameMap = new HashMap<>();
    public static Map<Integer, Contact> contactListMap = new HashMap<>();

    // Method to create the lists
    public static void createLists(int ID, String fName, String lName, String email, String mobileNo){
        firstNameMap.put(fName, ID);
        lastNameMap.put(lName, ID);
        contactListMap.put(ID, new Contact(email, mobileNo) );
        // System.out.println(ID);
    }

    // A method to test the lists
    public static void testLists(){
        int key = firstNameMap.get("Garey");
        String a = contactListMap.get(key).getEmail();
        System.out.println(a);
    }

    public static void main(String[] args) {
        // HashMap<String, Integer> contactList = new HashMap<String, Integer>();

        
        String CSV_File = "./MOCK_DATA.csv";
        BufferedReader BR = null;
        String row = "";
        String splitter = ",";

        try {

            BR = new BufferedReader(new FileReader(CSV_File));
            int count = 0;
            while ((row = BR.readLine()) != null) {

                // use comma as separator
                String[] data_row = row.split(splitter);
                if (data_row[0].equals("first_name")) {
                    continue;
                }
                // System.out.println("Contact [ First Name = " + data_row[0] + ", Last Name = " + data_row[1] + " , Mobile no. = " + data_row[3] + " ]");
                // firstNameMap.put(data_row[0], count);
                // lastNameMap.put(data_row[1], count);
                // contactListMap.put(count, new Contact(data_row[2], data_row[3]) );
                createLists(count, data_row[0], data_row[1], data_row[2], data_row[3]);
                count++;
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

        System.out.println("Insertion done!");
        testLists();

    }
    
}