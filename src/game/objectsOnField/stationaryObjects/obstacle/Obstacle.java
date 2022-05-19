package game.objectsOnField.stationaryObjects.obstacle;

import game.objectsOnField.movingObjects.robot.Robot;
import game.objectsOnField.stationaryObjects.StationaryObjects;

import java.awt.*;

/**
 * Общий абстрактный класс всех препятствий для роботов
 */
public abstract class Obstacle extends StationaryObjects {
    /**
     * Конструктор - создание нового объекта
     */
    public Obstacle(Point position) {
        super(position);
    }

    /**
     * Абстрактный метод нанесения урона роботу при столкновении
     */
    public abstract void damage(Robot robot);


}
