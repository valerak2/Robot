package game.logic.controllers.ñollisionController;

import game.GameVisualizer;
import game.logic.controllers.Controller;
import game.objectsOnField.ObjectOnTheField;
import game.objectsOnField.movingObjects.Shot;

import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CollisionsWithShots implements Controller {
    final GameVisualizer gameVisualizer;

    public CollisionsWithShots(GameVisualizer gameVisualizer) {
        this.gameVisualizer = gameVisualizer;
    }

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

    public void run() {
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (Shot shot : gameVisualizer.shots) {
                    checkCollisionsWithShot(
                            gameVisualizer.obstacles, shot);
                }
            }
        }, 0, 5, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                gameVisualizer.shots.removeIf(shot -> shot.getPosition().equals(shot.getTarget()));
            }
        }, 0, 2, TimeUnit.SECONDS);
    }

    private <ObjectOnField extends ObjectOnTheField> void checkCollisionsWithShot(
            ArrayList<ObjectOnField> objects, Shot shot) {
        ArrayList<ObjectOnField> crashedObject = new ArrayList<>();

        for (ObjectOnField object : objects) {
            if (shot.checkCollision(object)) {
                crashedObject.add(object);
            }
        }
        for (ObjectOnField object : crashedObject) {
            objects.remove(object);
        }
    }


}
