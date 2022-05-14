package game.objectsOnField.stationaryObjects.obstacle;

import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

public class BlackHole extends Obstacle {
    public BlackHole(Point position) {
        super(position);
    }

    @Override
    public void damage(Robot robot) {
        robot.setLife(0);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawOval(position.x, position.y, 100, 100);
        g.setColor(new Color(0xF03607BB, true));
        g.fillOval(position.x, position.y, 100, 100);
    }
}
