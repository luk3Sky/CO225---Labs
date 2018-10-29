// import Ball;
import java.lang.Math;

class Ball{
    
    // Private attributes of the Ball 
    private double x_pos, y_pos, speed, angle_of_speed;
    
    // Global time for the system
    public static double system_time = 0;

    // Constructor of the Ball Class
    public Ball(double x, double y, double speed, double angleOfSpeedWithX){
        this.x_pos = x;
        this.y_pos = y;
        this.speed = speed;
        this.angle_of_speed = angleOfSpeedWithX;
    }

    // Getters for the positions
    public double get_x(){
        return this.x_pos;
    }
    public double get_y(){
        return this.y_pos;
    }
    // Getters for the speed
    public double get_speed(){
        return this.speed;
    }
    // Getters for the angle with x
    public double get_angle(){
        return this.angle_of_speed;
    }

    // Update system time
    public static void updateTime(double time){
        system_time = system_time + time;
    }

    // Check collision
    public void willCollide(Ball b1){
        double this_new_pos_x = this.x_pos + (this.speed*Math.cos(this.angle_of_speed)*system_time);
        double this_new_pos_y = this.y_pos + (this.speed*Math.sin(this.angle_of_speed)*system_time);
        double other_new_pos_x = b1.get_x() + (this.get_speed()*Math.cos(this.get_angle())*system_time);
        double other_new_pos_y = b1.get_y() + (this.get_speed()*Math.sin(this.get_angle())*system_time);

        System.out.println(this_new_pos_x);

    }
}
class E15142Ball{
    public static void main(String[] args) {
        Ball b = new Ball(0, 1.0, 10.0, 45.0);
        // updateTime();
    }
}