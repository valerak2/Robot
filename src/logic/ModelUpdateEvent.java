package logic;

import gui.windows.CoordinateWindow;

import java.awt.geom.Point2D;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelUpdateEvent {
    private final PropertyChangeSupport support;
    CoordinateWindow coordinateWindow = CoordinateWindow.getInstance();

    public ModelUpdateEvent(){
        support = new PropertyChangeSupport(this);
        addPropertyChangeListener(coordinateWindow);
    }
    protected void onModelUpdateEvent(double x, double y) {
        Point2D.Double robotPoint = new Point2D.Double(x, y);
        support.firePropertyChange("coordinate", 0, robotPoint);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
}
