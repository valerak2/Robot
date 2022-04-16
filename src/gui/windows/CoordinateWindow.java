package gui.windows;

import gui.menu.CloseDialogPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CoordinateWindow extends JInternalFrame implements PropertyChangeListener {
    private static CoordinateWindow INSTANCE;
    TextArea tableCoordinate;

    public CoordinateWindow() {
        super("Координаты робота", true, true, true, true);
        tableCoordinate = new TextArea("");
        tableCoordinate.setEditable(true);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(tableCoordinate, BorderLayout.CENTER);
        getContentPane().add(panel);
        CloseDialogPanel.addJInternalListener(this);
    }
    public static CoordinateWindow getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CoordinateWindow();
        }
        return INSTANCE;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.printCoordinateRobot((Point2D.Double) evt.getNewValue());

    }


    private void printCoordinateRobot(Point2D.Double point) {
        String content = "X: " + point.x + "\n" +
                "Y: " + point.y;
        tableCoordinate.setText(content);
        tableCoordinate.invalidate();
    }

}
