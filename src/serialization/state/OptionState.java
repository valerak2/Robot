package serialization.state;

import java.io.Serializable;

/**
 Промежуточные состояния некоторых настроек приложения
 */
public record OptionState(String language, String test)  implements Serializable {
}
