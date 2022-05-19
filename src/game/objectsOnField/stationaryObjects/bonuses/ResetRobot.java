package game.objectsOnField.stationaryObjects.bonuses;

import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

/**
 * Класс объекта-бонуса "Воскрешение"
 */
public class ResetRobot extends Bonus {
    /**
     * Конструктор - создание нового объекта
     */
    public ResetRobot(Point position) {
        super(position);
    }

    // TODO: 16.05.2022

    /**
     * Метод эффекта (воскрешает сломанного робота)
     */
    @Override
    public void effect(Robot robot) {
        robot.setLife(2);
    }

}
