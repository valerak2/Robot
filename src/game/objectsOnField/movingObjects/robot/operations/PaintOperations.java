package game.objectsOnField.movingObjects.robot.operations;

import java.awt.*;

public class PaintOperations {
    public static int round(double value) {
        return (int) (value + 0.5);
    }

    public static void drawFigure(Graphics g, String figure, int centerX, int centerY, int diam1, int diam2) {
        switch (figure) {
            case "Oval" -> g.drawOval(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
            case "Rect" -> g.drawRect(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
        }
    }

    public static void fillFigure(Graphics g, String figure, int centerX, int centerY, int diam1, int diam2) {
        switch (figure) {
            case "Oval" -> g.fillOval(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
            case "Rect" -> g.fillRect(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
        }

    }
}
