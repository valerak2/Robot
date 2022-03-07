package logic;

import java.awt.*;

import static java.awt.Color.*;

public class CustomizeRobots {
    private static Color colorRobots = RED;
    private static String figureRobots = "Oval";

    public static Color getColorRobots() {
        return colorRobots;
    }

    public static String getFigureRobots() {
        return figureRobots;
    }

    public static void setFigureRobots(String figure) {
        figureRobots = figure;
    }

    public void setColorRobots(Color color) {
        colorRobots = color;
    }
}
