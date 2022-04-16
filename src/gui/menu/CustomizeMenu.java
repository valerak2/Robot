package gui.menu;

import logic.CustomizeRobots;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CustomizeMenu {
    CustomizeRobots customizeRobots = new CustomizeRobots();

    public JMenu addCustomizeMenu() {
        JMenu customizeMenu = new JMenu("Кастомизация робота");
        customizeMenu.setMnemonic(KeyEvent.VK_T);
        customizeMenu.add(setColorMenu());
        customizeMenu.add(setFigureMenu());
        return customizeMenu;
    }

    private JMenuItem setColorMenu() {
        JMenu colors = new JMenu("Цвет");
        colors.setMnemonic(KeyEvent.VK_T);
        {
            colors.add(setColor(Color.RED, "RED"));
            colors.add(setColor(Color.GREEN, "GREEN"));
            colors.add(setColor(Color.BLUE, "BLUE"));
            colors.add(setColor(Color.ORANGE, "ORANGE"));
            colors.add(setColor(Color.MAGENTA, "MAGENTA"));
            colors.add(setColor(Color.GRAY, "GRAY"));
            colors.add(setColor(Color.CYAN, "CYAN"));
            colors.add(setColor(Color.PINK, "PINK"));
            colors.add(setColor(Color.WHITE, "WHITE"));
            colors.add(setColor(Color.YELLOW, "YELLOW"));
            colors.add(setColor(Color.LIGHT_GRAY, "LIGHT_GRAY"));

        }
        return colors;
    }

    private JMenuItem setColor(Color colour, String colourName) {
        JMenuItem menuItem = new JMenuItem(colourName, KeyEvent.VK_S);
        menuItem.addActionListener((event) -> customizeRobots.setColorRobots(colour));
        return menuItem;
    }

    private JMenuItem setFigureMenu() {
        JMenu figure = new JMenu("Фигура");
        figure.setMnemonic(KeyEvent.VK_T);
        {
            JMenuItem Oval = new JMenuItem("Oval", KeyEvent.VK_S);
            Oval.addActionListener((event) -> customizeRobots.setFigureRobots("Oval"));
            JMenuItem Rect = new JMenuItem("Rectangle", KeyEvent.VK_S);
            Rect.addActionListener((event) -> customizeRobots.setFigureRobots("Rect"));
            figure.add(Oval);
            figure.add(Rect);
        }
        return figure;
    }

}
