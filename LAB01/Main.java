import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the color: ");
        int red_color = keyboard.nextInt();
        int green_color = keyboard.nextInt();
        int blue_color = keyboard.nextInt();
        int complemet_red_color,complemet_green_color,complemet_blue_color;

        complemet_red_color = 255 - red_color;
        complemet_green_color = 255 - green_color;
        complemet_blue_color = 255 - blue_color;

        // if( (red_color <= 144 && red_color >= 112 ) && (red_color <= 144 && blue_color >= 112 ) && (blue_color <= 144 && blue_color >= 112 ) ){
        //     System.out.println("FOUND!");
        //     complemet_red_color = ((red_color < 128)?red_color+128 : red_color-128);
        //     complemet_green_color = ((green_color < 128)?green_color+128 : green_color-128);
        //     complemet_blue_color = ((blue_color < 128)?blue_color+128 : blue_color-128);
        // }else{
        //     complemet_red_color = 255 - red_color;
        //     complemet_green_color = 255 - green_color;
        //     complemet_blue_color = 255 - blue_color;
        // }


        if ( ((complemet_red_color <= red_color+32)&&(complemet_red_color >= red_color-32)) && ((complemet_green_color <= green_color+32)&&(complemet_green_color >= green_color-32)) && ((complemet_blue_color <= blue_color+32)&&(complemet_blue_color >= blue_color-32)) ) {
            complemet_red_color = ((red_color < 128)?red_color+128 : red_color-128);
            if (red_color <= 128) {
                
            } else {
                
            }
            complemet_green_color = ((green_color < 128)?green_color+128 : green_color-128);
            complemet_blue_color = ((blue_color < 128)?blue_color+128 : blue_color-128);
        }
        
        System.out.print("The complement: "+ complemet_red_color + " " + complemet_green_color + " " + complemet_blue_color);
    }
}