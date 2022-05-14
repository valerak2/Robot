package game.objectsOnField.movingObjects.robot;

import java.awt.*;

import static java.awt.Color.*;

// TODO: 14.05.2022 переделать
public class CustomizeRobots {
    private static Color colorRobots = RED;
    private static String figureRobots = "Oval";

    public static Color getColorRobots() {
        return colorRobots;
    }

    public static String getFigureRobots() {
        return figureRobots;
    }

    public void setFigureRobots(String figure) {
        figureRobots = figure;
    }

    public void setColorRobots(Color color) {
        colorRobots = color;
    }
}
