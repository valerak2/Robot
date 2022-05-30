package gui.menu;

import gui.MainApplicationFrame;
import gui.localization.Language;
import log.Logger;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

import static javax.swing.SwingUtilities.updateComponentTreeUI;

// TODO: 29.05.2022 переделать
public class LookAndFeelMenu {
    static ResourceBundle rb = ResourceBundle.getBundle("lang", Language.language);
    public static String DisplayMode = rb.getString("DisplayMode");
    public static String systemScheme = rb.getString("systemScheme");
    public static String universalScheme = rb.getString("universalScheme");
    public static String setupUniversalScheme = rb.getString("setupUniversalScheme");
    public static String setupSystemScheme = rb.getString("setupSystemScheme");
    private static Logger logger = Logger.getInstance();

    public static JMenu lookAndFeelMenu = new JMenu(DisplayMode);

    public static JMenu addLookAndFeelMenu(MainApplicationFrame mainApplicationFrame) {
        lookAndFeelMenu.setMnemonic(KeyEvent.VK_V);
        lookAndFeelMenu.getAccessibleContext().setAccessibleDescription(
                "Управление режимом отображения приложения");
        lookAndFeelMenu.add(addSystemScheme(mainApplicationFrame));
        lookAndFeelMenu.add(addCrossplatformScheme(mainApplicationFrame));
        return lookAndFeelMenu;
    }

    private static JMenuItem addSystemScheme(MainApplicationFrame mainApplicationFrame) {
        JMenuItem systemLookAndFeel = new JMenuItem(systemScheme, KeyEvent.VK_S);
        systemLookAndFeel.addActionListener((event) -> {
            setLookAndFeel(UIManager.getSystemLookAndFeelClassName(), mainApplicationFrame);
            mainApplicationFrame.invalidate();
        });
        systemLookAndFeel.addActionListener((event) ->
                logger.info(setupSystemScheme));
        return systemLookAndFeel;
    }

    private static JMenuItem addCrossplatformScheme(MainApplicationFrame mainApplicationFrame) {
        JMenuItem crossplatformLookAndFeel = new JMenuItem(universalScheme, KeyEvent.VK_S);
        crossplatformLookAndFeel.addActionListener((event) -> {
            setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName(), mainApplicationFrame);
            mainApplicationFrame.invalidate();
        });
        crossplatformLookAndFeel.addActionListener((event) ->
                logger.info(setupUniversalScheme));
        return crossplatformLookAndFeel;
    }


    private static void setLookAndFeel(String className, MainApplicationFrame mainApplicationFrame) {
        try {
            UIManager.setLookAndFeel(className);
            updateComponentTreeUI(mainApplicationFrame);
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
            logger.error(e.toString());
        }
    }
}
