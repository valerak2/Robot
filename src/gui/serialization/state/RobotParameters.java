package gui.serialization.state;

import java.io.Serializable;
/**
 ������������� ��������� ���������� ������
 */
public record RobotParameters(int robotPositionX,
                              int robotPositionY,
                              double robotDirection,
                              int targetPositionX,
                              int targetPositionY) implements Serializable {
}
