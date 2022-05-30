package game.objectsOnField.stationaryObjects.obstacle;

import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

/**
 * ����� �������-����������� "����������"
 */
public class Nebula extends Obstacle {
    /**
     * ����������� - �������� ������ �������
     */
    public Nebula(Point position) {
        super(position);
        this.size= 80;
    }
    /**
     * ����� ��������� ����� ������ (��������� ����� ������ ������)
     */
    @Override
    public void damage(Robot robot) {
        robot.setLife(robot.getLife() / 2);
    }
}
