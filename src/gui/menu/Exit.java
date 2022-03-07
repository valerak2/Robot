package gui.menu;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Exit {

    public static void addWindowListener(JFrame frame) {
        frame.addWindowListener(new WindowListener() {

            public void windowActivated(WindowEvent event) {

            }

            public void windowClosed(WindowEvent event) {

            }

            public void windowClosing(WindowEvent event) {
                exit(event);
            }

            public void windowDeactivated(WindowEvent event) {

            }

            public void windowDeiconified(WindowEvent event) {

            }

            public void windowIconified(WindowEvent event) {

            }

            public void windowOpened(WindowEvent event) {

            }

        });

    }

    public static void addJInternalListener(JInternalFrame frame) {
        frame.addInternalFrameListener(new InternalFrameListener() {


            public void internalFrameOpened(InternalFrameEvent e) {

            }


            public void internalFrameClosing(InternalFrameEvent e) {
                exit(e);
            }


            public void internalFrameClosed(InternalFrameEvent e) {

            }


            public void internalFrameIconified(InternalFrameEvent e) {

            }


            public void internalFrameDeiconified(InternalFrameEvent e) {

            }


            public void internalFrameActivated(InternalFrameEvent e) {

            }


            public void internalFrameDeactivated(InternalFrameEvent e) {

            }
        });
    }


    public static void exit(WindowEvent event) {
        Object[] options = {"Да", "Нет!"};
        int n = JOptionPane
                .showOptionDialog(event.getWindow(), "Закрыть окно?",
                        "Подтверждение", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
        if (n == 0) {
            event.getWindow().setVisible(false);
            System.exit(0);
        }
    }

    public static void exit(InternalFrameEvent event) {
        Object[] options = {"Да", "Нет!"};
        int n = JOptionPane
                .showOptionDialog(event.getInternalFrame(), "Закрыть окно?",
                        "Подтверждение", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
        if (n == 0) {
            event.getInternalFrame().setVisible(false);
            //System.exit(0);
        }
    }

    public static void exit(ActionEvent event, JFrame frame) {
        Object[] options = {"Да", "Нет!"};
        int n = JOptionPane
                .showOptionDialog(frame, "Закрыть окно?",
                        "Подтверждение", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
        if (n == 0) {
            frame.setVisible(false);
            System.exit(0);
        }
    }


}
