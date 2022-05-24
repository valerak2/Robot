package game.objectsOnField.stationaryObjects.obstacle;

import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

/**
 * Класс объекта-препятствия "Астеройд"
 */
public class Asteroid extends Obstacle {
    /**
     * Конструктор - создание нового объекта
     */
    public Asteroid(Point position) {
        super(position);
        this.size = 50;
    }

    /**
     * Метод нанесения урона роботу (наносит 1 урон роботу)
     */
    @Override
    public void damage(Robot robot) {
        robot.setLife(robot.getLife() - 1);
    }
}
