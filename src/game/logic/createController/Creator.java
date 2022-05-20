package game.logic.createController;

import game.objectsOnField.movingObjects.enemies.Comet;
import game.objectsOnField.movingObjects.enemies.Cruiser;
import game.objectsOnField.movingObjects.enemies.Hunter;
import game.objectsOnField.movingObjects.robot.Robot;
import game.objectsOnField.stationaryObjects.ScorePoint;
import game.objectsOnField.stationaryObjects.bonuses.Heart;
import game.objectsOnField.stationaryObjects.bonuses.ResetRobot;
import game.objectsOnField.stationaryObjects.bonuses.Speed;
import game.objectsOnField.stationaryObjects.obstacle.Asteroid;
import game.objectsOnField.stationaryObjects.obstacle.BlackHole;
import game.objectsOnField.stationaryObjects.obstacle.Nebula;

import java.awt.*;

public class Creator {
    final int minCoordinate = 0;
    final int maxCoordinate = 1200;

    public Point randomPoint() {
        int x = (int) ((Math.random() * (maxCoordinate - minCoordinate)) + minCoordinate);
        int y = (int) ((Math.random() * (maxCoordinate - minCoordinate)) + minCoordinate);
        return new Point(x, y);
    }

    public Heart heart() {
        return new Heart(randomPoint());
    }

    public Speed speed() {
        return new Speed(randomPoint());
    }

    public ResetRobot resetRobot() {
        return new ResetRobot(randomPoint());
    }

    public Asteroid asteroid() {
        return new Asteroid(randomPoint());
    }

    public Nebula nebula() {
        return new Nebula(randomPoint());
    }

    public BlackHole blackHole() {
        return new BlackHole(randomPoint());
    }

    public Hunter hunter(Robot robot) {
        return new Hunter(randomPoint(), robot.getPosition());
    }

    public Comet comet() {
        return new Comet(randomPoint());
    }

    public Cruiser cruiser() {
        return new Cruiser(randomPoint(), randomPoint());
    }

    public ScorePoint scorePoint() {
        return new ScorePoint(randomPoint());
    }
}
