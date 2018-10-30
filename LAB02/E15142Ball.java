import java.lang.Math;

class Ball{
    // Private attributes of the Ball 
    private double x_pos, y_pos, speed, angle_of_speed, initial_time;

    // Global time for the system
    public static double system_time = 0;

    // Constructor of the Ball Class
    public Ball(double x, double y, double speed, double angleOfSpeedWithX){
        this.x_pos = x;
        this.y_pos = y;
        this.speed = speed;
        this.angle_of_speed = angleOfSpeedWithX;
        this.initial_time = system_time;
    }

    // Getters for the positions
    public double get_x(){
        return this.x_pos;
    }
    public double get_y(){
        return this.y_pos;
    }
    // Getter for the speed
    public double get_speed(){
        return this.speed;
    }
    // Getter for the angle with x
    public double get_angle(){
        return this.angle_of_speed;
    }
    // Getter for the initial time
    public double get_initial_time(){
        return this.initial_time;
    }


    // Update system time
    public static void updateTime(double time){
        system_time = system_time + time;
    }

    // Check collision
    public boolean willCollide(Ball b1){
        double this_new_pos_x = this.get_x() + (this.get_speed() * (Math.cos(this.get_angle())) *(system_time-this.get_initial_time() ) );
        double this_new_pos_y = this.get_y() + (this.get_speed() *(Math.sin(this.get_angle())) * (system_time-this.get_initial_time() ) );
        double other_new_pos_x = b1.get_x() + (b1.get_speed() * (Math.cos(b1.get_angle())) * (system_time-b1.get_initial_time() ) );
        double other_new_pos_y = b1.get_y() + (b1.get_speed() * (Math.sin(b1.get_angle())) * (system_time-b1.get_initial_time() ) );
        
        if( (this_new_pos_x == other_new_pos_x) && (this_new_pos_y == other_new_pos_y) ){
            return true;
        }
        return false;
    }
}

public class E15142Ball{
    public static void main(String[] args) {
        Ball b1 = new Ball(0, 1.0, 10.0, 45.0);
        Ball.updateTime(5.0);
        Ball b2 = new Ball(0, 1.0, 20.0, 45.0);
        Ball.updateTime(5.0);
        if ( b1.willCollide(b2) ){
            System.out.println("B1 and B2 will collide");
        }else{
            System.out.println("B1 and B2 won't collide");
        }
        Ball b3 = new Ball(-10.0, 5.0, 3.0, 30.0);
        Ball.updateTime(20.0);
        
        if ( b2.willCollide(b3) ){
            System.out.println("B2 and B3 will collide");
        }else{
            System.out.println("B2 and B3 won't collide");
        }
    }
}
