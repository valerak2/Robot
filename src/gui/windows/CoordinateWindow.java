package gui.windows;

import gui.localization.Language;
import gui.menu.CloseDialogPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ResourceBundle;

public class CoordinateWindow extends JInternalFrame implements PropertyChangeListener {
    private static CoordinateWindow INSTANCE;
    TextArea tableCoordinate;

    public CoordinateWindow() {
        super(ResourceBundle.getBundle("lang", Language.language).getString("coordinateWindow.name"), true, true, true, true);
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
        String content = "X: " + (int) point.x + "\n" +
                "Y: " + (int) point.y;
        tableCoordinate.setText(content);
        tableCoordinate.invalidate();
    }
}

