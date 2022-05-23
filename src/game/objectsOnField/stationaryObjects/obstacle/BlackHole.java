package game.objectsOnField.stationaryObjects.obstacle;

import game.objectsOnField.movingObjects.robot.Robot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Класс объекта-препятствия "Черная дыра"
 */
public class BlackHole extends Obstacle {
    /**
     * Конструктор - создание нового объекта
     */
    public BlackHole(Point position) {
        super(position);
        this.size= 100;
    }

    /**
     * Метод нанесения урона роботу (убивает робота)
     */
    @Override
    public void damage(Robot robot) {
        robot.setLife(0);
    }

}
