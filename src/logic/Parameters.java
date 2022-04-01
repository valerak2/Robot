package logic;

import java.awt.*;
import java.io.Serializable;
import java.util.Timer;


public class Parameters {


    final Timer timer = new Timer("events generator", true);

    double robotPositionX = 100;  //volatile
    double robotPositionY = 100;  //volatile
    double robotDirection = 0;   //volatile
    int targetPositionX = 150;   //volatile
    int targetPositionY = 100;   //volatile


    public int getTargetPositionX() {
        return targetPositionX;
    }

    public int getTargetPositionY() {
        return targetPositionY;
    }

    public double getRobotPositionX() {
        return robotPositionX;
    }

    public double getRobotPositionY() {
        return robotPositionY;
    }

    public double getRobotDirection() {
        return robotDirection;
    }

    public void Parameters1(double robotPositionX, double robotPositionY, double robotDirection, int targetPositionX, int targetPositionY) {
        this.robotPositionX = robotPositionX;
        this.robotPositionY = robotPositionY;
        this.robotDirection = robotDirection;
        this.targetPositionX = targetPositionX;
        this.robotPositionY = targetPositionY;
    }

    static final double maxAngularVelocity = 0.0022;
    static final double duration = 10;

    protected void setTargetPosition(Point p) {
        targetPositionX = p.x;
        targetPositionY = p.y;
    }

}
