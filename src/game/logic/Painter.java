package game.logic;

import game.objectsOnField.ObjectOnTheField;

import java.awt.*;
import java.util.ArrayList;

public class Painter {
    public void paintBackground(Graphics g) {
        g.setColor(new Color(95, 38, 114));
        g.fillRect(0, 0, 1920, 1080);

    }

    public <ObjectOnField extends ObjectOnTheField> void drawArrayObjects(Graphics2D g, ArrayList<ObjectOnField> objects) {
        for (ObjectOnField object : objects) {
            object.draw(g);
        }
    }

    public void printGameOver(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 1920, 1080);
        g.setFont(new Font("LucidaSans", Font.PLAIN, 50));
        g.setColor(Color.red);
        g.drawString("Gameover", 500, 500);

    }
}
