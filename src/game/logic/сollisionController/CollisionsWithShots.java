package game.logic.сollisionController;

import game.GameVisualizer;
import game.objectsOnField.ObjectOnTheField;
import game.objectsOnField.movingObjects.Shot;

import java.awt.*;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CollisionsWithShots {
    final GameVisualizer gameVisualizer;

    public CollisionsWithShots(GameVisualizer gameVisualizer) {
        this.gameVisualizer = gameVisualizer;
    }

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

    // TODO: 19.05.2022 оптимизировать и отрефакторить
    public void run() {
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (Shot shot : gameVisualizer.shots) {
                    checkCollisionsWithShot(gameVisualizer.g2d,
                            gameVisualizer.enemies, shot);
                }
            }
        }, 0, 5, TimeUnit.MILLISECONDS);
    }

    private <ObjectOnField extends ObjectOnTheField> void checkCollisionsWithShot(
            Graphics2D g, ArrayList<ObjectOnField> objects, Shot shot) {
        ArrayList<ObjectOnField> crashedObject = new ArrayList<>();
        Shot crashedShots;
        for (ObjectOnField object : objects) {
            if (object.checkCollision(shot)) {
                crashedObject.add(object);
                crashedShots= shot;
            }}
        if (shot.getPosition().equals(shot.getTarget())){
            gameVisualizer.shots.remove(shot);
        }
        for (ObjectOnField object : crashedObject) {
            objects.remove(object);
        }
        }


}
