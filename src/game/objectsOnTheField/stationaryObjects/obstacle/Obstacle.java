package game.objectsOnTheField.stationaryObjects.obstacle;

import game.objectsOnTheField.movingObjects.robot.Robot;
import game.objectsOnTheField.stationaryObjects.StationaryObjects;

import java.awt.*;

public abstract class Obstacle extends StationaryObjects {
    protected final int damage = 0;

    protected Obstacle(Point position) {
        super(position);
    }

    public int getDamage() {
        return damage;
    }

    public void damage(Robot robot) {
        robot.setLife(robot.getLife() - 1);
    }

    @Override
    public boolean checkCollision(Graphics2D g, Robot robot) {
        g.setClip(robot.getPosition().x, robot.getPosition().y, 20, 20);
        if (g.hitClip(position.x, position.y, 30, 30)) {
            damage(robot);
            return true;
        } else return false;
    }


}
