
import game.logic.loadEnemy.LoadedEnemyLogic;
import game.objectsOnField.ObjectOnTheField;
import game.objectsOnField.movingObjects.robot.Robot;

import java.awt.*;

public class Star implements LoadedEnemyLogic {
    public Point position = new Point(500, 500);
    @Override
    public void draw(Graphics2D g) {
        g.setColor(new Color(0xFFE709EF, true));
        g.fillOval(position.x+10, position.y, 20, 40);
        g.setColor(Color.BLACK);
        g.drawOval(position.x+10, position.y, 20, 40);
        g.setColor(new Color(0xFFE709EF, true));
        g.fillOval(position.x, position.y+10, 40, 20);
        g.setColor(Color.BLACK);
        g.drawOval(position.x, position.y+10, 40, 20);

    }

    @Override
    public void damage(Robot robot) {
        robot.setLife(robot.getLife()-1);
    }

    @Override
    public void move() {
        if (position.x < 1000 & position.x > 0) {
            position = new Point(position.x+1, position.y);
        } else position = new Point(500, position.x + 1);
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
