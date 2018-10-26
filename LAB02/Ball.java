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

    // Update system time
    public static void updateTime(double time){
        system_time = system_time + time;
    }

    // Check collision
    public void willCollide(Ball b1){
        
    }
}