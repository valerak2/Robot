package game.objectsOnField.stationaryObjects.bonuses;

import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

public class ResetRobot extends Bonus {
    public ResetRobot(Point position) {
        super(position);
    }

    @Override
    public void draw(Graphics2D g) {
        int x = position.x;
        int y = position.y;
        //int[] onX = { 10, 5, 10, 15};
        //int[] onY = { 20, 15, 10, 15};
        int[] onX = {x, x - 10, x, x + 10};
        int[] onY = {y, y - 10, y - 20, y - 10};
        g.setColor(Color.BLUE);
        g.drawPolygon(onX, onY, 4);
        g.fillPolygon(onX, onY, 4);

    }

    @Override
    public void effect(Robot robot) {
    }

}
