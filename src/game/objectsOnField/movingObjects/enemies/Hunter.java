package game.objectsOnField.movingObjects.enemies;

import game.objectsOnField.movingObjects.MovingObjects;
import game.objectsOnField.movingObjects.PainterModels;
import game.objectsOnField.movingObjects.robot.CustomizeRobots;
import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Hunter extends MovingObjects implements PropertyChangeListener {
    public int indexRobot;
    Color color = new Color(0x831A1A);
    /**
     * Конструктор - создание нового объекта
     *
     * @param position
     */
    public Hunter(Point position, Point target) {
        super(position);
        this.target = target;
        this.painterModels = new PainterModels();
        this.size = 30;
    }

    @Override
    public void draw(Graphics2D g) {
        String figure = CustomizeRobots.getFigureRobots();
        painterModels.paintObject(g, color, figure, position.x, position.y, 30, 10);
        painterModels.paintObject(g, Color.WHITE,figure, position.x + 10, position.y, 5, 5);

    }

    public void damage(Robot robot) {
        robot.setLife(robot.getLife() - 1);
    }

    @Override
    public void move() {
        Point newPosition = new Point(moveOnX(), moveOnY());
        setPosition(newPosition);

    }

    private int moveOnX() {
        if (position.x != target.x) {
            if (position.x < target.x) {
                return (position.x + 1);
            } else {
                return (position.x - 1);
            }
        }
        return position.x;
    }

    private int moveOnY() {
        if (position.y != target.y) {
            if (position.y < target.y) {
                return (position.y + 1);
            } else {
                return (position.y - 1);
            }
        }
        return position.y;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //printCoordinateRobot((Point) evt.getNewValue());
        Robot[] robots = ((Robot[]) evt.getNewValue());
        hunt(robots[indexRobot]);

    }

    private void hunt(Robot robot) {
        setTarget(robot.getPosition());
    }
}
