package game.objectsOnField;

import java.awt.*;
import java.io.IOException;

/**
 * ����� ����������� ����� ��� ���� �������� �� ������� ����
 */
public abstract class ObjectOnTheField {
    /**
     * ������ �������
     */
    protected int size;

    /**
     * ���� ������� ������� �� ����
     */
    protected Point position;

    public int getSize() {
        return size;
    }

    /**
     * ����� ��������� �������
     */
    public Point getPosition() {
        return position;
    }

    /**
     * ����� �������� �� ������������ � ������� ���������
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
     * ����� ��������� �������
     */
    public abstract void draw(Graphics2D g) throws IOException;

}
