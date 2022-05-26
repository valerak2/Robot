
import game.objectsOnField.movingObjects.enemies.EnemyLogic;
import java.awt.*;

public class Sun implements EnemyLogic {
    public Point position = new Point(100,100);

    public void draw(Graphics2D g) {
        Color color = new Color(0xFFEFDB09, true);
        g.setColor(color);
        g.fillOval(position.x, position.y, 50, 50);
        g.setColor(Color.BLACK);
        g.drawOval(position.x, position.y, 50, 50);
    }


    public int damage() {
        return 0;
    }

    public void move() {

    }
}
