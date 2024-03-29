package serialization.state;

import java.awt.*;
import java.io.Serializable;
/**
 Промежуточные состояния параметров робота
 */
public record RobotParameters(Point position, Point target) implements Serializable {
}
