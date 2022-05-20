package game.logic.createController;

import game.GameVisualizer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CreateController {
    static GameVisualizer gameVisualizer = null;
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
    ExecutorService executors = Executors.newFixedThreadPool(12);


    public CreateController(GameVisualizer gameVisualizer) {
        CreateController.gameVisualizer = gameVisualizer;
        run();
    }

    public void run() {
        createObstacle();
        createBonus();
        createEnemies();
    }

    private void createObstacle() {
        executor.scheduleAtFixedRate(TimerTasks.createAsteroid, 0, 10, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(TimerTasks.createNebula, 5, 15, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(TimerTasks.createBlackHole, 15, 30, TimeUnit.SECONDS);
    }

    private void createBonus() {
        executor.scheduleAtFixedRate(TimerTasks.createHeart, 0, 6, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(TimerTasks.createSpeed, 5, 12, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(TimerTasks.createResetRobot, 15, 30, TimeUnit.SECONDS);
    }

    private void createEnemies() {
        executor.scheduleAtFixedRate(TimerTasks.createFirstHunter, 10, 10, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(TimerTasks.createSecondHunter, 10, 18, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(TimerTasks.createComet, 15, 30, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(TimerTasks.createCruiser, 20, 45, TimeUnit.SECONDS);

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





