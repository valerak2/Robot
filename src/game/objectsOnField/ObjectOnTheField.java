package game.objectsOnField;

import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

public abstract class ObjectOnTheField {
    public abstract void draw(Graphics2D g);
    public abstract boolean checkCollision(Graphics2D g, Robot robot);
}
