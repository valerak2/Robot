package game.objectsOnField.movingObjects.enemies;

import game.objectsOnField.movingObjects.MovingObjects;
import game.objectsOnField.movingObjects.PainterModels;
import game.objectsOnField.movingObjects.Shot;

import java.awt.*;
import java.io.IOException;


// TODO: 14.05.2022
public class Cruiser extends MovingObjects {
    /**
     * Конструктор - создание нового объекта
     */
    public Cruiser(Point position, Point target) {
        super(position);
        this.target = target;
        this.painterModels = new PainterModels();
    }

    @Override
    public void draw(Graphics2D g) throws IOException {
        //        int x = position.x;
        //        int y = position.y;
        //        int[] onX = {x, x - 5, x - 5, x, x + 5, x + 5};
        //        int[] onY = {y, y + 5, y + 10, y + 5, y + 10, y + 5}
        //        g.drawPolygon(onX, onY, 6);
        //        g.fillPolygon(onX, onY, 6);
        painterModels.paintObject(g, new Color(0xFF55E525, true),
                "Oval", position.x, position.y, 50, 50);
        painterModels.paintObject(g, new Color(0xFF5F2672, true),
                "Oval", position.x, position.y, 30, 30);
    }

    @Override
    public void move() {
        /*Point newPosition = new Point(logicMove());
        setPosition(newPosition);*/
    }

    private void logicMove() {
       /* int n = 90;
        int rx = (int)(position.x * Math.cos(n)) - (position.y * Math.sin(n));
        int ry = (int) (position.x * Math.sin(n)) + (position.y * Math.cos(n));
        return new Point(rx, PaintOperations.round(ry));*/
    }
    public Shot shot(){
        return new Shot(position);
    }

}
