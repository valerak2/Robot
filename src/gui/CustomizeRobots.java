package gui;

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

    /*JMenu CustomizeMenu = new JMenu("Кастомизация робота");
    CustomizeRobots customize = new CustomizeRobots();
        CustomizeMenu.setMnemonic(KeyEvent.VK_T);

    {
        JMenuItem RED = new JMenuItem("RED", KeyEvent.VK_S);
        RED.addActionListener((event) -> customize.setColorRobots(Color.RED));
        JMenuItem GREEN = new JMenuItem("GREEN", KeyEvent.VK_S);
        GREEN.addActionListener((event) -> customize.setColorRobots(Color.GREEN));
        JMenuItem BLUE = new JMenuItem("BLUE", KeyEvent.VK_S);
        BLUE.addActionListener((event) -> customize.setColorRobots(Color.BLUE));
        JMenuItem ORANGE = new JMenuItem("ORANGE", KeyEvent.VK_S);
        ORANGE.addActionListener((event) -> customize.setColorRobots(Color.ORANGE));
        JMenuItem MAGENTA = new JMenuItem("MAGENTA", KeyEvent.VK_S);
        MAGENTA.addActionListener((event) -> customize.setColorRobots(Color.MAGENTA));
        JMenuItem GRAY = new JMenuItem("GRAY", KeyEvent.VK_S);
        GRAY.addActionListener((event) -> customize.setColorRobots(Color.GRAY));
        CustomizeMenu.add(RED);
        CustomizeMenu.add(GREEN);
        CustomizeMenu.add(BLUE);
        CustomizeMenu.add(ORANGE);
        CustomizeMenu.add(MAGENTA);
        CustomizeMenu.add(GRAY);

    }
    {
        JMenuItem RED = new JMenuItem("Oval", KeyEvent.VK_S);
        RED.addActionListener((event) -> customize.setColorRobots(Color.RED));
        JMenuItem GREEN = new JMenuItem("Rect", KeyEvent.VK_S);
        GREEN.addActionListener((event) -> customize.setColorRobots(Color.GREEN));
        CustomizeMenu.add(MAGENTA);
        CustomizeMenu.add(GRAY);

    }
    JMenuItem newGame = new JMenuItem("newGame");
        newGame.setMnemonic(KeyEvent.VK_T);
        newGame.addActionListener((event) ->{GameWindow gameWindow = new GameWindow();
        gameWindow.setSize(400,  400);
        addWindow(gameWindow);;});


       menuBar.add(CustomizeMenu);
       menuBar.add(newGame);
*/
}
