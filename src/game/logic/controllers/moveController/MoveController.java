package game.logic.controllers.moveController;

import game.GameVisualizer;
import game.logic.controllers.Controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MoveController implements Controller {
    static GameVisualizer gameVisualizer = null;
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);


    public MoveController(GameVisualizer gameVisualizer) {
        MoveController.gameVisualizer = gameVisualizer;
        run();
    }
    @Override
    public void run() {
        executor.scheduleAtFixedRate(TimerTasks.moveShots, 0, 4, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(TimerTasks.moveFirstRobot, 0, 4, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(TimerTasks.moveSecondRobot, 0, 12, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(TimerTasks.moveEnemies, 0, 18, TimeUnit.MILLISECONDS);
    }
}
