import java.util.*;
import java.lang.Character;
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

    // Method to test the lists
    public static void testLists(){
        int key = firstNameMap.get("Garey");
        String a = contactListMap.get(key).getEmail();
        System.out.println(a);
    }

    public static void main(String[] args) {
        
        // CSV file 
        String CSV_File = "./contact_list.csv";
        BufferedReader BR = null;
        String row = "";
        String splitter = ",";

        // Reading the csv file
        try {
            BR = new BufferedReader(new FileReader(CSV_File));
            int count = 0;

            while ((row = BR.readLine()) != null) {
                
                // seperate data in the row by comma
                String[] data_row = row.split(splitter);
                if (data_row[0].equals("first_name")) {
                    continue;
                }
                
                // Calling the createLists function
                createLists(count, data_row[0], data_row[1], data_row[2], data_row[3]);
                count++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error : File not found!");
            return;
        } catch (IOException e) {
            System.out.println("Error : IO (Open) Error!");
            return;
        } finally {
            if (BR != null) {
                try {
                    BR.close();
                } catch (IOException e) {
                    System.out.println("Error : IO (Close) Error!");
                    return;
                }
            }
        } // Insertion to the Data Structures is successful!
        
        System.out.println("Insertion done!");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter search key: ");
        String[] params = new String[2];
        String searchParams = "";
        String searchKey = "";
        try {
            params =  keyboard.nextLine().split(":");
            searchParams = params[0];
            searchKey = params[1];
        } catch (Exception e) {
            System.out.println("Usage - <param>:<key>\nParams--\nf/F : First name search\nl/L : Last name search\nKey-- Any String");
            keyboard.close();
            return;
        }
        System.out.println(params[0]);
        // System.out.println(keyParams);
        if ( searchParams.equalsIgnoreCase("f") ) {
            System.out.println("FirstName Search");
        } else if ( searchParams.equalsIgnoreCase("l") ) {
            System.out.println("LastName Search");
        } else {
            System.out.println("Usage - <param>:<key>\nParams--\nf/F : First name search\nl/L : Last name search\nKey-- Any String");
        }
        testLists();
        keyboard.close();
    }
}
