package gui.menu;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class OptionsMenu {
    ActionListener actionListener;

    public JMenu addOptionsMenu(ActionListener actionListener) {
        this.actionListener = actionListener;
        JMenu optionsMenu = new JMenu("Опции");
        optionsMenu.setMnemonic(KeyEvent.VK_T);
        optionsMenu.add(addExit());
        return optionsMenu;
    }

    private JMenuItem addExit(){
        JMenuItem addCloseItem = new JMenuItem("Выход", KeyEvent.VK_S);
        addCloseItem.addActionListener(actionListener);
        //addCloseItem.addActionListener(CloseDialogPanel::ShowCloseDialog);
        return addCloseItem;
    }
}
