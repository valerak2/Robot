package game.objectsOnField.movingObjects.robot;


import game.objectsOnField.movingObjects.MovingObjects;
import game.objectsOnField.movingObjects.Shot;
import game.objectsOnField.movingObjects.robot.operations.PaintOperations;

import java.awt.*;
import java.awt.geom.AffineTransform;


public class Robot extends MovingObjects {
    public static int score = 0;
    public Robot(Point position,Point target) {
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
        g.setColor(CustomizeRobots.getColorRobots());
        PaintOperations.fillFigure(g, figure, robotCenterX, robotCenterY, 30, 10);
        g.setColor(Color.BLACK);
        PaintOperations.drawFigure(g, figure, robotCenterX, robotCenterY, 30, 10);
        g.setColor(Color.WHITE);
        PaintOperations.fillFigure(g, figure, robotCenterX + 10, robotCenterY, 5, 5);
        g.setColor(Color.BLACK);
        PaintOperations.drawFigure(g, figure, robotCenterX + 10, robotCenterY, 5, 5);

    }

    public void drawTarget(Graphics2D g) {
        //AffineTransform t = AffineTransform.getRotateInstance(0, 0, 0);
        //g.setTransform(t);
        g.setColor(Color.GREEN);
        g.fillOval(target.x, target.y, 5, 5);
        g.setColor(Color.BLACK);
        g.drawOval(target.x, target.y, 5, 5);
    }


    @Override
    public void move() {
        Point newPosition = new Point(moveOnX(),moveOnY());
        setPosition(newPosition);

    }

    private int moveOnX() {
        if (position.x != target.x) {
            if (position.x < target.x) {
                return (position.x + 1);
            } else {
                return(position.x - 1);
            }
        }
        return position.x;
    }
    private int moveOnY() {
       if (position.y != target.y) {
            if (position.y < target.y) {
                return (position.y + 1);
            } else {
                return(position.y - 1);
            }
        }
        return position.y;
    }
    public Shot shot(){
        return new Shot(position);
    }
}
