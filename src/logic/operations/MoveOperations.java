package logic.operations;

import logic.Parameters;


import java.awt.geom.Point2D;

import static logic.operations.MathOperations.*;
import static logic.operations.MathOperations.asNormalizedRadians;

public class MoveOperations {
    Parameters p;

    public MoveOperations(Parameters p) {
        this.p = p;
    }

    public Boolean checkDistant() {
        double distance = distance(
                p.getTargetPositionX(),
                p.getTargetPositionY(),
                p.getRobotPositionX(),
                p.getRobotPositionY());
        return !(distance < 0.5);
    }

    public void robotDirection() {
        double angleToTarget = angleTo(
                p.getRobotPositionX(),
                p.getRobotPositionY(),
                p.getTargetPositionX(),
                p.getRobotPositionY());
        double angularVelocity = 0;
        if (angleToTarget > p.getRobotDirection()) {
            angularVelocity = Parameters.maxAngularVelocity;
        }
        if (angleToTarget < p.getRobotDirection()) {
            angularVelocity = -Parameters.maxAngularVelocity;
        }
        angularVelocity = applyLimits(angularVelocity, -Parameters.maxAngularVelocity, Parameters.maxAngularVelocity);
        p.setRobotDirection(p.getRobotDirection() + angularVelocity * Parameters.duration);
    }

    public void moveOnX() {
        if (p.getRobotPositionX() != p.getTargetPositionX()) {
            if (p.getRobotPositionX() < p.getTargetPositionX()) {
                p.setRobotPositionX((p.getRobotPositionX() + 1));
            } else {
                p.setRobotPositionX((p.getRobotPositionX() - 1));
            }
        }
    }

    public void moveOnY() {
        if (p.getRobotPositionY() != p.getTargetPositionY()) {
            if (p.getRobotPositionY() < p.getTargetPositionY()) {
                p.setRobotPositionY((p.getRobotPositionY() + 1));
            } else {
                p.setRobotPositionY((p.getRobotPositionY() - 1));
            }
        }
    }
    /*public void robotDirectionTEST() {
        Point2D.Double robotPoint = new Point2D.Double(p.getRobotPositionX(), p.getRobotPositionY());
        Point2D.Double targetPoint = new Point2D.Double(p.getTargetPositionX(), p.getTargetPositionY());
        if (robotPoint.x != targetPoint.x & robotPoint.y != targetPoint.y) {
            if ((robotPoint.y < targetPoint.y) & (robotPoint.x < targetPoint.x)) {
                p.setRobotDirection(45);
            }
            if ((robotPoint.y > targetPoint.y) & (robotPoint.x < targetPoint.x)) {
                p.setRobotDirection(135);
            }
            if ((robotPoint.y < targetPoint.y) & (robotPoint.x > targetPoint.x)) {
                p.setRobotDirection(225);
            }
            if ((robotPoint.y > targetPoint.y) & (robotPoint.x > targetPoint.x)){
                p.setRobotDirection(315);
            }
        } else if (robotPoint.x != targetPoint.x & robotPoint.y == targetPoint.y) {
            if (robotPoint.x < targetPoint.x) {
                p.setRobotDirection(45);
            } else {
                p.setRobotDirection(215);
            }
        } else if (robotPoint.x == targetPoint.x & robotPoint.y != targetPoint.y) {
            if (robotPoint.y < targetPoint.y) {
                p.setRobotDirection(45);
            } else {
                p.setRobotDirection(215);
            }
        } else if (robotPoint.x == targetPoint.x & robotPoint.y == targetPoint.y) {
            p.setRobotDirection(p.getRobotDirection());
        }
    }*/

}
