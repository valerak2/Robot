package game.objectsOnField.stationaryObjects.bonuses;

import game.objectsOnField.movingObjects.robot.Robot;
import game.objectsOnField.stationaryObjects.StationaryObjects;

import java.awt.*;

/**
 * Общий абстрактный класс всех бонусов для роботов
 */
public abstract class Bonus extends StationaryObjects {
    /**
     * Конструктор - создание нового объекта
     */
    public Bonus(Point position) {
        super(position);
    }

    /**
     * Абстрактный метод получения эффекта для робота при столкновении
     */
    public abstract void effect(Robot robot);

}
