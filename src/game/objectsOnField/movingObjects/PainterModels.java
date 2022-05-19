package game.objectsOnField.movingObjects;

import java.awt.*;

public class PainterModels {
    public int round(double value) {
        return (int) (value + 0.5);
    }

    public void paintObject(Graphics g, Color color, String figure, int centerX, int centerY, int diam1, int diam2) {
        switch (figure) {
            case "Oval" -> {
                g.setColor(color);
                g.fillOval(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
                g.setColor(Color.BLACK);
                g.drawOval(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
            }
            case "Rect" -> {
                g.setColor(color);
                g.fillRect(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
                g.setColor(Color.BLACK);
                g.drawRect(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
            }
        }
    }
}
