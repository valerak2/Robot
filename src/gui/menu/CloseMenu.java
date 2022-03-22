package gui.menu;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class CloseMenu {
    public static JMenu addCloseMenu() {
        JMenu testMenu = new JMenu("Выход");
        testMenu.setMnemonic(KeyEvent.VK_T);
        testMenu.getAccessibleContext().setAccessibleDescription(
                "Выход");

        {
            JMenuItem addCloseItem = new JMenuItem("Выйти", KeyEvent.VK_S);
            addCloseItem.addActionListener((event) -> CloseDialogPane.ShowCloseDialog(event));
            testMenu.add(addCloseItem);
        }
        return testMenu;
    }
}
