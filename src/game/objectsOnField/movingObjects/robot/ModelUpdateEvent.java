package game.objectsOnField.movingObjects.robot;

import gui.windows.CoordinateWindow;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelUpdateEvent {
    private final PropertyChangeSupport support;
    CoordinateWindow coordinateWindow = CoordinateWindow.getInstance();

    public ModelUpdateEvent() {
        support = new PropertyChangeSupport(this);
        addPropertyChangeListener(coordinateWindow);
    }

    public void onModelUpdateEvent(Robot firstRobot, Robot secondRobot) {
        Robot[] robots = {firstRobot, secondRobot};
        support.firePropertyChange("robots", 0, robots);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
}
