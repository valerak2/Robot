package gui.menu;

import gui.MainApplicationFrame;
import gui.menu.customize.CustomizeMenu;
import gui.menu.options.OptionsMenu;

import javax.swing.*;

public class MenuBar {
    public JMenuBar generate(MainApplicationFrame mainApplicationFrame) {
        JMenuBar menuBar = new JMenuBar();
        TestMenu testMenu = new TestMenu();
        CustomizeMenu customizeMenu = new CustomizeMenu();
        OptionsMenu optionsMenu = new OptionsMenu();

        menuBar.add(LookAndFeelMenu.addLookAndFeelMenu(mainApplicationFrame));
        menuBar.add(testMenu.initialization());
        menuBar.add(customizeMenu.initialization());
        menuBar.add(optionsMenu.initialization());

        return menuBar;
    }
}
