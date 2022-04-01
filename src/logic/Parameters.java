package logic;

import java.awt.*;
import java.io.Serializable;
import java.util.Timer;


public class Parameters {
    final Timer timer = new Timer("events generator", true);
    double robotPositionX;  //volatile
    double robotPositionY;  //volatile
    double robotDirection;   //volatile
    int targetPositionX;   //volatile
    int targetPositionY;   //volatile
    public static final double maxAngularVelocity = 0.0022;
    public static final double duration = 30;


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

    public void setRobotPositionX(double robotPositionX) {
        this.robotPositionX = robotPositionX;
    }

    public void setRobotPositionY(double robotPositionY) {
        this.robotPositionY = robotPositionY;
    }

    public void setRobotDirection(double robotDirection) {
        this.robotDirection = robotDirection;
    }

    protected void setTargetPosition(Point p) {
        targetPositionX = p.x;
        targetPositionY = p.y;
    }

    public void builderParameters(double robotPositionX, double robotPositionY, double robotDirection, int targetPositionX, int targetPositionY) {
        this.robotPositionX = robotPositionX;
        this.robotPositionY = robotPositionY;
        this.robotDirection = robotDirection;
        this.targetPositionX = targetPositionX;
        this.targetPositionY = targetPositionY;
    }

}
