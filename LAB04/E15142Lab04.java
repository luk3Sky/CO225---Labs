/*
* CO225 - Software Construction Lab Assignments
* LAB04
* ==@luke== 
* E/15/142  
*/

import java.util.*;
import java.lang.Character;
import java.io.*;

// Contact object
class Contact{

    // Private variables
    private String first_name, last_name, email, mobile_no;

    public Contact(String f_name, String l_name, String email, String mobile_no){
        this.first_name = f_name;
        this.last_name = l_name;
        this.email = email;
        this.mobile_no = mobile_no;
    }

    // Getters for the private variables
    public String getFirstName(){
        return this.first_name;
    }

    public String getLastName(){
        return this.last_name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getMobileNo(){
        return this.mobile_no;
    }

}

public class E15142Lab04{

    public static Map<Integer, Contact> contactListMap = new HashMap<>();

    // Method to create the lists
    public static void createLists(int ID, String fName, String lName, String email, String mobileNo){
        contactListMap.put(ID, new Contact(fName, lName, email, mobileNo) );
    }

    // Method to process the search
    public static void getResults(String keyString, int type){
        int count = 0;
        if (type == 1) {
            for (Map.Entry<Integer, Contact> var : contactListMap.entrySet()) {
                String keyName = var.getValue().getFirstName();
                if (keyName.equals(keyString)) {
                    count++;
                    System.out.print("Record : " + count + " ");
                    System.out.println(var.getValue().getFirstName() + " "+ var.getValue().getLastName());
                    System.out.println(var.getValue().getMobileNo());
                    System.out.println(var.getValue().getEmail());
                    continue;
                }
            }
        } else {
            for (Map.Entry<Integer, Contact> var : contactListMap.entrySet()) {
                String keyName = var.getValue().getLastName();
                if (keyName.equals(keyString)) {
                    count++;
                    System.out.print("Record : " + count + " ");
                    System.out.println(var.getValue().getFirstName() + " "+ var.getValue().getLastName());
                    System.out.println(var.getValue().getMobileNo());
                    System.out.println(var.getValue().getEmail());
                    continue;
                }
            }
        }
        if (count == 0) {
            System.out.println("No records found!");
        }
    }

    public static void main(String[] args) {
        
        // CSV file 
        String CSV_File = "./contact_list.csv";

        // Buffered Reader
        BufferedReader BR = null;
        String row = "";
        String splitter = ",";

        // Reading the csv file
        try {
            BR = new BufferedReader(new FileReader(CSV_File));
            int count = 1;

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
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter search key: ");
        String[] params = new String[2];
        String searchParams = "";
        String searchKey = "";
        
        // Search processing
        try {
            params =  keyboard.nextLine().split(":");
            searchParams = params[0];
            searchKey = params[1];
        } catch (Exception e) {
            System.out.println("Usage - <param>:<key>\nParams--\nf/F : First name search\nl/L : Last name search\nKey-- Any String");
            keyboard.close();
            return;
        }

        while (true) {
            if ( searchParams.equalsIgnoreCase("f") ) { // For the first name search
                getResults(searchKey, 1);
                break;
            } else if ( searchParams.equalsIgnoreCase("l") ) {  // For the last name search
                getResults(searchKey, 2);
                break;
            } else {
                System.out.println("Usage - <param>:<key>\nParams--\nf/F : First name search\nl/L : Last name search\nKey-- Any String");
                try {
                    params =  keyboard.nextLine().split(":");
                    searchParams = params[0];
                    searchKey = params[1];
                } catch (Exception e) {
                    System.out.println("Usage - <param>:<key>\nParams--\nf/F : First name search\nl/L : Last name search\nKey-- Any String");
                    keyboard.close();
                    return;
                }
                continue;
            }
        }
        keyboard.close();
    }
}
