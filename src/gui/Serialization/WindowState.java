package gui.Serialization;

import java.io.Serializable;

public record WindowState(int width, int height, int positionX, int positionY,
                          boolean isClosed) implements Serializable {


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public boolean isClosed() {
        return isClosed;
    }

}
