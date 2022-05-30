package gui.localization;

import gui.MainApplicationFrame;
import gui.menu.*;
import gui.menu.customize.CustomizeMenu;
import gui.menu.options.CloseDialogPanel;
import gui.menu.options.OptionsMenu;

import javax.swing.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class Language {

    public static String getLanguageString() {
        return language.getLanguage();
    }

    public static Locale language = new Locale("ru");
    public static ResourceBundle rb = ResourceBundle.getBundle("lang", language);

    public static void setLanguage(String lang) {
        language = new Locale(lang);
        rb = ResourceBundle.getBundle("lang", language);
        changeMenuLanguage();
    }

    private static void changeCustomizeMenuLocalization() {
        CustomizeMenu.customizeMenu.setText(rb.getString("customizeMenu"));
        CustomizeMenu.customizeMenu.getItem(0).setText((rb.getString("color")));
        JMenu colors1 = (JMenu) CustomizeMenu.customizeMenu.getItem(0);
        colors1.getItem(0).setText((rb.getString("RED")));
        colors1.getItem(1).setText((rb.getString("GREEN")));
        colors1.getItem(2).setText((rb.getString("BLUE")));
        colors1.getItem(3).setText((rb.getString("ORANGE")));
        colors1.getItem(4).setText((rb.getString("MAGENTA")));
        colors1.getItem(5).setText((rb.getString("GRAY")));
        colors1.getItem(6).setText((rb.getString("CYAN")));
        colors1.getItem(7).setText((rb.getString("PINK")));
        colors1.getItem(8).setText((rb.getString("WHITE")));
        colors1.getItem(9).setText((rb.getString("YELLOW")));
        colors1.getItem(10).setText((rb.getString("LIGHT_GRAY")));


        CustomizeMenu.customizeMenu.getItem(1).setText((rb.getString("Figure")));
        JMenu figures = (JMenu) CustomizeMenu.customizeMenu.getItem(1);
        figures.getItem(0).setText((rb.getString("Oval")));
        figures.getItem(1).setText((rb.getString("Rectangle")));
    }

    private static void changeCloseDialogPanelLocalization() {
        CloseDialogPanel.yesOption = rb.getString("yesOption");
        CloseDialogPanel.noOption = rb.getString("noOption");
        CloseDialogPanel.closeWindow = rb.getString("closeWindow");
        CloseDialogPanel.accept = rb.getString("accept");
    }

    private static void changeTestMenuLocalization() {
        TestMenu.newString = rb.getString("newString");

        TestMenu.testMenu.setText(rb.getString("TestsMenuName"));
        TestMenu.testMenu.getItem(0).setText(rb.getString("MessageInLog"));
    }

    private static void changeLookAndFeelMenuLocalization() {
        LookAndFeelMenu.lookAndFeelMenu.setText(rb.getString("DisplayMode"));
        LookAndFeelMenu.lookAndFeelMenu.getItem(0).setText(rb.getString("systemScheme"));
        LookAndFeelMenu.lookAndFeelMenu.getItem(1).setText(rb.getString("universalScheme"));
    }

    private static void changeOptionsMenuLocalization() {
        OptionsMenu.Options = rb.getString("Options");
        OptionsMenu.Exit = rb.getString("Exit");
        OptionsMenu.language = rb.getString("language");

        OptionsMenu.optionsMenu.setText(rb.getString("Options"));
        OptionsMenu.optionsMenu.getItem(0).setText(rb.getString("Exit"));
        OptionsMenu.optionsMenu.getItem(1).setText(rb.getString("language"));
    }


    public static void changeMenuLanguage() {
        MainApplicationFrame.changeLocalization(rb);
        changeCloseDialogPanelLocalization();
        changeCustomizeMenuLocalization();
        changeTestMenuLocalization();
        changeLookAndFeelMenuLocalization();
        changeOptionsMenuLocalization();
    }
}