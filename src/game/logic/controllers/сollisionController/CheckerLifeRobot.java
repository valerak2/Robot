package game.logic.controllers.ñollisionController;

import game.GameVisualizer;
import game.logic.controllers.Controller;
import game.objectsOnField.movingObjects.robot.CrashedRobot;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CheckerLifeRobot implements Controller {
    final GameVisualizer gameVisualizer;

    public CheckerLifeRobot(GameVisualizer gameVisualizer) {
        this.gameVisualizer = gameVisualizer;
    }

    public void run() {
        ScheduledExecutorService executor1 = Executors.newSingleThreadScheduledExecutor();
        executor1.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkDeath();

            }
        }, 0, 6, TimeUnit.MILLISECONDS);
    }

    private void checkDeath() {
        if (gameVisualizer.firstRobot.getLife() <= 0) {
            gameVisualizer.firstRobot = new CrashedRobot(gameVisualizer.firstRobot);
        }
        if (gameVisualizer.secondRobot.getLife() <= 0) {
            gameVisualizer.secondRobot = new CrashedRobot(gameVisualizer.secondRobot);
        }
    }
}
