package gui.windows;

import gui.menu.CloseDialogPanel;

import javax.swing.*;
import java.awt.*;

public class CoordinateWindow extends JInternalFrame{
    static TextArea m_logContent;
    private static double robotPositionX;
    private static double robotPositionY;

    public CoordinateWindow() {
        super("Координаты робота", true, true, true, true);
        m_logContent = new TextArea("");
        m_logContent.setEditable(true);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_logContent, BorderLayout.CENTER);
        getContentPane().add(panel);
        CloseDialogPanel.addJInternalListener(this);
    }
    public void updateCoordinateRobot(double robotPositionX1, double robotPositionY1) {
        robotPositionX = robotPositionX1;
        robotPositionY = robotPositionY1;
        printCoordinateRobot();

    }
    private static void printCoordinateRobot() {
        String content = "X: " + robotPositionX + "\n" +
                "Y: " + robotPositionY;
        m_logContent.setText(content);
        m_logContent.invalidate();
    }
}
