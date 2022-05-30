package game.logic.loadEnemy;

import game.objectsOnField.ObjectOnTheField;
import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

public interface LoadedEnemyLogic {
    void draw(Graphics2D g);
    void damage(Robot robot);
    void move();
    boolean checkCollisions(ObjectOnTheField objectOnTheField);

}
