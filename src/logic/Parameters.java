package logic;

import java.awt.*;
import java.util.Timer;

class Parameters {

    final Timer timer = new Timer("events generator", true);

    double robotPositionX = 100;  //volatile
    double robotPositionY = 100;  //volatile
    double robotDirection = 0;   //volatile

    int targetPositionX = 150;   //volatile
    int targetPositionY = 100;   //volatile
    
    static final double maxAngularVelocity = 0.0022;
    static final double duration = 10;

    protected void setTargetPosition(Point p) {
        targetPositionX = p.x;
        targetPositionY = p.y;
    }

}
