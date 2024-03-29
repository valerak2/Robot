package serialization.state;

import java.io.Serializable;
/**
Промежуточные состояния параметров окон
 */
public record WindowState(int width, int height, int positionX, int positionY,
                           boolean isIcon) implements Serializable {

}
