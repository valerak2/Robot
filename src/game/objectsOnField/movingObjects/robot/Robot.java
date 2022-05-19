package game.objectsOnField.movingObjects.robot;


import game.objectsOnField.movingObjects.MovingObjects;
import game.objectsOnField.movingObjects.PainterModels;
import game.objectsOnField.movingObjects.Shot;

import java.awt.*;


public class Robot extends MovingObjects {
    public static int score = 0;

    public Robot(Point position,Point target) {
        super(position);
        this.target = target;
        this.painterModels = new PainterModels();
    }

    @Override
    public void draw(Graphics2D g) {
        /*int robotCenterX = PaintOperations.round(position.x);
        int robotCenterY = PaintOperations.round(position.y);
        AffineTransform t = AffineTransform.getRotateInstance(0, robotCenterX, robotCenterY);
        g.setTransform(t);*/
        String figure = CustomizeRobots.getFigureRobots();
        painterModels.paintObject(g, CustomizeRobots.getColorRobots(), figure,
                position.x, position.y, 30, 10);
        painterModels.paintObject(g, Color.WHITE, figure,
                position.x + 10, position.y, 5, 5);

    }

    public void drawTarget(Graphics2D g) {
        painterModels.paintObject(g, Color.GREEN, "Oval",target.x, target.y, 5, 5);
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
