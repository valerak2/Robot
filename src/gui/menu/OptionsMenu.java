package gui.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

import gui.MainApplicationFrame;
import gui.localization.Language;

public class OptionsMenu {
    static ResourceBundle rb = ResourceBundle.getBundle("lang", Language.language);
    public static String Options = rb.getString("Options");
    public static String Exit = rb.getString("Exit");
    public static String language = rb.getString("language");

    public static JMenu optionsMenu = new JMenu(Options);
    public JMenu addOptionsMenu() {
        optionsMenu.setMnemonic(KeyEvent.VK_T);
        optionsMenu.add(addExit());
        optionsMenu.add(addLanguage());
        return optionsMenu;
    }

    private JMenuItem addExit() {
        JMenuItem addCloseItem = new JMenuItem(Exit, KeyEvent.VK_S);
        addCloseItem.addActionListener(CloseDialogPanel::ShowCloseDialog);
        return addCloseItem;
    }

    private JMenu addLanguage() {
        JMenu LanguageItem = new JMenu(language);
        LanguageItem.setMnemonic(KeyEvent.VK_S);
        {
            LanguageItem.add(setLang("eng"));
            LanguageItem.add(setLang("ru"));
        }
        return LanguageItem;
    }

    private JMenuItem setLang(String language) {
        JMenuItem menuItem = new JMenuItem(language, KeyEvent.VK_S);
        menuItem.addActionListener((event) ->
                Language.setLanguage(language));
        return menuItem;
    }
}
