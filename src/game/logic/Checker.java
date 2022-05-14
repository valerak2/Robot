package game.logic;

import game.objectsOnField.ObjectOnTheField;
import game.objectsOnField.movingObjects.enemies.Hunter;
import game.objectsOnField.movingObjects.robot.CrashedRobot;
import game.objectsOnField.movingObjects.robot.Robot;
import game.objectsOnField.stationaryObjects.bonuses.Bonus;
import game.objectsOnField.stationaryObjects.obstacle.Obstacle;

import java.awt.*;
import java.util.ArrayList;

public class Checker {
    GameVisualizer gameVisualizer;

    public Checker(GameVisualizer gameVisualizer) {
        this.gameVisualizer = gameVisualizer;
    }

    public void collisionsTarget(Graphics2D g) {
        if (gameVisualizer.scorePoint.checkCollision(g, gameVisualizer.firstRobot)
                || gameVisualizer.scorePoint.checkCollision(g, gameVisualizer.secondRobot)
        ) {
            gameVisualizer.scorePoint.getScore(gameVisualizer.firstRobot);
            gameVisualizer.scorePoint = gameVisualizer.creator.scorePoint();
        }
    }

    public <ObjectOnField extends ObjectOnTheField> void collisionsObjects
            (Graphics2D g, ArrayList<ObjectOnField> objects) {
        checkCollisions(g, objects, gameVisualizer.firstRobot);
        checkCollisions(g, objects, gameVisualizer.secondRobot);
    }

    private <ObjectOnField extends ObjectOnTheField> void checkCollisions(
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
        checkDeath();
        gameOver();
    }

    private void gameOver() {
        if (gameVisualizer.firstRobot.getLife() <= 0 & gameVisualizer.secondRobot.getLife() <= 0) {
            gameVisualizer.gameOver = true;
        }
    }

    private void checkDeath() {
        if (gameVisualizer.firstRobot.getLife() <= 0) {
            gameVisualizer.firstRobot = new CrashedRobot(
                    gameVisualizer.firstRobot.getPosition(),
                    gameVisualizer.firstRobot.getTarget());
        }
        if (gameVisualizer.secondRobot.getLife() <= 0) {
            gameVisualizer.secondRobot = new CrashedRobot(
                    gameVisualizer.secondRobot.getPosition(),
                    gameVisualizer.secondRobot.getTarget());
        }
    }


}
