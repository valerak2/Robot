package gui.menu;

import gui.MainApplicationFrame;
import gui.RobotsProgram;
import log.Logger;

import javax.swing.*;
import java.awt.event.KeyEvent;

import static javax.swing.SwingUtilities.updateComponentTreeUI;

public class LookAndFeelMenu {

    public static JMenu addLookAndFeelMenu(MainApplicationFrame mainApplicationFrame) {
        JMenu lookAndFeelMenu = new JMenu("Режим отображения");
        lookAndFeelMenu.setMnemonic(KeyEvent.VK_V);
        lookAndFeelMenu.getAccessibleContext().setAccessibleDescription(
                "Управление режимом отображения приложения");
        lookAndFeelMenu.add(addSystemScheme(mainApplicationFrame));
        lookAndFeelMenu.add(addCrossplatformScheme(mainApplicationFrame));
        return lookAndFeelMenu;
    }

    private static JMenuItem addSystemScheme(MainApplicationFrame mainApplicationFrame) {
        JMenuItem systemLookAndFeel = new JMenuItem("Системная схема", KeyEvent.VK_S);
        systemLookAndFeel.addActionListener((event) -> {
            setLookAndFeel(UIManager.getSystemLookAndFeelClassName(), mainApplicationFrame);
            mainApplicationFrame.invalidate();
        });
        systemLookAndFeel.addActionListener((event) ->
                Logger.info("Установлена системная схема"));
        return systemLookAndFeel;
    }

    private static JMenuItem addCrossplatformScheme(MainApplicationFrame mainApplicationFrame) {
        JMenuItem crossplatformLookAndFeel = new JMenuItem("Универсальная схема", KeyEvent.VK_S);
        crossplatformLookAndFeel.addActionListener((event) -> {
            setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName(), mainApplicationFrame);
            mainApplicationFrame.invalidate();
        });
        crossplatformLookAndFeel.addActionListener((event) ->
                Logger.info("Установлена универсальная схема"));
        return crossplatformLookAndFeel;
    }


    private static void setLookAndFeel(String className, MainApplicationFrame mainApplicationFrame) {
        try {
            UIManager.setLookAndFeel(className);
            updateComponentTreeUI(mainApplicationFrame);
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
            Logger.error(e.toString());
        }
    }
}
