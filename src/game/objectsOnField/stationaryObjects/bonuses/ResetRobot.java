package game.objectsOnField.stationaryObjects.bonuses;

import game.objectsOnField.movingObjects.robot.CrashedRobot;
import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

/**
 * Класс объекта-бонуса "Воскрешение"
 */
public class ResetRobot extends Bonus {

    private Robot firstRobot;
    private Robot secondRobot;

    /**
     * Конструктор - создание нового объекта
     */
    public ResetRobot(Point position) {
        super(position);
    }

    public void setRobot(Robot firstRobot, Robot secondRobot) {
        this.firstRobot = firstRobot;
        this.secondRobot = secondRobot;
    }

    /**
     * Метод эффекта (воскрешает сломанного робота)
     */
    @Override
    public void effect(Robot robot) {
        if (isRobotCrashed()) {
            System.out.println('f');
        }
    }

    // TODO: 19.05.2022 доделать логику воскрешения роботов
    private Boolean isRobotCrashed() {
        return firstRobot.getLife() == 0
                || secondRobot.getLife() == 0;
    }

    private Robot getCrashedRobot() {
        if (firstRobot.getClass().getName().equals(CrashedRobot.class.getName())) {
            return firstRobot;
        } else {
            return secondRobot;
        }

    }
}
