package gui.localization;

import gui.MainApplicationFrame;
import gui.menu.CloseDialogPanel;
import gui.menu.CustomizeMenu;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Language {
    public static Locale language = new Locale("eng");

    public static void setLanguage(String lang) {
        language = new Locale(lang);
        MainApplicationFrame.changeLocalization(language);
    }

    public static void changeMenuLanguage(MainApplicationFrame frame) {
        ResourceBundle rb = ResourceBundle.getBundle("lang", language);
        frame.getJMenuBar().getMenu(2).getItem(0).setName(rb.getString("color"));
        frame.getJMenuBar().getMenu(2).getItem(1).setName(rb.getString("Figure"));
    }
}