package game.logic.controllers.paintController;

import game.GameVisualizer;
import game.logic.controllers.Controller;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameOverController implements Controller {
    private final GameVisualizer gameVisualizer;

    public GameOverController(GameVisualizer gameVisualizer) {
        this.gameVisualizer = gameVisualizer;
        run();
    }

    @Override
    public void run() {
        ScheduledExecutorService checker = Executors.newSingleThreadScheduledExecutor();
        checker.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkGameOver();
            }
        }, 0, 3, TimeUnit.MILLISECONDS);
    }

    private void checkGameOver() {
        if (gameVisualizer.firstRobot.getLife() <= 0 & gameVisualizer.secondRobot.getLife() <= 0) {
            PaintControllers.gameOver = true;
        }
    }
}
