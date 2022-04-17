package gui.menu;

import gui.localization.Language;
import gui.MainApplicationFrame;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EventObject;
import java.util.ResourceBundle;

public class CloseDialogPanel {
    static ResourceBundle rb = ResourceBundle.getBundle("lang", Language.language);
    public static String yesOption = rb.getString("yesOption");
    public static String noOption = rb.getString("noOption");
    public static String closeWindow = rb.getString("closeWindow");
    public static String accept = rb.getString("accept");

    public static void addWindowListener(JFrame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ShowCloseDialog(e);
            }
        });
    }

    public static void addJInternalListener(JInternalFrame frame) {
        frame.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                ShowCloseDialog(e);
            }
        });
    }


    public static void ShowCloseDialog(EventObject eventObject) {
        Object[] options = {yesOption, noOption};
        int n = JOptionPane
                .showOptionDialog(((Component) eventObject.getSource()), closeWindow,
                        accept, JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
        if (n == 0) {
            if ((eventObject.getSource()) instanceof JInternalFrame) {
                ((Component) eventObject.getSource()).setVisible(false);
            }

            if ((eventObject.getSource()).getClass() == MainApplicationFrame.class || (eventObject.getSource()).getClass() == JMenuItem.class) {
                MainApplicationFrame.saveStates();
                ((Component) eventObject.getSource()).setVisible(false);
                System.exit(0);
            }
        }
    }

}
