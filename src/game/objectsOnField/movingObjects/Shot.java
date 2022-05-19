package game.objectsOnField.movingObjects;

import java.awt.*;

/**
 * ����� ������� "�������"
 * ������� ������������ �������
 *
 * @see game.objectsOnField.movingObjects.robot.Robot
 */
public class Shot extends MovingObjects {
    Color color = Color.red;

    /**
     * ����������� - �������� ������ �������
     */
    public Shot(Point position) {
        super(position);
        this.painterModels = new PainterModels();
    }

    /**
     * ����� ��������� "��������" (������� ������)
     */
    @Override
    public void draw(Graphics2D g) {
        painterModels.paintObject(g, color, "Oval",
                position.x, position.y, 5, 5);
    }
    /**
     * ����� �������� "��������"
     */
    // TODO: 17.05.2022 ������� ������
    @Override
    public void move() {
        Point newPosition = new Point(moveOnX(), moveOnY());
        setPosition(newPosition);

    }

    public int moveOnX() {
        if (position.x != target.x) {
            if (position.x < target.x) {
                return (position.x + 1);
            } else {
                return (position.x - 1);
            }
        }
        return position.x;
    }

    public int moveOnY() {
        if (position.y != target.y) {
            if (position.y < target.y) {
                return (position.y + 1);
            } else {
                return (position.y - 1);
            }
        }
        return position.y;
    }
}
