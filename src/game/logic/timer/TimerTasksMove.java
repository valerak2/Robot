package game.logic.timer;

import game.logic.GameVisualizer;
import game.objectsOnField.movingObjects.MovingObjects;
import game.objectsOnField.movingObjects.Shot;

public enum TimerTasksMove implements Runnable {
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
    GameVisualizer gameVisualizer = TimerMoveObject.gameVisualizer;
}
