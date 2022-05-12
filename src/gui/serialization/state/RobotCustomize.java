package gui.serialization.state;

import java.awt.*;
import java.io.Serializable;
/**
 Промежуточные состояния кастомизации робота(цвет и форма)
 */
public record RobotCustomize(Color colorRobots, String figureRobots) implements Serializable {
}
