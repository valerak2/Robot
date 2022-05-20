package game.logic.сollisionController;

import game.GameVisualizer;
import game.objectsOnField.ObjectOnTheField;
import game.objectsOnField.movingObjects.enemies.Hunter;
import game.objectsOnField.movingObjects.robot.Robot;
import game.objectsOnField.stationaryObjects.bonuses.Bonus;
import game.objectsOnField.stationaryObjects.obstacle.Obstacle;

import java.awt.*;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CollisionsWithRobot {
    final GameVisualizer gameVisualizer;

    public CollisionsWithRobot(GameVisualizer gameVisualizer) {
        this.gameVisualizer = gameVisualizer;
    }

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(12);

    // TODO: 20.05.2022 переделать
    public void run() {
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                collisionsTarget(gameVisualizer.g2d);
            }
        }, 0, 4, TimeUnit.MILLISECONDS);

        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkCollisions(gameVisualizer.g2d,
                        gameVisualizer.bonuses, gameVisualizer.firstRobot);
            }
        }, 0, 4, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkCollisions(gameVisualizer.g2d,
                        gameVisualizer.bonuses, gameVisualizer.secondRobot);
            }
        }, 0, 4, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkCollisions(gameVisualizer.g2d,
                        gameVisualizer.obstacles, gameVisualizer.firstRobot);
            }
        }, 0, 4, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkCollisions(gameVisualizer.g2d,
                        gameVisualizer.obstacles, gameVisualizer.secondRobot);
            }
        }, 0, 4, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkCollisions(gameVisualizer.g2d,
                        gameVisualizer.enemies, gameVisualizer.firstRobot);

            }
        }, 0, 4, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                checkCollisions(gameVisualizer.g2d,
                        gameVisualizer.enemies, gameVisualizer.secondRobot);
            }
        }, 0, 4, TimeUnit.MILLISECONDS);
    }

    public void collisionsTarget(Graphics2D g) {
        if (gameVisualizer.scorePoint.checkCollision(g, gameVisualizer.firstRobot)
                || gameVisualizer.scorePoint.checkCollision(g, gameVisualizer.secondRobot)
        ) {

            gameVisualizer.scorePoint.getScore(gameVisualizer.firstRobot);
            gameVisualizer.scorePoint = gameVisualizer.creator.scorePoint();

        }
    }

    private <ObjectOnField extends ObjectOnTheField> TimerTask createTimerTask(
            Robot robot, ArrayList<ObjectOnField> objects) {
        return new TimerTask() {
            @Override
            public void run() {
                checkCollisions(gameVisualizer.g2d,
                        objects, robot);
            }
        };
    }

    public <ObjectOnField extends ObjectOnTheField> void checkCollisions(
            Graphics2D g, ArrayList<ObjectOnField> objects, Robot robot) {
        ArrayList<ObjectOnField> crashed = new ArrayList<>();
        for (ObjectOnField object : objects) {
            if (object.checkCollision(g, robot)) {

                if (object.getClass().getName().equals(Hunter.class.getName())) {
                    ((Hunter) object).damage(robot);
                    gameVisualizer.modelUpdateEvent.removePropertyChangeListener((Hunter) object);
                } else if (object.getClass().getName().equals(Bonus.class.getName())) {
                    ((Bonus) object).effect(robot);
                } else if (object.getClass().getName().equals(Obstacle.class.getName())) {
                    ((Obstacle) object).damage(robot);
                }
                crashed.add(object);
            }
        }
        for (ObjectOnField object : crashed) {
            objects.remove(object);

        }
    }

    // TODO: 19.05.2022 доделать логику воскрешения роботов
    private Boolean checkRobotLife() {
        return gameVisualizer.firstRobot.getLife() == 0
                || gameVisualizer.secondRobot.getLife() == 0;
    }

    private Robot getRobot() {
        if (gameVisualizer.firstRobot.getLife() <= 0) {
            return gameVisualizer.firstRobot;
        } else {
            return gameVisualizer.secondRobot;
        }
    }

}


