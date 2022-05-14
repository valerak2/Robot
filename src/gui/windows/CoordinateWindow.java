package gui.windows;

import game.objectsOnField.movingObjects.robot.Robot;
import gui.localization.Language;
import gui.menu.CloseDialogPanel;

import javax.swing.*;
import java.awt.*;
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
        //printCoordinateRobot((Point) evt.getNewValue());
        printP((Robot []) evt.getNewValue());

    }

    private void printP(Robot[] robots) {
        Robot firstRobot = robots[0];
        Robot secondRobot = robots[1];
        String content = "Робот 1: \n"
                + "     X: " + firstRobot.getPosition().x + "\n"
                + "     Y: " + firstRobot.getPosition().y + "\n"
                + "     жизни: " + firstRobot.getLife() + "\n"
                + "Робот 2: \n"
                + "     X: " + secondRobot.getPosition().x + "\n"
                + "     Y: " + secondRobot.getPosition().y + "\n"
                + "     жизни: " + secondRobot.getLife() + "\n"
                + "Очки: " + Robot.score;
        tableCoordinate.setText(content);
        tableCoordinate.invalidate();
    }

}

