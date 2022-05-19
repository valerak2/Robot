package game.objectsOnField.stationaryObjects;

import game.objectsOnField.ObjectOnTheField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Общий абстрактный класс для всех неподвижных объектов на игровом поле
 */
public abstract class StationaryObjects extends ObjectOnTheField {

    /**
     * Поле позиции объекта на поле
     */
    protected final Point position;

    /**
     * Метод получение позиции
     */
    public Point getPosition() {
        return position;
    }
    /**
     * Размер объекта
     */
    protected int size = 30;
    /**
     * Конструктор - создание нового объекта
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
