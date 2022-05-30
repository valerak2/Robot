package gui.menu.options;

import gui.localization.Language;
import gui.menu.Menu;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

public class OptionsMenu implements Menu {
    static ResourceBundle rb = ResourceBundle.getBundle("lang", Language.language);
    public static String Options = rb.getString("Options");
    public static String Exit = rb.getString("Exit");
    public static String language = rb.getString("language");

    public static JMenu optionsMenu = new JMenu(Options);

    @Override
    public JMenu initialization() {
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
        JMenu languageItem = new JMenu(language);
        languageItem.setMnemonic(KeyEvent.VK_S);
        {
            languageItem.add(setLang("eng"));
            languageItem.add(setLang("ru"));
        }
        return languageItem;
    }

    private JMenuItem setLang(String language) {
        JMenuItem menuItem = new JMenuItem(language, KeyEvent.VK_S);
        menuItem.addActionListener((event) ->
                Language.setLanguage(language));
        return menuItem;
    }
}