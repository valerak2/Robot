package serialization.state;

import java.awt.*;
import java.io.Serializable;
/**
 ѕромежуточные состо€ни€ параметров робота
 */
public record RobotParameters(Point position, Point target) implements Serializable {
}
