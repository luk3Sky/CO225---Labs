/*
* CO225 - Software Construction Lab Assignments
* LAB01Q - 1
* ==@luke== 
* E/15/142  
*/

import java.util.Scanner;

public class e15142lab01q1{

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
       }
       if (is_Weird || is_Big){
           is_Scary = true;
       }

/*
      A number is,
        Special =>  if it is exactly divisible by 15
        Big     =>  if it is greater than 999
        Weird   =>  if it is exactly divisible by 5 and 6 but not 18
        Scary   =>  if it is big or weird
*/

        if (is_Special == true) {
            // Special
            System.out.print(input_Number + " is special, ");

            if (is_Big == true) {
                // Special + Big
                System.out.print("big, ");

                if (is_Weird == true) {
                    // Special + Big + Weird + Scary                    = > End
                    System.out.print("weird, scary.\n");
                } else {
                    // Special + Big + Not Weird + Scary                = > End
                    System.out.print("scary, but not weird.\n");
                }
            } else {
                // Special + Not Big

                if (is_Weird == true) {
                    // Special + Weird + Not Big                        = > End
                    System.out.print("weird, scary, but not big.\n");
                } else {
                    // Special + Not Big + Not Weird + Not Scary        = > End
                    System.out.print("but not scary.\n");
                }

            }
        } else {
            if (is_Big == true) {
                // Not Special + Big
                System.out.print(input_Number + " is big, ");
                if (is_Weird == true) {
                    // Not Special + Big + Weird + Scary                = > End
                    System.out.print("big, weird, scary.\n");
                } else {
                    // Not Special + Big + Not Weird + Scary            = > End
                    System.out.print("scary, but not weird.\n");
                }
            } else {
                // Not Special + Not Big
                if (is_Weird == true) {
                    // Not Special + Not Big + Weird + Scary            = > End
                    System.out.print(input_Number + " is weird, scary, but not big.");
                } else {
                    // Not Special + Not Scary                          = > End
                    System.out.print(input_Number + " is not scary.");
                }
            }
        }
    }
}
