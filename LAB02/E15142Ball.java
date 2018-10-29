// import Ball;
import java.lang.Math;

class E15142Ball{
    public static void main(String[] args) {
        Ball b1 = new Ball(0, 1.0, 10.0, 45.0);
        Ball.updateTime(5.0);
        Ball b2 = new Ball(0, 1.0, 20.0, 45.0);
        Ball.updateTime(5.0);
        b1.willCollide(b2);
        System.out.println(Ball.system_time);
        Ball b3 = new Ball(10.0, 5.0, 3.0, 30.0);
        Ball.updateTime(20.0);
        b2.willCollide(b3);
    }
}