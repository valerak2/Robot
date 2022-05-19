package game.objectsOnField.movingObjects;

import game.objectsOnField.ObjectOnTheField;

import java.awt.*;

/**
 * Общий абстрактный класс для всех движущихся объектов на игровом поле
 */
// TODO: 17.05.2022 сделать: direction, color, fiqure
public abstract class MovingObjects extends ObjectOnTheField {
    /**
     * Поле точки цели объекта
     */
    protected Point target;
    protected double direction;
    /**
     * Поле очков жизни объекта
     */
    protected int life;
    protected Color color;
    protected PainterModels painterModels;

    /**
     * Конструктор - создание нового объекта
     */
    protected MovingObjects(Point position) {
        this.setPosition(position);
    }

    /**
     * Абстрактный метод движения объекта
     */
    abstract public void move();

    /**
     * Метод установки позиции объекта
     */
    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * Метод получения позиции цели объекта
     */
    public Point getTarget() {
        return target;
    }

    /**
     * Метод установки позиции цели объекта
     */
    public void setTarget(Point target) {
        this.target = target;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    /**
     * Метод получения очков жизни объекта
     */
    public int getLife() {
        return life;
    }

    /**
     * Метод установки очков жизни объекта
     */
    public void setLife(int life) {
        this.life = life;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
