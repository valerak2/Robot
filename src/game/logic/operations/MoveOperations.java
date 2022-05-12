package game.logic.operations;


public class MoveOperations {
  /*  Parameters p;

    public MoveOperations(Parameters p) {
        this.p = p;
    }

    public Boolean checkDistant() {
        double distance = distance(
                p.getTargetPositionX(),
                p.getTargetPositionY(),
                p.getX(),
                p.getY());
        return !(distance < 0.5);
    }

    public void robotDirection() {
        double angleToTarget = angleTo(
                p.getX(),
                p.getY(),
                p.getTargetPositionX(),
                p.getY());
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

    public int moveOnX() {
        if (p.getX() != p.getTargetPositionX()) {
            if (p.getX() < p.getTargetPositionX()) {
                return (p.getX() + 1);
            } else {
                return (p.getX() - 1);
            }
        }
        return p.getX();
    }

    public int moveOnY() {
        if (p.getY() != p.getTargetPositionY()) {
            if (p.getY() < p.getTargetPositionY()) {
                return (p.getY() + 1);
            } else {
                return(p.getY() - 1);
            }
        }
        return p.getY();
    }
    public void rotate(double n)
    {
        double rx = (p.getX() * Math.cos(n)) - (p.getY() * Math.sin(n));
        double ry = (p.getX() * Math.sin(n)) + (p.getY() * Math.cos(n));
        //r.setX(rx);
        //r.getY(ry);
    }*/
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
