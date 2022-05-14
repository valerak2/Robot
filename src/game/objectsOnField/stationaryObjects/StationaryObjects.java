package game.objectsOnField.stationaryObjects;

import game.objectsOnField.ObjectOnTheField;
import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

public abstract class StationaryObjects extends ObjectOnTheField {
    protected final Point position;
    public Point getPosition() {
        return position;
    }
    public StationaryObjects(Point position) {
        this.position = position;
    }
    @Override
    public boolean checkCollision(Graphics2D g, Robot robot) {
        g.setClip(robot.getPosition().x, robot.getPosition().y, 20, 20);
        return g.hitClip(position.x, position.y, 30, 30);

    }

}
