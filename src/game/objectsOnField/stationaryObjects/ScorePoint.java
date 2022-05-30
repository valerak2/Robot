package game.objectsOnField.stationaryObjects;

import game.objectsOnField.movingObjects.PainterModels;
import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

/**
 * ����� ������� "���� ����"
 * ������ �������� ���� � ������� ����
 */
public class ScorePoint extends StationaryObjects {
    PainterModels painterModels = new PainterModels();
    Color color = new Color(0xFFEFDB09, true);

    /**
     * ����������� - �������� ������ �������
     */
    public ScorePoint(Point position) {
        super(position);
        this.size = 20;
    }

    /**
     * ����� ������������ ����� ������
     */
    public void getScore(Robot robot) {
        Robot.score = Robot.score + 1;
    }

    /**
     * ����� ��������� ����� (������ ����)
     */
    @Override
    public void draw(Graphics2D g) {
        painterModels.paintObject(g, color, "Oval", position.x, position.y, 20, 20);

    }
}
