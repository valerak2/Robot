package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import gui.menu.*;
import gui.menu.OptionsMenu;

import gui.menu.CustomizeMenu;
import gui.menu.CloseDialogPane;
import gui.menu.TestMenu;
import log.Logger;

/**
 * Что требуется сделать:
 * 1. Метод создания меню перегружен функционалом и трудно читается.
 * Следует разделить его на серию более простых методов (или вообще выделить отдельный класс).
 */
public class MainApplicationFrame extends JFrame {
    private final JDesktopPane desktopPane = new JDesktopPane();

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

        GameWindow gameWindow = new GameWindow();
        gameWindow.setSize(500, 500);
        addWindow(gameWindow);

        setJMenuBar(generateMenuBar());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        CloseDialogPane.addWindowListener(this);
    }


    protected LogWindow createLogWindow() {
        LogWindow logWindow = new LogWindow(Logger.getDefaultLogSource());
        logWindow.setLocation(10, 10);
        logWindow.setSize(300, 800);
        setMinimumSize(logWindow.getSize());
        logWindow.pack();
        Logger.debug("Протокол работает");
        return logWindow;
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
}
