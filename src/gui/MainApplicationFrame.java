package gui;

import java.awt.*;
import java.io.File;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.swing.*;


import gui.localization.Language;
import gui.serialization.Data;
import gui.serialization.state.OptionState;
import gui.serialization.state.RobotCustomize;
import gui.serialization.state.WindowState;

import gui.menu.*;
import gui.menu.OptionsMenu;
import gui.menu.CustomizeMenu;
import gui.menu.CloseDialogPanel;
import gui.menu.TestMenu;
import gui.windows.StatisticsWindow;
import gui.windows.GameWindow;
import gui.windows.LogWindow;
import log.Logger;
import game.objectsOnField.movingObjects.robot.CustomizeRobots;


/**
 * Что требуется сделать:
 * 1. Метод создания меню перегружен функционалом и трудно читается.
 * Следует разделить его на серию более простых методов (или вообще выделить отдельный класс).
 */
public class MainApplicationFrame extends JFrame implements Serializable {
    private static final String file = System.getProperty("user.home") + File.separator + "window_and_robot_states";
    private final JDesktopPane desktopPane = new JDesktopPane();

    private static final Data data = new Data();
    private static final GameWindow gameWindow = new GameWindow(data);
    private static final LogWindow logWindow = new LogWindow(Logger.getDefaultLogSource());
    private static final StatisticsWindow STATISTICS_WINDOW = StatisticsWindow.getInstance();


    public MainApplicationFrame() {
        //Make the big window be indented 50 pixels from each edge
        //of the screen.
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                screenSize.width - inset * 2,
                screenSize.height - inset * 2);

        setContentPane(desktopPane);

        WindowState gameWindowParams = (WindowState) data.getState("gameWindow");
        WindowState logWindowParams = (WindowState) data.getState("logWindow");
        WindowState coordinateWindowParams = (WindowState) data.getState("coordinateWindow");

        addWindow(createWindow(logWindowParams, logWindow));
        addWindow(createWindow(gameWindowParams, gameWindow));
        addWindow(createWindow(coordinateWindowParams, STATISTICS_WINDOW));

        setJMenuBar(generateMenuBar());
        checkLanguage();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        CloseDialogPanel.addWindowListener(this);
    }

    private void checkLanguage() {
        OptionState optionState = (OptionState) data.getState("options");
        if (!optionState.language().equals(Language.getLanguageString()))
            Language.setLanguage(optionState.language());
    }

    private <Window extends JInternalFrame> Window createWindow(WindowState windowParams, Window window) {
        window.setLocation(windowParams.positionX(), windowParams.positionY());
        window.setSize(windowParams.width(), windowParams.height());
        try {
            window.setIcon(windowParams.isIcon());
        } catch (Exception ignored) {
        }

        try {
            window.setClosed(windowParams.isClosed());
        } catch (Exception ignored) {
        }

        Logger.info(window.getTitle() + " was created");
        return window;
    }


    private void addWindow(JInternalFrame frame) {
        desktopPane.add(frame);
        frame.setVisible(true);
    }


    private JMenuBar generateMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        TestMenu testMenu = new TestMenu();
        CustomizeMenu customizeMenu = new CustomizeMenu();
        OptionsMenu optionsMenu = new OptionsMenu();

        menuBar.add(LookAndFeelMenu.addLookAndFeelMenu(this));
        menuBar.add(testMenu.addTestMenu());
        menuBar.add(customizeMenu.addCustomizeMenu());
        menuBar.add(optionsMenu.addOptionsMenu());

        return menuBar;
    }

    public static void saveStates() {
        data.setState("gameWindow", new WindowState(
                gameWindow.getWidth(),
                gameWindow.getHeight(),
                gameWindow.getX(),
                gameWindow.getY(),
                gameWindow.isClosed(),
                gameWindow.isIcon()));

        data.setState("logWindow", new WindowState(
                logWindow.getWidth(),
                logWindow.getHeight(),
                logWindow.getX(),
                logWindow.getY(),
                logWindow.isClosed(),
                logWindow.isIcon()));
        data.setState("coordinateWindow", new WindowState(
                STATISTICS_WINDOW.getWidth(),
                STATISTICS_WINDOW.getHeight(),
                STATISTICS_WINDOW.getX(),
                STATISTICS_WINDOW.getY(),
                STATISTICS_WINDOW.isClosed(),
                STATISTICS_WINDOW.isIcon()));

        data.setState("customize", new RobotCustomize(
                CustomizeRobots.getColorRobots(),
                CustomizeRobots.getFigureRobots()));

        /*data.setState("parameters", new RobotParameters(
                gameWindow.getM_visualizer().getP().getX(),
                gameWindow.getM_visualizer().getP().getY(),
                gameWindow.getM_visualizer().getP().getRobotDirection(),
                gameWindow.getM_visualizer().getP().getTargetPositionX(),
                gameWindow.getM_visualizer().getP().getTargetPositionY()));*/
        data.setState("options", new OptionState(Language.getLanguageString(), " "));
        data.writeObject(file);

    }

    public static void changeLocalization(ResourceBundle rb) {
        //Названия Окон
        gameWindow.setTitle(rb.getString("GameWindow.name"));
        logWindow.setTitle(rb.getString("LogWindow.name"));
        STATISTICS_WINDOW.setTitle(rb.getString("coordinateWindow.name"));
    }
}
