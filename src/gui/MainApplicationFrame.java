package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.Console;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.*;


import gui.localization.Language;
import gui.serialization.Data;
import gui.serialization.state.RobotCustomize;
import gui.serialization.state.RobotParameters;
import gui.serialization.state.WindowState;

import gui.menu.*;
import gui.menu.OptionsMenu;
import gui.menu.CustomizeMenu;
import gui.menu.CloseDialogPanel;
import gui.menu.TestMenu;
import gui.windows.CoordinateWindow;
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
    private static final String file = System.getProperty("user.home") + File.separator + "window_and_robot_states";
    private final JDesktopPane desktopPane = new JDesktopPane();

    private static final Data data = new Data();
    private static final GameWindow gameWindow = new GameWindow(data);
    private static final LogWindow logWindow = new LogWindow(Logger.getDefaultLogSource());
    private static final CoordinateWindow coordinateWindow = CoordinateWindow.getInstance();


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

        CoordinateWindow coordinateWindow = createCoordinateWindow();
        addWindow(coordinateWindow);

        setJMenuBar(generateMenuBar());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        CloseDialogPanel.addWindowListener(this);
    }

    protected GameWindow createGameWindow() {
        WindowState gameWindowParams = (WindowState) data.getState("gameWindow");
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
        WindowState logWindowParams = (WindowState) data.getState("logWindow");
        logWindow.setLocation(logWindowParams.positionX(), logWindowParams.positionY());
        logWindow.setSize(logWindowParams.width(), logWindowParams.height());

        try {
            logWindow.setClosed(logWindowParams.isClosed());
        } catch (Exception ignored) {

        }
        Logger.info("Протокол работает");
        return logWindow;
    }

    protected CoordinateWindow createCoordinateWindow() {
        WindowState coordinateWindowParams = (WindowState) data.getState("coordinateWindow");
        coordinateWindow.setLocation(coordinateWindowParams.positionX(), coordinateWindowParams.positionY());
        coordinateWindow.setSize(coordinateWindowParams.width(), coordinateWindowParams.height());

        try {
            coordinateWindow.setClosed(coordinateWindowParams.isClosed());
        } catch (Exception ignored) {

        }
        return coordinateWindow;
    }


    protected void addWindow(JInternalFrame frame) {
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
                gameWindow.isClosed()));

        data.setState("logWindow", new WindowState(
                logWindow.getWidth(),
                logWindow.getHeight(),
                logWindow.getX(),
                logWindow.getY(),
                logWindow.isClosed()));
        data.setState("coordinateWindow", new WindowState(
                coordinateWindow.getWidth(),
                coordinateWindow.getHeight(),
                coordinateWindow.getX(),
                coordinateWindow.getY(),
                coordinateWindow.isClosed()));

        data.setState("customize", new RobotCustomize(
                CustomizeRobots.getColorRobots(),
                CustomizeRobots.getFigureRobots()));

        data.setState("parameters", new RobotParameters(
                gameWindow.getM_visualizer().getP().getRobotPositionX(),
                gameWindow.getM_visualizer().getP().getRobotPositionY(),
                gameWindow.getM_visualizer().getP().getRobotDirection(),
                gameWindow.getM_visualizer().getP().getTargetPositionX(),
                gameWindow.getM_visualizer().getP().getTargetPositionY()));
        data.writeObject(file);

    }

    public static void changeLocalization(Locale language) {
        ResourceBundle rb = ResourceBundle.getBundle("lang", language);
        //Названия Окон
        gameWindow.setTitle(rb.getString("GameWindow.name"));
        logWindow.setTitle(rb.getString("LogWindow.name"));
        coordinateWindow.setTitle(rb.getString("coordinateWindow.name"));

        //Окно Закрытия окон
        CloseDialogPanel.yesOption = rb.getString("yesOption");
        CloseDialogPanel.noOption = rb.getString("noOption");
        CloseDialogPanel.closeWindow = rb.getString("closeWindow");
        CloseDialogPanel.accept = rb.getString("accept");

        // хз нужно ли менять эти значения в самом классе
        CustomizeMenu.RED = rb.getString("RED");
        CustomizeMenu.GREEN = rb.getString("GREEN");
        CustomizeMenu.BLUE = rb.getString("BLUE");
        CustomizeMenu.ORANGE = rb.getString("ORANGE");
        CustomizeMenu.MAGENTA = rb.getString("MAGENTA");
        CustomizeMenu.GRAY = rb.getString("GRAY");
        CustomizeMenu.CYAN = rb.getString("CYAN");
        CustomizeMenu.PINK = rb.getString("PINK");
        CustomizeMenu.WHITE = rb.getString("WHITE");
        CustomizeMenu.YELLOW = rb.getString("YELLOW");
        CustomizeMenu.LIGHT_GRAY = rb.getString("LIGHT_GRAY");
        CustomizeMenu.color = rb.getString("color");
        CustomizeMenu.Figure = rb.getString("Figure");
        CustomizeMenu.oval = rb.getString("Oval");
        CustomizeMenu.rectangle = rb.getString("Rectangle");
        CustomizeMenu.customMenu = rb.getString("customizeMenu");

        //Меню Кастомизации
        CustomizeMenu.customizeMenu.setText(rb.getString("customizeMenu"));
        CustomizeMenu.customizeMenu.getItem(0).setText((rb.getString("color")));
        JMenu colors1 = (JMenu) CustomizeMenu.customizeMenu.getItem(0);
        colors1.getItem(0).setText((rb.getString("RED")));
        colors1.getItem(1).setText((rb.getString("GREEN")));
        colors1.getItem(2).setText((rb.getString("BLUE")));
        colors1.getItem(3).setText((rb.getString("ORANGE")));
        colors1.getItem(4).setText((rb.getString("MAGENTA")));
        colors1.getItem(5).setText((rb.getString("GRAY")));
        colors1.getItem(6).setText((rb.getString("CYAN")));
        colors1.getItem(7).setText((rb.getString("PINK")));
        colors1.getItem(8).setText((rb.getString("WHITE")));
        colors1.getItem(9).setText((rb.getString("YELLOW")));
        colors1.getItem(10).setText((rb.getString("LIGHT_GRAY")));


        CustomizeMenu.customizeMenu.getItem(1).setText((rb.getString("Figure")));
        JMenu figures = (JMenu) CustomizeMenu.customizeMenu.getItem(1);
        figures.getItem(0).setText((rb.getString("Oval")));
        figures.getItem(1).setText((rb.getString("Rectangle")));

        //Тестовое меню
        TestMenu.TestsMenuName = rb.getString("TestsMenuName");
        TestMenu.TestsMenuCommands = rb.getString("TestsMenuCommands");
        TestMenu.MessageInLog = rb.getString("MessageInLog");
        TestMenu.newString = rb.getString("newString");

        TestMenu.testMenu.setText(rb.getString("TestsMenuName"));
        TestMenu.testMenu.getItem(0).setText(rb.getString("MessageInLog"));

        //Меню отображения
        LookAndFeelMenu.DisplayMode = rb.getString("DisplayMode");
        LookAndFeelMenu.systemScheme = rb.getString("systemScheme");
        LookAndFeelMenu.universalScheme = rb.getString("universalScheme");
        LookAndFeelMenu.setupUniversalScheme = rb.getString("setupUniversalScheme");
        LookAndFeelMenu.setupSystemScheme = rb.getString("setupSystemScheme");


        LookAndFeelMenu.lookAndFeelMenu.setText(rb.getString("DisplayMode"));
        LookAndFeelMenu.lookAndFeelMenu.getItem(0).setText(rb.getString("systemScheme"));
        LookAndFeelMenu.lookAndFeelMenu.getItem(1).setText(rb.getString("universalScheme"));

        //Меню опций
        OptionsMenu.Options = rb.getString("Options");
        OptionsMenu.Exit = rb.getString("Exit");
        OptionsMenu.language = rb.getString("language");

        OptionsMenu.optionsMenu.setText(OptionsMenu.Options);
        OptionsMenu.optionsMenu.getItem(0).setText(OptionsMenu.Exit);
        OptionsMenu.optionsMenu.getItem(1).setText(OptionsMenu.language);
    }
}
