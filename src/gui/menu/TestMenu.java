package gui.menu;

import gui.localization.Language;
import log.Logger;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

public class TestMenu implements Menu {
    static ResourceBundle rb = ResourceBundle.getBundle("lang", Language.language);
    public static String TestsMenuName = rb.getString("TestsMenuName");
    public static String TestsMenuCommands = rb.getString("TestsMenuCommands");
    public static String MessageInLog = rb.getString("MessageInLog");
    public static String newString = rb.getString("newString");
    public Logger logger = Logger.getInstance();

    public static JMenu testMenu = new JMenu(TestsMenuName);

    @Override
    public JMenu initialization() {
        testMenu.setMnemonic(KeyEvent.VK_T);
        testMenu.getAccessibleContext().setAccessibleDescription(
                TestsMenuCommands);

        {
            JMenuItem addLogMessageItem = new JMenuItem(MessageInLog, KeyEvent.VK_S);
            addLogMessageItem.addActionListener((event) -> logger.debug(newString));
            testMenu.add(addLogMessageItem);
        }
        return testMenu;
    }
}
