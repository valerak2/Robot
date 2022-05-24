package game.logic.controllers.paintController;

import game.objectsOnField.ObjectOnTheField;

import java.awt.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Painter {
    public void paintBackground(Graphics g) {
        g.setColor(new Color(95, 38, 114));
        g.fillRect(0, 0, 1920, 1080);

    }

    public <ObjectOnField extends ObjectOnTheField> void drawArrayObjects(
            Graphics2D g, ArrayList<ObjectOnField> objects) throws IOException {
        CopyOnWriteArrayList<ObjectOnField> copyOnWriteArrayList = new CopyOnWriteArrayList<>(objects);
        for (ObjectOnField object : copyOnWriteArrayList) {
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
