package game.objectsOnField.stationaryObjects.obstacle;

import game.objectsOnField.movingObjects.robot.Robot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * ����� �������-����������� "������ ����"
 */
public class BlackHole extends Obstacle {
    /**
     * ����������� - �������� ������ �������
     */
    public BlackHole(Point position) {
        super(position);
        this.size= 100;
    }

    /**
     * ����� ��������� ����� ������ (������� ������)
     */
    @Override
    public void damage(Robot robot) {
        robot.setLife(0);
    }

}
