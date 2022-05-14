package game.objectsOnField.movingObjects.enemies;

import game.objectsOnField.movingObjects.MovingObjects;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

// TODO: 14.05.2022
public class Type2 extends MovingObjects {
    protected Type2(Point position) {
        super(position);
    }

    static Image Load_bg;
    static Image bg;

    public static void loadImage() {
        Load_bg = new ImageIcon("Graphics/Load_bg.jpg").getImage();
    }

    @Override
    public void draw(Graphics2D g) {
        try {
            Load_bg = ImageIO.read(new File("undefined.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(Load_bg, 0, 0, 1280, 720, null);
    }

    @Override
    public void move() {

    }
}
