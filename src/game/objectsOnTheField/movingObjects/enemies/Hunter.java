package game.objectsOnTheField.movingObjects.enemies;

import game.objectsOnTheField.movingObjects.MovingObjects;

import java.awt.*;

public class Hunter extends MovingObjects {
    public Hunter(Point position) {
        super(position);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawRect(getPosition().x - 5, getPosition().y - 5, 10,10);
        g.setColor(new Color(0x831A1A));
        g.fillRect(getPosition().x - 5, getPosition().y -5, 10, 10);

    }

    @Override
    public void move() {
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
