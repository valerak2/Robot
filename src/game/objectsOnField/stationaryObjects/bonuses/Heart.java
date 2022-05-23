package game.objectsOnField.stationaryObjects.bonuses;

import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

/**
 * Класс объекта-бонуса "Сердце"
 */
public class Heart extends Bonus {
    /**
     * Конструктор - создание нового объекта
     */
    public Heart(Point position) {
        super(position);
        this.size= 30;
    }

    /**
     * Метод эффекта (Дает роботу одно очко жизни)
     */
    @Override
    public void effect(Robot robot) {
        robot.setLife(robot.getLife() + 1);
    }

}
