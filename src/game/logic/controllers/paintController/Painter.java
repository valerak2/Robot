package game.logic.controllers.paintController;

import game.logic.loadEnemy.LoadedEnemy;
import game.logic.loadEnemy.LoadedEnemyLogic;
import game.objectsOnField.ObjectOnTheField;

import javax.imageio.ImageIO;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
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
    public void drawLoadedEnemies(Graphics2D g,ArrayList<LoadedEnemyLogic> l_enemies){
        CopyOnWriteArrayList<LoadedEnemyLogic> copyOnWriteArrayList = new CopyOnWriteArrayList<>(l_enemies);
        for (LoadedEnemyLogic enemy: l_enemies){
            enemy.draw(g);
        }
    }

    public void printGameOver(Graphics g) {
        String pathname = "resource/images/GameOver.png";
        File file = new File(pathname);
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(image, 0, 0, 1920, 800, null);
        g.setFont(new Font("LucidaSans", Font.PLAIN, 100));
        g.setColor(new Color(0x51D572));
        g.drawString("Gameover", 450, 300);

    }
}
