package game.objectsOnField.stationaryObjects.obstacle;

import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

/**
 * ����� �������-����������� "��������"
 */
public class Asteroid extends Obstacle {
    /**
     * ����������� - �������� ������ �������
     */
    public Asteroid(Point position) {
        super(position);
        this.size = 50;
    }

    /**
     * ����� ��������� ����� ������ (������� 1 ���� ������)
     */
    @Override
    public void damage(Robot robot) {
        robot.setLife(robot.getLife() - 1);
    }
}
