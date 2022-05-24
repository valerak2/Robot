package game.logic.controllers.createController;

import game.GameVisualizer;
import game.logic.controllers.Controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CreateController implements Controller {
    static GameVisualizer gameVisualizer = null;
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

    public CreateController(GameVisualizer gameVisualizer) {
        CreateController.gameVisualizer = gameVisualizer;
        run();
    }

    @Override
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
}





