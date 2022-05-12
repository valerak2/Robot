package game.objectsOnTheField.stationaryObjects.bonuses;

import game.objectsOnTheField.movingObjects.robot.Robot;
import game.objectsOnTheField.stationaryObjects.StationaryObjects;

import java.awt.*;

public abstract class Bonus extends StationaryObjects {

    public Bonus(Point position) {
        super(position);
    }

    public abstract void effect(Robot robot);

}
