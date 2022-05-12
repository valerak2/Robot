package game.objectsOnTheField.movingObjects;

import game.objectsOnTheField.movingObjects.MovingObjects;

import java.awt.*;

public class Shot extends MovingObjects {
    public Shot(Point position) {
        super(position);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.RED);
        g.drawOval(position.x, position.y, 5,5);
        g.fillOval(position.x, position.y, 5,5);
    }

    @Override
    public void move() {
        setTarget(new Point(50, 50));
        Point newPosition = new Point(moveOnX(),moveOnY());
        setPosition(newPosition);

    }

    public int moveOnX() {
        if (position.x != target.x) {
            if (position.x < target.x) {
                return (position.x + 1);
            } else {
                return(position.x - 1);
            }
        }
        return position.x;
    }
    public int moveOnY() {
        if (position.y != target.y) {
            if (position.y < target.y) {
                return (position.y + 1);
            } else {
                return(position.y - 1);
            }
        }
        return position.y;
    }
}
