package gui.menu;

import gui.localization.Language;
import logic.CustomizeRobots;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

enum Colors {
    Red(Language.rb.getString("RED")),
    Green(Language.rb.getString("GREEN")),
    Blue(Language.rb.getString("BLUE")),
    Orange(Language.rb.getString("ORANGE")),
    Magenta(Language.rb.getString("MAGENTA")),
    Gray(Language.rb.getString("GRAY")),
    Cyan(Language.rb.getString("CYAN")),
    Pink(Language.rb.getString("PINK")),
    White(Language.rb.getString("WHITE")),
    Yellow(Language.rb.getString("YELLOW")),
    Light_Gray(Language.rb.getString("LIGHT_GRAY"));
    private String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColors(String color) {
        this.color = color;
    }
}


public class CustomizeMenu {

    private static String color = Language.rb.getString("color");
    private static String Figure = Language.rb.getString("Figure");
    private static String oval = Language.rb.getString("Oval");
    private static String rectangle = Language.rb.getString("Rectangle");
    private static String customMenu = Language.rb.getString("customizeMenu");


    CustomizeRobots customizeRobots = new CustomizeRobots();

    public static JMenu customizeMenu = new JMenu(customMenu);

    public static void setCustomMenu(String customMenu) {
        CustomizeMenu.customMenu = customMenu;
    }

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
            colors.add(setColor(Color.RED, Colors.Red.getColor()));
            colors.add(setColor(Color.GREEN, Colors.Green.getColor()));
            colors.add(setColor(Color.BLUE, Colors.Blue.getColor()));
            colors.add(setColor(Color.ORANGE, Colors.Orange.getColor()));
            colors.add(setColor(Color.MAGENTA, Colors.Magenta.getColor()));
            colors.add(setColor(Color.GRAY, Colors.Gray.getColor()));
            colors.add(setColor(Color.CYAN, Colors.Cyan.getColor()));
            colors.add(setColor(Color.PINK, Colors.Pink.getColor()));
            colors.add(setColor(Color.WHITE, Colors.White.getColor()));
            colors.add(setColor(Color.YELLOW, Colors.Yellow.getColor()));
            colors.add(setColor(Color.LIGHT_GRAY, Colors.Light_Gray.getColor()));

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
