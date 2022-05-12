package game.objectsOnTheField.stationaryObjects.bonuses;

import game.objectsOnTheField.movingObjects.robot.Robot;

import java.awt.*;

public class Speed extends Bonus {


    public Speed(Point position) {
        super(position);
    }

    @Override
    public void effect(Robot robot) {

    }

    @Override
    public void draw(Graphics2D g) {
        int x = position.x;
        int y = position.y;
        //int[] onX = { 15, 10, 10, 15, 20, 20};
        //int[] onY = { 10, 15, 20, 15, 20, 15};
        int[] onX = {x, x - 5, x - 5, x, x + 5, x + 5};
        int[] onY = {y, y + 5, y + 10, y + 5, y + 10, y + 5};
        g.setColor(Color.YELLOW);
        g.drawPolygon(onX, onY, 6);
        g.fillPolygon(onX, onY, 6);

    }
}
