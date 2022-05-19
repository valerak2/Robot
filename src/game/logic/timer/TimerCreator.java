package game.logic.timer;

import game.logic.GameVisualizer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerCreator {
    static GameVisualizer gameVisualizer = null;
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
    ExecutorService executors = Executors.newFixedThreadPool(12);


    public TimerCreator(GameVisualizer gameVisualizer) {
        TimerCreator.gameVisualizer = gameVisualizer;
    }

    public void run() {
        createObstacle();
        createBonus();
        createEnemies();
    }

    private void createObstacle() {
        executor.scheduleAtFixedRate(TimerTasksCreate.createAsteroid, 0, 10, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(TimerTasksCreate.createNebula, 5, 15, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(TimerTasksCreate.createBlackHole, 15, 30, TimeUnit.SECONDS);
    }

    private void createBonus() {
        executor.scheduleAtFixedRate(TimerTasksCreate.createHeart, 0, 6, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(TimerTasksCreate.createSpeed, 5, 12, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(TimerTasksCreate.createResetRobot, 15, 30, TimeUnit.SECONDS);
    }

    private void createEnemies() {
        executor.scheduleAtFixedRate(TimerTasksCreate.createHunter1, 10, 10, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(TimerTasksCreate.createHunter2, 10, 18, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(TimerTasksCreate.createComet, 15, 30, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(TimerTasksCreate.createCruiser, 20, 45, TimeUnit.SECONDS);

    }


  /*  private enum TimerTasks implements Runnable {
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
        Creator creator = new Creator();
    }*/
}





