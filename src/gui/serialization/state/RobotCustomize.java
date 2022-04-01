package gui.serialization.state;

import java.awt.*;
import java.io.Serializable;

public record RobotCustomize(Color colorRobots, String figureRobots) implements Serializable {
}
