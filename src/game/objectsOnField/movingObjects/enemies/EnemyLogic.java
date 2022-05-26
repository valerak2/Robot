package game.objectsOnField.movingObjects.enemies;

import java.awt.*;

public interface EnemyLogic {
    public void draw(Graphics2D g);
    public int damage();
    public void move();

}
