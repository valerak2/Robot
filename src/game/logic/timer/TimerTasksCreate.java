package game.logic.timer;

import game.logic.GameVisualizer;
import game.objectsOnField.movingObjects.enemies.Hunter;

public enum TimerTasksCreate implements Runnable {
    createAsteroid {
        @Override
        public void run() {
            gameVisualizer.obstacles.add(creator.asteroid());
        }
    },

    createNebula {
        @Override
        public void run() {
            gameVisualizer.obstacles.add(creator.nebula());
        }
    },
    createBlackHole {
        @Override
        public void run() {
            gameVisualizer.obstacles.add(creator.blackHole());
        }
    }, createHeart {
        @Override
        public void run() {
            gameVisualizer.bonuses.add(creator.heart());
        }
    },
    createSpeed {
        @Override
        public void run() {
            gameVisualizer.bonuses.add(creator.speed());
        }
    },
    createResetRobot {
        @Override
        public void run() {
            gameVisualizer.bonuses.add(creator.resetRobot());
        }
    },
    createHunter1 {
        @Override
        public void run() {
            Hunter hunter = creator.hunter(gameVisualizer.firstRobot);
            hunter.indexRobot = 0;
            gameVisualizer.enemies.add(hunter);
            gameVisualizer.modelUpdateEvent.addPropertyChangeListener(hunter);
        }
    },
    createHunter2 {
        @Override
        public void run() {
            Hunter hunter = creator.hunter(gameVisualizer.secondRobot);
            hunter.indexRobot = 1;
            gameVisualizer.enemies.add(hunter);
            gameVisualizer.modelUpdateEvent.addPropertyChangeListener(hunter);
        }
    },
    createComet {
        @Override
        public void run() {
            gameVisualizer.enemies.add(creator.comet());
        }
    },
    createCruiser {
        @Override
        public void run() {
            gameVisualizer.enemies.add(creator.cruiser());
        }
    },
    ;
    GameVisualizer gameVisualizer = TimerCreator.gameVisualizer;
    Creator creator = new Creator();
}
