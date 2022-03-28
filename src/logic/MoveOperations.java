package logic;

import static logic.MathOperations.*;
import static logic.MathOperations.asNormalizedRadians;

public class MoveOperations {
    Parameters p;
    public MoveOperations(Parameters prm){
        p = prm;
    }
    Boolean checkDistant() {
        double distance = distance(p.targetPositionX,
                p.targetPositionY,
                p.robotPositionX,
                p.robotPositionY);
        return !(distance < 0.5);
    }

    void robotDirection() {
        double angleToTarget = angleTo(p.robotPositionX,
                p.robotPositionY,
                p.targetPositionX,
                p.targetPositionY);
        double angularVelocity = 0;
        if (angleToTarget > p.robotDirection) {
            angularVelocity = Parameters.maxAngularVelocity;
        }
        if (angleToTarget < p.robotDirection) {
            angularVelocity = -Parameters.maxAngularVelocity;
        }
        angularVelocity = applyLimits(angularVelocity, -Parameters.maxAngularVelocity, Parameters.maxAngularVelocity);
        p.robotDirection = asNormalizedRadians(p.robotDirection + angularVelocity * Parameters.duration);
    }
    void moveOnX() {
        if (p.robotPositionX != p.targetPositionX) {
            if (p.robotPositionX < p.targetPositionX) {
                p.robotPositionX++;
            } else {
                p.robotPositionX--;
            }
        }
    }
    void moveOnY() {
        if (p.robotPositionY != p.targetPositionY) {
            if (p.robotPositionY < p.targetPositionY) {
                p.robotPositionY++;
            } else {
                p.robotPositionY--;
            }
        }
    }
}
