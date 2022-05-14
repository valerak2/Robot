package gui.menu;

import gui.localization.Language;
import game.objectsOnField.movingObjects.robot.CustomizeRobots;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

public class CustomizeMenu {

    static ResourceBundle rb = ResourceBundle.getBundle("lang", Language.language);
    public static String RED = rb.getString("RED");
    public static String GREEN = rb.getString("GREEN");
    public static String BLUE = rb.getString("BLUE");
    public static String ORANGE = rb.getString("ORANGE");
    public static String MAGENTA = rb.getString("MAGENTA");
    public static String GRAY = rb.getString("GRAY");
    public static String CYAN = rb.getString("CYAN");
    public static String PINK = rb.getString("PINK");
    public static String WHITE = rb.getString("WHITE");
    public static String YELLOW = rb.getString("YELLOW");
    public static String LIGHT_GRAY = rb.getString("LIGHT_GRAY");
    public static String color = rb.getString("color");
    public static String Figure = rb.getString("Figure");
    public static String oval = rb.getString("Oval");
    public static String rectangle = rb.getString("Rectangle");
    public static String customMenu = rb.getString("customizeMenu");


    CustomizeRobots customizeRobots = new CustomizeRobots();

    public static JMenu customizeMenu = new JMenu(customMenu);

    public JMenu addCustomizeMenu() {
        customizeMenu.setMnemonic(KeyEvent.VK_T);
        customizeMenu.add(setColorMenu());
        customizeMenu.add(setFigureMenu());
        return customizeMenu;
    }

    private JMenuItem setColorMenu() {
        JMenu colors = new JMenu(color);
        colors.setMnemonic(KeyEvent.VK_T);
        {
            colors.add(setColor(Color.RED, RED));
            colors.add(setColor(Color.GREEN, GREEN));
            colors.add(setColor(Color.BLUE, BLUE));
            colors.add(setColor(Color.ORANGE, ORANGE));
            colors.add(setColor(Color.MAGENTA, MAGENTA));
            colors.add(setColor(Color.GRAY, GRAY));
            colors.add(setColor(Color.CYAN, CYAN));
            colors.add(setColor(Color.PINK, PINK));
            colors.add(setColor(Color.WHITE, WHITE));
            colors.add(setColor(Color.YELLOW, YELLOW));
            colors.add(setColor(Color.LIGHT_GRAY, LIGHT_GRAY));

        }
        return colors;
    }

    private JMenuItem setColor(Color colour, String colourName) {
        JMenuItem menuItem = new JMenuItem(colourName, KeyEvent.VK_S);
        menuItem.addActionListener((event) -> customizeRobots.setColorRobots(colour));
        return menuItem;
    }

    private JMenuItem setFigureMenu() {
        JMenu figure = new JMenu(Figure);
        figure.setMnemonic(KeyEvent.VK_T);
        {
            JMenuItem Oval = new JMenuItem(oval, KeyEvent.VK_S);
            Oval.addActionListener((event) -> customizeRobots.setFigureRobots("Oval"));
            JMenuItem Rect = new JMenuItem(rectangle, KeyEvent.VK_S);
            Rect.addActionListener((event) -> customizeRobots.setFigureRobots("Rect"));
            figure.add(Oval);
            figure.add(Rect);
        }
        return figure;
    }

}
