package game.objectsOnField.stationaryObjects.bonuses;

import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

/**
 * ����� �������-������ "�����������"
 */
public class ResetRobot extends Bonus {
    /**
     * ����������� - �������� ������ �������
     */
    public ResetRobot(Point position) {
        super(position);
    }

    // TODO: 16.05.2022

    /**
     * ����� ������� (���������� ���������� ������)
     */
    @Override
    public void effect(Robot robot) {
        robot.setLife(2);
    }

}
