/*
* LAB01Q - 2
* ==@luke== 
* E/15/142
*/

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
       boolean is_Big = false;
       boolean is_Special = false;
       boolean is_Weird = false;
       boolean is_Scary = false;

       System.out.print("Enter a number: ");
       int input_Number = keyboard.nextInt();

       if (input_Number > 999){
           is_Big = true;
       }
       if ( input_Number % 15 == 0){
           is_Special = true;
       }
       if ( (input_Number % 5 == 0) && (input_Number % 6 == 0) && (!(input_Number % 18 == 0))){
           is_Weird = true;
           System.out.println("Weird");
       }
       if (is_Weird || is_Big){
           is_Scary = true;
       }

        if ( (is_Special == true) && (is_Weird == true) && (is_Scary == true) && (is_Big == true) ) {
            System.out.print(input_Number + " is special, weird, scary and big.");
        }else if( (is_Special == true) && (is_Weird == true) && (is_Scary == true) && (is_Big == false) ){
            System.out.print(input_Number + " is special, weird and scary but not big.");
        }else if( (is_Special == true) && (is_Weird == true) && (is_Big == true) ){
            System.out.print(input_Number + " is special, weird, scary and big.");
        }else if( (is_Special == true) && (is_Weird == false) && (is_Big == false) ){
            System.out.print(input_Number + " is special but not scary.");
        }else if( (is_Special == false) && (is_Weird == false) && (is_Big == false) ){
            System.out.print(input_Number + " is not special.");
        }

    }
}
