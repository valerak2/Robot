package gui.Storemanager;

import java.io.Serializable;

public record RobotParameters(double robotPositionX,
                              double robotPositionY,
                              double robotDirection,
                              int targetPositionX,
                              int targetPositionY) implements Serializable {
}
