package serialization.state;

import java.awt.*;
import java.io.Serializable;
/**
 ������������� ��������� ���������� ������
 */
public record RobotParameters(Point position, Point target) implements Serializable {
}
