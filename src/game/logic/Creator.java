package game.logic;

import game.objectsOnField.movingObjects.enemies.Hunter;
import game.objectsOnField.movingObjects.robot.Robot;
import game.objectsOnField.stationaryObjects.ScorePoint;
import game.objectsOnField.stationaryObjects.bonuses.Bonus;
import game.objectsOnField.stationaryObjects.bonuses.Heart;
import game.objectsOnField.stationaryObjects.bonuses.ResetRobot;
import game.objectsOnField.stationaryObjects.bonuses.Speed;
import game.objectsOnField.stationaryObjects.obstacle.Asteroid;
import game.objectsOnField.stationaryObjects.obstacle.BlackHole;
import game.objectsOnField.stationaryObjects.obstacle.Nebula;
import game.objectsOnField.stationaryObjects.obstacle.Obstacle;

import java.awt.*;
import java.util.Random;

public class Creator {
    Random r = new Random();
    final int min = 0;
    final int max = 1920;

    public Point randomPoint() {
        int x = (int) ((Math.random() * (max - min)) + min);
        int y = (int) ((Math.random() * (max - min)) + min);
        return new Point(x, y);
    }

    public Bonus randomBonus() {
        int bonusID = r.nextInt(3);
        return switch (bonusID) {
            case 0 -> new Heart(randomPoint());
            case 1 -> new Speed(randomPoint());
            case 2 -> new ResetRobot(randomPoint());
            default -> throw new IllegalStateException("Unexpected value: " + bonusID);
        };
    }

    public Obstacle randomObstacle() {
        int bonusID = r.nextInt(3);
        return switch (bonusID) {
            case 0 -> new Asteroid(randomPoint());
            case 1 -> new Nebula(randomPoint());
            case 2 -> new BlackHole(randomPoint());
            default -> throw new IllegalStateException("Unexpected value: " + bonusID);
        };
    }

    public Hunter hunter(Robot robot) {
        return new Hunter(randomPoint(), robot.getPosition());
    }

    public ScorePoint scorePoint() {
        return new ScorePoint(randomPoint());
    }
}
