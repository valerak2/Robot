package game.objectsOnField.stationaryObjects;

import game.objectsOnField.movingObjects.PainterModels;
import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

/**
 * Класс объекта "очки цели"
 * Роботы собирают очки в течение игры
 */
public class ScorePoint extends StationaryObjects {
    PainterModels painterModels = new PainterModels();
    Color color = new Color(0xFFEFDB09, true);

    /**
     * Конструктор - создание нового объекта
     */
    public ScorePoint(Point position) {
        super(position);
        this.size = 20;
    }

    /**
     * Метод присваивания очков роботу
     */
    public void getScore(Robot robot) {
        Robot.score = Robot.score + 1;
    }

    /**
     * Метод отрисовка очков (желтый круг)
     */
    @Override
    public void draw(Graphics2D g) {
        painterModels.paintObject(g, color, "Oval", position.x, position.y, 20, 20);

    }
}
