package serialization.state;

import java.io.Serializable;

/**
 ������������� ��������� ��������� �������� ����������
 */
public record OptionState(String language, String test)  implements Serializable {
}
