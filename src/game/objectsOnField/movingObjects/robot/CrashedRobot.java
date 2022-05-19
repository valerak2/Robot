package game.objectsOnField.movingObjects.robot;

import game.objectsOnField.movingObjects.Shot;
import game.objectsOnField.movingObjects.PainterModels;

import java.awt.*;

public class CrashedRobot extends Robot{
    final Color color = new Color(95, 38, 114);
    final int life = 0;
    public CrashedRobot(Point position, Point target) {
        super(position, target);
        this.painterModels = new PainterModels();
    }
    @Override
    public void move() {
    }
    @Override
    public void draw(Graphics2D g) {
        String figure = CustomizeRobots.getFigureRobots();
        painterModels.paintObject(g, color, figure,
                position.x, position.y, 30, 10);
        painterModels.paintObject(g, Color.WHITE, figure,
                position.x + 10, position.y, 5, 5);

    }
    @Override
    public Shot shot(){
        return null;
    }
}
