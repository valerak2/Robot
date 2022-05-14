package game.objectsOnField.movingObjects.robot;

import game.objectsOnField.movingObjects.Shot;
import game.objectsOnField.movingObjects.robot.operations.PaintOperations;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class CrashedRobot extends Robot{
    final int life = 0;
    public CrashedRobot(Point position, Point target) {
        super(position, target);
    }
    @Override
    public void move() {
    }
    @Override
    public void draw(Graphics2D g) {
        int robotCenterX = PaintOperations.round(position.x);
        int robotCenterY = PaintOperations.round(position.y);
        String figure = CustomizeRobots.getFigureRobots();
        AffineTransform t = AffineTransform.getRotateInstance(0, robotCenterX, robotCenterY);
        g.setTransform(t);
        g.setColor(Color.BLACK);
        PaintOperations.drawFigure(g, figure, robotCenterX, robotCenterY, 30, 10);
        g.setColor(Color.WHITE);
        PaintOperations.fillFigure(g, figure, robotCenterX + 10, robotCenterY, 5, 5);
        g.setColor(Color.BLACK);
        PaintOperations.drawFigure(g, figure, robotCenterX + 10, robotCenterY, 5, 5);

    }
    @Override
    public Shot shot(){
        return null;
    }
}
