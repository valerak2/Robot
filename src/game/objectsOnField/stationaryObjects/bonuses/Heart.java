package game.objectsOnField.stationaryObjects.bonuses;

import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

/**
 * ����� �������-������ "������"
 */
public class Heart extends Bonus {
    /**
     * ����������� - �������� ������ �������
     */
    public Heart(Point position) {
        super(position);
        this.size= 30;
    }

    /**
     * ����� ������� (���� ������ ���� ���� �����)
     */
    @Override
    public void effect(Robot robot) {
        robot.setLife(robot.getLife() + 1);
    }

}
