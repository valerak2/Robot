package game.logic.controllers.ñollisionController;

import game.GameVisualizer;
import game.logic.controllers.IController;
import game.logic.loadEnemy.LoadedEnemyLogic;
import game.objectsOnField.ObjectOnTheField;
import game.objectsOnField.movingObjects.enemies.Comet;
import game.objectsOnField.movingObjects.enemies.Cruiser;
import game.objectsOnField.movingObjects.enemies.Hunter;
import game.objectsOnField.movingObjects.robot.Robot;
import game.objectsOnField.stationaryObjects.bonuses.Heart;
import game.objectsOnField.stationaryObjects.bonuses.ResetRobot;
import game.objectsOnField.stationaryObjects.bonuses.Speed;
import game.objectsOnField.stationaryObjects.obstacle.Asteroid;
import game.objectsOnField.stationaryObjects.obstacle.BlackHole;
import game.objectsOnField.stationaryObjects.obstacle.Nebula;

import java.util.ArrayList;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CollisionsWithRobot implements IController {
    final GameVisualizer gameVisualizer;

    public CollisionsWithRobot(GameVisualizer gameVisualizer) {
        this.gameVisualizer = gameVisualizer;
    }

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(7);

    public void run() {
        timerTarget();
        timerBonus();
        timerObstacle();
        timerEnemies();
        timerLoadedEnemy();
    }

    private void timerTarget() {
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                collisionsTarget();
            }
        }, 0, 4, TimeUnit.MILLISECONDS);

    }

    private void timerBonus() {
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkCollisions(
                        gameVisualizer.bonuses, gameVisualizer.firstRobot);
            }
        }, 0, 4, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkCollisions(
                        gameVisualizer.bonuses, gameVisualizer.secondRobot);
            }
        }, 0, 4, TimeUnit.MILLISECONDS);
    }
    private void timerLoadedEnemy() {
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkCollisionsForEnemyLogic(
                        gameVisualizer.l_enemies, gameVisualizer.firstRobot);
            }
        }, 0, 4, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkCollisionsForEnemyLogic(
                        gameVisualizer.l_enemies, gameVisualizer.secondRobot);
            }
        }, 0, 4, TimeUnit.MILLISECONDS);
    }

    private void timerObstacle() {
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkCollisions(
                        gameVisualizer.obstacles, gameVisualizer.firstRobot);
            }
        }, 0, 4, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkCollisions(
                        gameVisualizer.obstacles, gameVisualizer.secondRobot);
            }
        }, 0, 4, TimeUnit.MILLISECONDS);
    }

    private void timerEnemies() {
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkCollisions(
                        gameVisualizer.enemies, gameVisualizer.firstRobot);

            }
        }, 0, 4, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                checkCollisions(
                        gameVisualizer.enemies, gameVisualizer.secondRobot);
            }
        }, 0, 4, TimeUnit.MILLISECONDS);
    }


    private void collisionsTarget() {
        if (gameVisualizer.firstRobot.checkCollision(gameVisualizer.scorePoint)
                || gameVisualizer.secondRobot.checkCollision(gameVisualizer.scorePoint)
        ) {

            gameVisualizer.scorePoint.getScore(gameVisualizer.firstRobot);
            gameVisualizer.scorePoint = gameVisualizer.creator.scorePoint();

        }
    }

    public <ObjectOnField extends ObjectOnTheField> void checkCollisions(
            ArrayList<ObjectOnField> objects, Robot robot) {
        ArrayList<ObjectOnField> crashed = new ArrayList<>();
        for (ObjectOnField object : objects) {
            if (robot.checkCollision(object)) {
                collision(object, robot);
                crashed.add(object);
            }
        }
        for (ObjectOnField object : crashed) {
            objects.remove(object);

        }
    }
    public void checkCollisionsForEnemyLogic(
            ArrayList<LoadedEnemyLogic> objects, Robot robot) {
        ArrayList<LoadedEnemyLogic> crashed = new ArrayList<>();
        for (LoadedEnemyLogic enemy : objects) {
            if (enemy.checkCollisions(robot)) {
                enemy.damage(robot);
                crashed.add(enemy);
            }
        }
        for (LoadedEnemyLogic enemy : crashed) {
            objects.remove(enemy);

        }
    }


    private <ObjectOnField extends ObjectOnTheField> void collision(ObjectOnField object, Robot robot) {
        String name = object.getClass().getSimpleName();
        switch (name) {
            case "Hunter" -> ((Hunter) object).damage(robot);
            case "Comet" -> ((Comet) object).damage(robot);
            case "Cruiser" -> ((Cruiser) object).damage(robot);
            case "Asteroid" -> ((Asteroid) object).damage(robot);
            case "BlackHole" -> ((BlackHole) object).damage(robot);
            case "Nebula" -> ((Nebula) object).damage(robot);
            case "Heart" -> ((Heart) object).effect(robot);
            case "ResetRobot" -> ((ResetRobot) object).effect(robot);
            case "Speed" -> ((Speed) object).effect(robot);
        }
    }
}


