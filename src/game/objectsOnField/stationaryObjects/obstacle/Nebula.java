package game.objectsOnField.stationaryObjects.obstacle;

import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

/**
 * Класс объекта-препятствия "Туманность"
 */
public class Nebula extends Obstacle {
    /**
     * Конструктор - создание нового объекта
     */
    public Nebula(Point position) {
        super(position);
        this.size= 80;
    }
    /**
     * Метод нанесения урона роботу (уменьшает жизнь робота вдовое)
     */
    @Override
    public void damage(Robot robot) {
        robot.setLife(robot.getLife() / 2);
    }
}
