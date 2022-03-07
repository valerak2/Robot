package gui.menu;

import logic.CustomizeRobots;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CustomizeMenu {
    CustomizeRobots customize = new CustomizeRobots();

    public JMenu addCustomizeMenu() {
        JMenu customizeMenu = new JMenu("Кастомизация робота");
        customizeMenu.setMnemonic(KeyEvent.VK_T);
        customizeMenu.add(getColors());
        customizeMenu.add(getFigure());
        return customizeMenu;
    }

    private JMenuItem getColors() {
        JMenu colors = new JMenu("Цвет");
        colors.setMnemonic(KeyEvent.VK_T);
        {
            colors.add(addColors(Color.RED, "RED"));
            colors.add(addColors(Color.GREEN, "GREEN"));
            colors.add(addColors(Color.BLUE, "BLUE"));
            colors.add(addColors(Color.ORANGE, "ORANGE"));
            colors.add(addColors(Color.MAGENTA, "MAGENTA"));
            colors.add(addColors(Color.GRAY, "GRAY"));
        }
        return colors;
    }

    private JMenuItem addColors(Color colour, String colourName) {
        JMenuItem menuItem = new JMenuItem(colourName, KeyEvent.VK_S);
        menuItem.addActionListener((event) -> customize.setColorRobots(colour));
        return menuItem;
    }

    private JMenuItem getFigure() {
        JMenu figure = new JMenu("Фигура");
        figure.setMnemonic(KeyEvent.VK_T);
        {
            JMenuItem Oval = new JMenuItem("Oval", KeyEvent.VK_S);
            Oval.addActionListener((event) -> customize.setFigureRobots("Oval"));
            JMenuItem Rect = new JMenuItem("Rectangle", KeyEvent.VK_S);
            Rect.addActionListener((event) -> customize.setFigureRobots("Rect"));
            figure.add(Oval);
            figure.add(Rect);
        }
        return figure;
    }

}
