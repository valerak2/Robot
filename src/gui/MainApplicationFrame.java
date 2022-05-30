package gui;

import java.awt.*;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;
import javax.swing.*;


import gui.localization.Language;
import gui.menu.MenuBar;
import gui.windows.CreatorWindows;
import serialization.SerializationController;
import serialization.state.OptionState;

import gui.menu.options.CloseDialogPanel;


/**
 * Что требуется сделать:
 * 1. Метод создания меню перегружен функционалом и трудно читается.
 * Следует разделить его на серию более простых методов (или вообще выделить отдельный класс).
 */
public class MainApplicationFrame extends JFrame implements Serializable {
    SerializationController serializationController = SerializationController.getInstance();

    public MainApplicationFrame() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //Make the big window be indented 50 pixels from each edge
        //of the screen.
        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                screenSize.width - inset * 2,
                screenSize.height - inset * 2);

        JDesktopPane desktopPane = new JDesktopPane();
        setContentPane(desktopPane);
        new CreatorWindows(desktopPane);
        MenuBar menuBar = new MenuBar();
        setJMenuBar(menuBar.generate(this));
        checkLanguage();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        CloseDialogPanel.addWindowListener(this);
    }

    private void checkLanguage() {
        OptionState optionState = (OptionState) serializationController.getData().getState("options");
        if (!optionState.language().equals(Language.getLanguageString()))
            Language.setLanguage(optionState.language());
    }


    public static void saveStates() {
      /*  data.setState("logWindow", new WindowState(
                logWindow.getWidth(),
                logWindow.getHeight(),
                logWindow.getX(),
                logWindow.getY(),
                logWindow.isIcon()));
        data.setState("statisticsWindow", new WindowState(
                STATISTICS_WINDOW.getWidth(),
                STATISTICS_WINDOW.getHeight(),
                STATISTICS_WINDOW.getX(),
                STATISTICS_WINDOW.getY(),
                STATISTICS_WINDOW.isIcon()));
        *//*data.setState("parameters", new RobotParameters(
                gameWindow.getM_visualizer().getP().getX(),
                gameWindow.getM_visualizer().getP().getY(),
                gameWindow.getM_visualizer().getP().getRobotDirection(),
                gameWindow.getM_visualizer().getP().getTargetPositionX(),
                gameWindow.getM_visualizer().getP().getTargetPositionY()));*//*
        data.writeObject(file);*/

    }

    public static void changeLocalization(ResourceBundle rb) {
        //Названия Окон
        //gameWindow.setTitle(rb.getString("GameWindow.name"));
        //logWindow.setTitle(rb.getString("LogWindow.name"));
        //STATISTICS_WINDOW.setTitle(rb.getString("coordinateWindow.name"));
    }
}
