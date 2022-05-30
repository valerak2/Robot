package game.objectsOnField.movingObjects.enemies;

import game.objectsOnField.movingObjects.MovingObjects;
import game.objectsOnField.movingObjects.PainterModels;
import game.objectsOnField.movingObjects.Shot;
import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;
import java.io.IOException;


public class Cruiser extends MovingObjects {
    public Cruiser(Point position, Point target) {
        super(position);
        this.target = target;
        this.painterModels = new PainterModels();
    }

    @Override
    public void draw(Graphics2D g) throws IOException {
        painterModels.paintObject(g, new Color(0xFF55E525, true),
                "Oval", position.x, position.y, 50, 50);
        painterModels.paintObject(g, new Color(0xFF5F2672, true),
                "Oval", position.x, position.y, 30, 30);
    }

    @Override
    public void move() {
        if (position.y < 1000 & position.y > 0) {
            position = new Point(position.x, position.y + 1);
        } else position = new Point(position.x, 200);

    }
    public void damage(Robot robot) {
        robot.setLife(robot.getLife() - 2);
    }
}
