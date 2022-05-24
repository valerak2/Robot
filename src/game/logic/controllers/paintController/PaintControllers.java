package game.logic.controllers.paintController;

import game.GameVisualizer;
import game.logic.controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PaintControllers {
    static volatile Boolean gameOver = false;
    public RepaintGame repaintGame;

    public PaintControllers(GameVisualizer gameVisualizer) {
        repaintGame = new RepaintGame(gameVisualizer);
        new GameOverController(gameVisualizer);
    }

}
