package game.objectsOnField.stationaryObjects.obstacle;

import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

public class Nebula extends Obstacle {
    public Nebula(Point position) {
        super(position);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawRect(position.x, position.y, 50, 50);
        g.setColor(new Color(0xDAFF4FDD, true));
        g.fillRect(position.x, position.y, 50, 50);

    }

    @Override
    public void damage(Robot robot) {
        robot.setLife(robot.getLife() / 2);
    }
}
