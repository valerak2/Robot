package game.objectsOnField.stationaryObjects.bonuses;

import game.objectsOnField.movingObjects.robot.Robot;
import game.objectsOnField.stationaryObjects.StationaryObjects;

import java.awt.*;

public abstract class Bonus extends StationaryObjects {

    public Bonus(Point position) {
        super(position);
    }

    public abstract void effect(Robot robot);

}
