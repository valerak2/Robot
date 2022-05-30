
import game.logic.loadEnemy.LoadedEnemyLogic;
import game.objectsOnField.ObjectOnTheField;
import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

public class Sun implements LoadedEnemyLogic {
    public Point position = new Point(100, 100);

    @Override
    public void draw(Graphics2D g) {
        Color color = new Color(0xFFEFDB09, true);
        g.setColor(color);
        g.fillOval(position.x, position.y, 50, 50);
        g.setColor(Color.BLACK);
        g.drawOval(position.x, position.y, 50, 50);
    }

    @Override
    public void damage(Robot robot) {
        robot.setLife(robot.getLife()-3);
    }

    @Override
    public void move() {
        if (position.y < 1000 & position.y > 0) {
            position = new Point(position.x, position.y + 1);
        } else position = new Point(position.x, 500);
    }


    @Override
    public boolean checkCollisions(ObjectOnTheField object) {
        return (position.x >= object.getPosition().x &
                position.x <= object.getPosition().x + 50)
                &
                (position.y >= object.getPosition().y &
                        position.y <= object.getPosition().y + 50);

    }
}
