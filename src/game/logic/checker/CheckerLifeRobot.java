package game.logic.checker;

import game.logic.GameVisualizer;
import game.objectsOnField.movingObjects.robot.CrashedRobot ;

public class CheckerLifeRobot {
    final GameVisualizer gameVisualizer;
    public CheckerLifeRobot(GameVisualizer gameVisualizer) {
        this.gameVisualizer = gameVisualizer;
    }
    //@Override
    public void run() {
        checkDeath();
        gameOver();
    }
    private void gameOver() {
        if (gameVisualizer.firstRobot.getLife() <= 0 & gameVisualizer.secondRobot.getLife() <= 0) {
            gameVisualizer.gameOver = true;
        }
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
