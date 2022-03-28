package gui.menu;

import gui.windows.GameWindow;
import gui.windows.LogWindow;
import gui.MainApplicationFrame;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EventObject;

public class CloseDialogPane {
    public static JFrame frame;


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
        Object[] options = {"Да", "Нет!"};
        int n = JOptionPane
                .showOptionDialog(((Component) eventObject.getSource()), "Закрыть окно?",
                        "Подтверждение", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
        if (n == 0) {
            if ((eventObject.getSource()) == LogWindow.class) {
                ((Component) eventObject.getSource()).setVisible(false);
            }

            if ((eventObject.getSource()).getClass() == MainApplicationFrame.class) {
                ((Component) eventObject.getSource()).setVisible(false);
                System.exit(0);
            }

            if ((eventObject.getSource()).getClass() == JMenuItem.class) {
                System.exit(0);
            }

            if ((eventObject.getSource()).getClass() == GameWindow.class) {
                ((Component) eventObject.getSource()).setVisible(false);
            }
        }
    }

}
