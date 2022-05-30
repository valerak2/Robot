package game.objectsOnField.stationaryObjects.obstacle;

import game.objectsOnField.movingObjects.robot.Robot;
import game.objectsOnField.stationaryObjects.StationaryObjects;

import java.awt.*;

/**
 * ����� ����������� ����� ���� ����������� ��� �������
 */
public abstract class Obstacle extends StationaryObjects {
    /**
     * ����������� - �������� ������ �������
     */
    public Obstacle(Point position) {
        super(position);
    }

    /**
     * ����������� ����� ��������� ����� ������ ��� ������������
     */
    public abstract void damage(Robot robot);


}
