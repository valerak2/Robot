package game.logic.сollisionController;

import game.GameVisualizer;
import game.objectsOnField.ObjectOnTheField;
import game.objectsOnField.movingObjects.enemies.Comet;
import game.objectsOnField.movingObjects.enemies.Cruiser;
import game.objectsOnField.movingObjects.enemies.Hunter;
import game.objectsOnField.movingObjects.robot.Robot;
import game.objectsOnField.stationaryObjects.bonuses.Bonus;
import game.objectsOnField.stationaryObjects.bonuses.Heart;
import game.objectsOnField.stationaryObjects.bonuses.ResetRobot;
import game.objectsOnField.stationaryObjects.bonuses.Speed;
import game.objectsOnField.stationaryObjects.obstacle.Asteroid;
import game.objectsOnField.stationaryObjects.obstacle.BlackHole;
import game.objectsOnField.stationaryObjects.obstacle.Nebula;
import game.objectsOnField.stationaryObjects.obstacle.Obstacle;

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
                collisionsTarget();
            }
        }, 0, 4, TimeUnit.MILLISECONDS);

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

    public void collisionsTarget() {
        if (gameVisualizer.scorePoint.checkCollision(gameVisualizer.firstRobot)
                || gameVisualizer.scorePoint.checkCollision(gameVisualizer.secondRobot)
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
                checkCollisions(
                        objects, robot);
            }
        };
    }

    public <ObjectOnField extends ObjectOnTheField> void checkCollisions(
            ArrayList<ObjectOnField> objects, Robot robot) {
        ArrayList<ObjectOnField> crashed = new ArrayList<>();
        for (ObjectOnField object : objects) {
            if (robot.checkCollision(object)) {
                String name = object.getClass().getSimpleName();
                System.out.println(name);
               /* switch (name){
                    case "Hunter"  :((Hunter) object).damage(robot);
                    case "Comet" :((Comet) object).damage(robot);
                    case "Cruiser" :((Cruiser) object).damage(robot);
                    case "Asteroid" :((Asteroid) object).damage(robot);
                    case "BlackHole" : ((BlackHole) object).damage(robot);
                    case "Nebula" : ((Nebula) object).damage(robot);
                    case "Heart" : ((Heart) object).effect(robot);
                    case "ResetRobot" : ((ResetRobot) object).effect(robot);
                    case "Speed" : ((Speed) object).effect(robot);
                }*/
                objects.remove(object);
                System.out.println(objects.contains(object));
            }
        }
        for (ObjectOnField object : crashed) {
            System.out.println("b");
            objects.remove(object);

        }
    }
    private<ObjectOnField extends ObjectOnTheField> void collision(ObjectOnField object, Robot robot){
        String name = object.getClass().getSimpleName();
        System.out.println(name);
        switch (name){
            case "Hunter"  :((Hunter) object).damage(robot);
            case "Comet" :((Comet) object).damage(robot);
            case "Cruiser" :((Cruiser) object).damage(robot);
            case "Asteroid" :((Asteroid) object).damage(robot);
            case "BlackHole" : ((BlackHole) object).damage(robot);
            case "Nebula" : ((Nebula) object).damage(robot);
            case "Heart" : ((Heart) object).effect(robot);
            case "ResetRobot" : ((ResetRobot) object).effect(robot);
            case "Speed" : ((Speed) object).effect(robot);
        }
    }

    public <ObjectOnField extends Bonus> void checkCollisionsWithBonus(
             ArrayList<ObjectOnField> bonuses, Robot robot) {
        ArrayList<ObjectOnField> crashed = new ArrayList<>();
        for (ObjectOnField bonus : bonuses) {
            if (bonus.checkCollision(robot)) {
                bonus.effect(robot);
                crashed.add(bonus);
            }
        }
        for (ObjectOnField object : crashed) {
            bonuses.remove(object);

        }
    }
    public void checkCollisionsWithObstacle(
            ArrayList<Obstacle> obstacles, Robot robot) {
        ArrayList<Obstacle> crashed = new ArrayList<>();
        for (Obstacle obstacle : obstacles) {
            if (robot.checkCollision(obstacle)) {
                obstacle.damage(robot);
                crashed.add(obstacle);
            }
        }
        for (Obstacle object : crashed) {
            obstacles.remove(object);

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


