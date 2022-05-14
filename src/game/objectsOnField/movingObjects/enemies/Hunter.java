package game.objectsOnField.movingObjects.enemies;

import game.objectsOnField.movingObjects.MovingObjects;
import game.objectsOnField.movingObjects.robot.CustomizeRobots;
import game.objectsOnField.movingObjects.robot.Robot;
import game.objectsOnField.movingObjects.robot.operations.PaintOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Hunter extends MovingObjects implements PropertyChangeListener {
    public int indexRobot;

    public Hunter(Point position, Point target) {
        super(position);
        this.target = target;
    }

    @Override
    public void draw(Graphics2D g) {
        int robotCenterX = PaintOperations.round(position.x);
        int robotCenterY = PaintOperations.round(position.y);
        String figure = CustomizeRobots.getFigureRobots();
        AffineTransform t = AffineTransform.getRotateInstance(0, robotCenterX, robotCenterY);
        g.setTransform(t);
        g.setColor(new Color(0x831A1A));
        PaintOperations.fillFigure(g, figure, robotCenterX, robotCenterY, 30, 10);
        g.setColor(Color.BLACK);
        PaintOperations.drawFigure(g, figure, robotCenterX, robotCenterY, 30, 10);
        g.setColor(Color.WHITE);
        PaintOperations.fillFigure(g, figure, robotCenterX + 10, robotCenterY, 5, 5);
        g.setColor(Color.BLACK);
        PaintOperations.drawFigure(g, figure, robotCenterX + 10, robotCenterY, 5, 5);

    }

    public void damage(Robot robot) {
        robot.setLife(robot.getLife() - 1);
    }

    @Override
    public void move() {
        Point newPosition = new Point(moveOnX(), moveOnY());
        setPosition(newPosition);

    }

    private int moveOnX() {
        if (position.x != target.x) {
            if (position.x < target.x) {
                return (position.x + 1);
            } else {
                return (position.x - 1);
            }
        }
        return position.x;
    }

    private int moveOnY() {
        if (position.y != target.y) {
            if (position.y < target.y) {
                return (position.y + 1);
            } else {
                return (position.y - 1);
            }
        }
        return position.y;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //printCoordinateRobot((Point) evt.getNewValue());
        Robot[] robots = ((Robot[]) evt.getNewValue());
        hunt(robots[indexRobot]);

    }

    private void hunt(Robot robot) {
        setTarget(robot.getPosition());
    }
}
