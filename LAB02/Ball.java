
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
        double this_new_pos_x = this.get_x() + (this.get_speed()*Math.cos(this.get_angle())*10);
        double this_new_pos_y = this.get_y() + (this.get_speed()*Math.sin(this.get_speed())*10);
        double other_new_pos_x = b1.get_x() + (b1.get_speed()*Math.cos(b1.get_angle())*5);
        double other_new_pos_y = b1.get_y() + (b1.get_speed()*Math.sin(b1.get_angle())*5);
        
        System.out.println(system_time);
        System.out.println(this_new_pos_x);
        System.out.println(this_new_pos_y);
        System.out.println(other_new_pos_x);
        System.out.println(other_new_pos_y);
    }
}