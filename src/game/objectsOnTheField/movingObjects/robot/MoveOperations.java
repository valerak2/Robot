package game.objectsOnTheField.movingObjects.robot;

public class MoveOperations {

  /*  public void rotate(double n)
    {
        double rx = (r.getX() * Math.cos(n)) - (r.getY() * Math.sin(n));
        double ry = (r.getX() * Math.sin(n)) + (r.getY() * Math.cos(n));
        //r.setX(rx);
        //r.getY(ry);
    }*/
    /*public Boolean checkDistant() {
        double distance = distance(
                t.targetPositionX(),
                t.targetPositionY(),
                r.robotPositionX(),
                r.robotPositionY());
        return !(distance < 0.5);
    }

    public double robotDirection() {
        double angleToTarget = angleTo(
                r.robotPositionX(),
                r.robotPositionY(),
                t.targetPositionX(),
                t.targetPositionX());
        double angularVelocity = 0;
        if (angleToTarget > r.robotDirection()) {
            angularVelocity = Parameters.maxAngularVelocity;
        }
        if (angleToTarget < r.robotDirection()) {
            angularVelocity = -Parameters.maxAngularVelocity;
        }
        angularVelocity = applyLimits(angularVelocity, -Parameters.maxAngularVelocity, Parameters.maxAngularVelocity);
        double newDirection =r.robotDirection() + angularVelocity * Parameters.duration;
        return newDirection;
    }*/
/*
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
    }*/
}
