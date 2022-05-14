package game.objectsOnField.movingObjects;

import game.objectsOnField.ObjectOnTheField;
import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

public abstract class MovingObjects extends ObjectOnTheField {
    protected Point position;
    protected Point target;
    protected double direction;
    protected int life;
    protected Color color;
    protected String figure;
    protected MovingObjects(Point position) {
        this.setPosition(position);
    }


    abstract public void move();
    @Override
    public boolean checkCollision(Graphics2D g, Robot robot) {
        g.setClip(robot.getPosition().x, robot.getPosition().y, 20, 20);
        return g.hitClip(position.x, position.y, 30, 30);

    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Point getTarget() {
        return target;
    }

    public void setTarget(Point target) {
        this.target = target;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }
}
