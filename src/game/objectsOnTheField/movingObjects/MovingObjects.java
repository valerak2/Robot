package game.objectsOnTheField.movingObjects;

import game.objectsOnTheField.ObjectOnTheField;

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
