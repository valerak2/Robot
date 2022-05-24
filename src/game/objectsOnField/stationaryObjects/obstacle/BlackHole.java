package game.objectsOnField.stationaryObjects.obstacle;

import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

/**
 * ����� �������-����������� "������ ����"
 */
public class BlackHole extends Obstacle {
    /**
     * ����������� - �������� ������ �������
     */
    public BlackHole(Point position) {
        super(position);
        this.size = 100;
    }

    /**
     * ����� ��������� ����� ������ (������� ������)
     */
    @Override
    public void damage(Robot robot) {
        robot.setLife(0);
    }

}
