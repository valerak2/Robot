package gui.menu;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class OptionsMenu {
    public JMenu addOptionsMenu() {
        JMenu optionsMenu = new JMenu("Опции");
        optionsMenu.setMnemonic(KeyEvent.VK_T);
        optionsMenu.add(addExit());
        return optionsMenu;
    }

    private JMenuItem addExit() {
        JMenuItem addCloseItem = new JMenuItem("Выход", KeyEvent.VK_S);
        addCloseItem.addActionListener((event) -> CloseDialogPane.ShowCloseDialog(event));
        return addCloseItem;
    }
}
