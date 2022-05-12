package game.objectsOnTheField.stationaryObjects;

import game.objectsOnTheField.movingObjects.robot.Robot;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class TargetPoint extends StationaryObjects {
    public TargetPoint(Point position) {
        super(position);
    }

    private void getScore(Robot robot) {
        Robot.score = Robot.score + 1;
    }

    @Override
    public void draw(Graphics2D g) {
        AffineTransform t = AffineTransform.getRotateInstance(0, 0, 0);
        g.setTransform(t);
        g.setColor(Color.BLACK);
        g.drawOval(position.x, position.y, 10, 10);
        g.setColor(new Color(0xFFEFDB09, true));
        g.fillOval(position.x, position.y, 10, 10);
    }
}
