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

    /**
     * ����� ��������� �������
     */
    public Point getPosition() {
        return position;
    }

    /**
     * ����� �������� �� ������������ � ������� ���������
     */
    public boolean checkCollision(Graphics2D g, ObjectOnTheField object) {
        //
        return (getPosition().x >= object.getPosition().x &
                getPosition().x <= object.getPosition().x + size)
                &
                (getPosition().y >= object.getPosition().y &
                        getPosition().y <= object.getPosition().y + size);

    }

    /**
     * ����� ��������� �������
     */
    public abstract void draw(Graphics2D g) throws IOException;

}
