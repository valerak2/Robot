package game.logic.timer;

import game.logic.GameVisualizer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerMoveObject {
    static GameVisualizer gameVisualizer = null;
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);


    public TimerMoveObject(GameVisualizer gameVisualizer) {
        TimerMoveObject.gameVisualizer = gameVisualizer;
    }

    public void run() {
        executor.scheduleAtFixedRate(TimerTasksMove.moveShots, 0, 4, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(TimerTasksMove.moveFirstRobot, 0, 4, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(TimerTasksMove.moveSecondRobot, 0, 12, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(TimerTasksMove.moveEnemies, 0, 18, TimeUnit.MILLISECONDS);
    }
}
