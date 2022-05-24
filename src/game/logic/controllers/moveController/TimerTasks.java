package game.logic.controllers.moveController;

import game.GameVisualizer;
import game.objectsOnField.movingObjects.MovingObjects;
import game.objectsOnField.movingObjects.Shot;

public enum TimerTasks implements Runnable {
    moveShots {
        @Override
        public void run() {
            for (Shot shot : gameVisualizer.shots) {
                shot.move();
            }
        }
    },
    moveFirstRobot {
        @Override
        public void run() {
            gameVisualizer.firstRobot.move();

        }
    },
    moveSecondRobot {
        @Override
        public void run() {
            gameVisualizer.secondRobot.move();
            gameVisualizer.modelUpdateEvent.onModelUpdateEvent(
                    gameVisualizer.firstRobot, gameVisualizer.secondRobot);
        }
    },
    moveEnemies {
        @Override
        public void run() {
            for (MovingObjects enemy : gameVisualizer.enemies) {
                enemy.move();
            }
        }
    };
    GameVisualizer gameVisualizer = MoveController.gameVisualizer;
}
