package game.objectsOnField.stationaryObjects.obstacle;

import game.objectsOnField.movingObjects.robot.Robot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * ����� �������-����������� "��������"
 */
public class Asteroid extends Obstacle {
    /**
     * ����������� - �������� ������ �������
     */
    public Asteroid(Point position) {
        super(position);
        this.size= 50;
    }

    /**
     * ����� ��������� ����� ������ (������� 1 ���� ������)
     */
    @Override
    public void damage(Robot robot) {
        robot.setLife(robot.getLife() - 1);
    }
}
