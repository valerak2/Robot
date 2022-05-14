package game.objectsOnField.stationaryObjects.obstacle;

import game.objectsOnField.movingObjects.robot.Robot;
import game.objectsOnField.stationaryObjects.StationaryObjects;

import java.awt.*;

public abstract class Obstacle extends StationaryObjects {
    protected final int damage = 0;

    public Obstacle(Point position) {
        super(position);
    }

    public int getDamage() {
        return damage;
    }

    public abstract void damage(Robot robot);

    @Override
    public boolean checkCollision(Graphics2D g, Robot robot) {
        g.setClip(robot.getPosition().x, robot.getPosition().y, 20, 20);
        if (g.hitClip(position.x, position.y, 30, 30)) {
            damage(robot);
            return true;
        } else return false;
    }


}
