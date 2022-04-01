package logic.operations;

import logic.CustomizeRobots;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class PaintOperations {
    static int round(double value) {
        return (int) (value + 0.5);
    }

    static void drawFigure(Graphics g, String figure, int centerX, int centerY, int diam1, int diam2) {
        switch (figure) {
            case "Oval" -> g.drawOval(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
            case "Rect" -> g.drawRect(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
        }
    }

    static void fillFigure(Graphics g, String figure, int centerX, int centerY, int diam1, int diam2) {
        switch (figure) {
            case "Oval" -> g.fillOval(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
            case "Rect" -> g.fillRect(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
        }

    }

    public void drawTarget(Graphics2D g, int x, int y) {
        AffineTransform t = AffineTransform.getRotateInstance(0, 0, 0);
        g.setTransform(t);
        g.setColor(Color.GREEN);
        fillFigure(g, "Oval", x, y, 5, 5);
        g.setColor(Color.BLACK);
        drawFigure(g, "Oval", x, y, 5, 5);
    }

    public void drawRobot(Graphics2D g, double x, double y, double direction) {
        int robotCenterX = round(x);
        int robotCenterY = round(y);
        String figure = CustomizeRobots.getFigureRobots();
        AffineTransform t = AffineTransform.getRotateInstance(direction, robotCenterX, robotCenterY);
        g.setTransform(t);
        g.setColor(CustomizeRobots.getColorRobots());
        fillFigure(g, figure, robotCenterX, robotCenterY, 30, 10);
        g.setColor(Color.BLACK);
        drawFigure(g, figure, robotCenterX, robotCenterY, 30, 10);
        g.setColor(Color.WHITE);
        fillFigure(g, figure, robotCenterX + 10, robotCenterY, 5, 5);
        g.setColor(Color.BLACK);
        drawFigure(g, figure, robotCenterX + 10, robotCenterY, 5, 5);
    }


}
