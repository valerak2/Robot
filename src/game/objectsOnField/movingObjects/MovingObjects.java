package game.objectsOnField.movingObjects;

import game.objectsOnField.ObjectOnTheField;

import java.awt.*;

/**
 * ����� ����������� ����� ��� ���� ���������� �������� �� ������� ����
 */
// TODO: 17.05.2022 �������: direction, color, fiqure
public abstract class MovingObjects extends ObjectOnTheField {
    /**
     * ���� ����� ���� �������
     */
    protected Point target;
    protected double direction;
    /**
     * ���� ����� ����� �������
     */
    protected int life;
    protected Color color;
    protected PainterModels painterModels;

    /**
     * ����������� - �������� ������ �������
     */
    protected MovingObjects(Point position) {
        this.setPosition(position);
    }

    /**
     * ����������� ����� �������� �������
     */
    abstract public void move();

    /**
     * ����� ��������� ������� �������
     */
    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * ����� ��������� ������� ���� �������
     */
    public Point getTarget() {
        return target;
    }

    /**
     * ����� ��������� ������� ���� �������
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
     * ����� ��������� ����� ����� �������
     */
    public int getLife() {
        return life;
    }

    /**
     * ����� ��������� ����� ����� �������
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
