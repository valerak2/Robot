package game.objectsOnField;

import java.awt.*;
import java.io.IOException;

/**
 * Общий абстрактный класс для всех объектов на игровом поле
 */
public abstract class ObjectOnTheField {
    /**
     * Размер объекта
     */
    protected int size;

    /**
     * Поле позиции объекта на поле
     */
    protected Point position;

    public int getSize() {
        return size;
    }

    /**
     * Метод получение позиции
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Метод проверка на столкновения с другими объектами
     */
    public boolean checkCollision(ObjectOnTheField object) {
        //
        return (getPosition().x >= object.getPosition().x &
                getPosition().x <= object.getPosition().x + getSize())
                &
                (getPosition().y >= object.getPosition().y &
                        getPosition().y <= object.getPosition().y + getSize());

    }

    /**
     * Метод отрисовка объекта
     */
    public abstract void draw(Graphics2D g) throws IOException;

}
