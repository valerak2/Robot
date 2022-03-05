package logic;

import java.awt.*;
import java.util.Timer;

class Parameters {

    final Timer timer = new Timer("events generator", true);

    volatile double robotPositionX = 100;
    volatile double robotPositionY = 100;
    volatile double robotDirection = 0;

    volatile int targetPositionX = 150;
    volatile int targetPositionY = 100;

    static final double maxVelocity = 0.1;
    static final double maxAngularVelocity = 0.001;


    protected void setTargetPosition(Point p) {
        targetPositionX = p.x;
        targetPositionY = p.y;
    }
}
