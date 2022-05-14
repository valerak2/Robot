package game.objectsOnField.stationaryObjects.bonuses;

import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

public class Heart extends Bonus {

    public Heart(Point position) {
        super(position);
    }


    @Override
    public void effect(Robot robot) {
        robot.setLife(robot.getLife() + 1);
    }

    @Override
    public void draw(Graphics2D g) {
        int x = position.x;
        int y = position.y;
        //int[] onX = { 20, 15, 16, 17, 20, 23, 24, 25};
        //int[] onY = { 20, 16, 12, 11, 13, 11, 12, 16};
        int[] onX = {x, x - 10, x - 8, x - 6, x, x + 6, x + 8, x + 10};
        int[] onY = {y, y - 8, y - 16, y - 18, y - 14, y - 18, y - 16, y - 8};
        g.setColor(Color.red);
        g.drawPolygon(onX, onY, 8);
        g.fillPolygon(onX, onY, 8);
    }
}
