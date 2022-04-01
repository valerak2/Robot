package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import javax.swing.*;


import gui.Storemanager.Data;
import gui.Storemanager.RobotCustomize;
import gui.Storemanager.RobotParameters;
import gui.Storemanager.WindowState;

import gui.menu.*;
import gui.menu.OptionsMenu;
import gui.menu.CustomizeMenu;
import gui.menu.CloseDialogPanel;
import gui.menu.TestMenu;
import gui.windows.GameWindow;
import gui.windows.LogWindow;
import log.Logger;
import logic.CustomizeRobots;

/**
 * Что требуется сделать:
 * 1. Метод создания меню перегружен функционалом и трудно читается.
 * Следует разделить его на серию более простых методов (или вообще выделить отдельный класс).
 */
public class MainApplicationFrame extends JFrame implements Serializable {
    private final String file = System.getProperty("user.home") + File.separator + "robotState";
    private final JDesktopPane desktopPane = new JDesktopPane();

    private final Data data = new Data();
    private final GameWindow gameWindow = new GameWindow(data);

    private final LogWindow logWindow = new LogWindow(Logger.getDefaultLogSource());

    public void quitListener() {
        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("OptionPane.noButtonText", "Нет");

        int userAnswer = JOptionPane.showConfirmDialog(
                this,
                "Выйти?",
                "Подтвердите выход",
                JOptionPane.YES_NO_OPTION);


        if (userAnswer == JOptionPane.YES_OPTION) {

            data.setStateWindows("gameWindow", new WindowState(

                    gameWindow.getWidth(),
                    gameWindow.getHeight(),
                    gameWindow.getX(),
                    gameWindow.getY(),
                    gameWindow.isClosed()));

            data.setStateWindows("logWindow", new WindowState(

                    logWindow.getWidth(),
                    logWindow.getHeight(),
                    logWindow.getX(),
                    logWindow.getY(),
                    logWindow.isClosed()));

            data.setRobotCustomize("customize", new RobotCustomize(
                    CustomizeRobots.getColorRobots(),
                    CustomizeRobots.getFigureRobots()));
            data.setRobotParameters("parameters", new RobotParameters(
                    gameWindow.getM_visualizer().getP().getRobotPositionX(),
                    gameWindow.getM_visualizer().getP().getRobotPositionY(),
                    gameWindow.getM_visualizer().getP().getRobotDirection(),
                    gameWindow.getM_visualizer().getP().getTargetPositionX(),
                    gameWindow.getM_visualizer().getP().getTargetPositionY()));
            data.writeObject(file);

            System.exit(0);
        }
    }

    public MainApplicationFrame() {
        //Make the big window be indented 50 pixels from each edge
        //of the screen.
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                screenSize.width - inset * 2,
                screenSize.height - inset * 2);

        setContentPane(desktopPane);

        LogWindow logWindow = createLogWindow();
        addWindow(logWindow);
        GameWindow gameWindow = createGameWindow();

        addWindow(gameWindow);

        setJMenuBar(generateMenuBar());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        CloseDialogPanel.addWindowListener(this);

    }

    protected GameWindow createGameWindow() {
        WindowState gameWindowParams = data.getStateWindows("gameWindow");
        gameWindow.setSize(gameWindowParams.width(), gameWindowParams.height());
        gameWindow.setLocation(gameWindowParams.positionX(), gameWindowParams.positionY());
        try {
            gameWindow.setClosed(gameWindowParams.isClosed());
        } catch (Exception ignored) {
        }
        gameWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        return gameWindow;

    }


    protected LogWindow createLogWindow() {
        var logWindowParams = data.getStateWindows("logWindow");
        logWindow.setLocation(logWindowParams.positionX(), logWindowParams.positionY());
        logWindow.setSize(logWindowParams.width(), logWindowParams.height());

        try {
            logWindow.setClosed(logWindowParams.isClosed());
        } catch (Exception ignored) {

        }
        setMinimumSize(logWindow.getSize());

        Logger.debug("Протокол работает");
        return logWindow;
    }

    protected void addWindow(JInternalFrame frame) {
        desktopPane.add(frame);
        frame.setVisible(true);
    }


    private JMenuBar generateMenuBar() {
        ActionListener quit = (event) -> quitListener();
        JMenuBar menuBar = new JMenuBar();
        TestMenu testMenu = new TestMenu();
        CustomizeMenu customizeMenu = new CustomizeMenu();
        OptionsMenu optionsMenu = new OptionsMenu();
        menuBar.add(LookAndFeelMenu.addLookAndFeelMenu(this));
        menuBar.add(testMenu.addTestMenu());
        menuBar.add(customizeMenu.addCustomizeMenu());
        menuBar.add(optionsMenu.addOptionsMenu(quit));

        return menuBar;
    }
}
