package game.objectsOnField.stationaryObjects.obstacle;

import game.objectsOnField.movingObjects.robot.Robot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Asteroid extends Obstacle {

    public Asteroid(Point position) {
        super(position);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawOval(position.x, position.y, 25, 25);
        g.setColor(Color.GRAY);
        g.fillOval(position.x, position.y, 25, 25);

    }

    @Override
    public void damage(Robot robot) {
        robot.setLife(robot.getLife() - 1);
    }
}
