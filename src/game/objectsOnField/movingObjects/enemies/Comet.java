package game.objectsOnField.movingObjects.enemies;

import game.objectsOnField.movingObjects.MovingObjects;
import game.objectsOnField.movingObjects.PainterModels;
import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;
import java.io.IOException;

public class Comet extends MovingObjects {
    Color color = Color.BLUE;
    Boolean moveDirection = true;

    /**
     * Конструктор - создание нового объекта
     *
     * @param position
     */
    public Comet(Point position) {
        super(position);
        this.painterModels = new PainterModels();
    }

    @Override
    public void move() {
        Point newPosition = new Point(moveOnX(), position.y);
        setPosition(newPosition);
    }

    @Override
    public void draw(Graphics2D g) throws IOException {
        painterModels.paintObject(g, color, "Oval", position.x, position.y, 30, 30);
        painterModels.paintObject(g, Color.WHITE, "Oval", position.x + 10, position.y, 5, 5);
    }

    // TODO: 14.05.2022
    public void damage(Robot robot) {
        robot.setColor(Color.BLUE);
        robot.setLife(robot.getLife() - 1);
    }

    private int moveOnX() {
        setMoveDirection();
        if (moveDirection) {
            return (position.x + 1);
        } else return (position.x - 1);
    }

    private void setMoveDirection() {
        if (position.x >= 1920) {
            moveDirection = false;
        }
        if (position.x <= 0) {
            moveDirection = true;
        }
    }

}
