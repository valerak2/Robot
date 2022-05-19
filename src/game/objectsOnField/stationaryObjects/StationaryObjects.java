package game.objectsOnField.stationaryObjects;

import game.objectsOnField.ObjectOnTheField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * ����� ����������� ����� ��� ���� ����������� �������� �� ������� ����
 */
public abstract class StationaryObjects extends ObjectOnTheField {

    /**
     * ���� ������� ������� �� ����
     */
    protected final Point position;

    /**
     * ����� ��������� �������
     */
    public Point getPosition() {
        return position;
    }
    /**
     * ������ �������
     */
    protected int size = 30;
    /**
     * ����������� - �������� ������ �������
     */
    public StationaryObjects(Point position) {
        this.position = position;
    }

    @Override
    public void draw(Graphics2D g) {
        String pathname = "resource/images/" + getClass().getSimpleName()+".jpg";
        File file = new File(pathname);
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(image, position.x, position.y, size, size, null);


    }

}
