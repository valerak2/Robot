package gui.localization;

import gui.MainApplicationFrame;
import gui.menu.*;

import javax.swing.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class Language {

    public static String getLanguageString() {
        return language.getLanguage();
    }

    public static Locale language = new Locale("eng");

    public static void setLanguage(String lang) {
        language = new Locale(lang);
        changeMenuLanguage();
    }

    public static void changeMenuLanguage() {
        ResourceBundle rb = ResourceBundle.getBundle("lang", language);
        //Названия Окон
        MainApplicationFrame.changeLocalization(rb);

        //Окно Закрытия окон
        CloseDialogPanel.yesOption = rb.getString("yesOption");
        CloseDialogPanel.noOption = rb.getString("noOption");
        CloseDialogPanel.closeWindow = rb.getString("closeWindow");
        CloseDialogPanel.accept = rb.getString("accept");

        // хз нужно ли менять эти значения в самом классе
        CustomizeMenu.RED = rb.getString("RED");
        CustomizeMenu.GREEN = rb.getString("GREEN");
        CustomizeMenu.BLUE = rb.getString("BLUE");
        CustomizeMenu.ORANGE = rb.getString("ORANGE");
        CustomizeMenu.MAGENTA = rb.getString("MAGENTA");
        CustomizeMenu.GRAY = rb.getString("GRAY");
        CustomizeMenu.CYAN = rb.getString("CYAN");
        CustomizeMenu.PINK = rb.getString("PINK");
        CustomizeMenu.WHITE = rb.getString("WHITE");
        CustomizeMenu.YELLOW = rb.getString("YELLOW");
        CustomizeMenu.LIGHT_GRAY = rb.getString("LIGHT_GRAY");
        CustomizeMenu.color = rb.getString("color");
        CustomizeMenu.Figure = rb.getString("Figure");
        CustomizeMenu.oval = rb.getString("Oval");
        CustomizeMenu.rectangle = rb.getString("Rectangle");
        CustomizeMenu.customMenu = rb.getString("customizeMenu");

        //Меню Кастомизации
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

        //Тестовое меню
        TestMenu.TestsMenuName = rb.getString("TestsMenuName");
        TestMenu.TestsMenuCommands = rb.getString("TestsMenuCommands");
        TestMenu.MessageInLog = rb.getString("MessageInLog");
        TestMenu.newString = rb.getString("newString");

        TestMenu.testMenu.setText(rb.getString("TestsMenuName"));
        TestMenu.testMenu.getItem(0).setText(rb.getString("MessageInLog"));

        //Меню отображения
        LookAndFeelMenu.DisplayMode = rb.getString("DisplayMode");
        LookAndFeelMenu.systemScheme = rb.getString("systemScheme");
        LookAndFeelMenu.universalScheme = rb.getString("universalScheme");
        LookAndFeelMenu.setupUniversalScheme = rb.getString("setupUniversalScheme");
        LookAndFeelMenu.setupSystemScheme = rb.getString("setupSystemScheme");


        LookAndFeelMenu.lookAndFeelMenu.setText(rb.getString("DisplayMode"));
        LookAndFeelMenu.lookAndFeelMenu.getItem(0).setText(rb.getString("systemScheme"));
        LookAndFeelMenu.lookAndFeelMenu.getItem(1).setText(rb.getString("universalScheme"));

        //Меню опций
        OptionsMenu.Options = rb.getString("Options");
        OptionsMenu.Exit = rb.getString("Exit");
        OptionsMenu.language = rb.getString("language");

        OptionsMenu.optionsMenu.setText(OptionsMenu.Options);
        OptionsMenu.optionsMenu.getItem(0).setText(OptionsMenu.Exit);
        OptionsMenu.optionsMenu.getItem(1).setText(OptionsMenu.language);
    }
}