package game.logic.ñollisionController;

import game.GameVisualizer;
import game.objectsOnField.movingObjects.robot.CrashedRobot;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CheckerLifeRobot {
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
            gameVisualizer.firstRobot = new CrashedRobot(
                    gameVisualizer.firstRobot.getPosition(),
                    gameVisualizer.firstRobot.getTarget());
        }
        if (gameVisualizer.secondRobot.getLife() <= 0) {
            gameVisualizer.secondRobot = new CrashedRobot(
                    gameVisualizer.secondRobot.getPosition(),
                    gameVisualizer.secondRobot.getTarget());
        }
    }
}
