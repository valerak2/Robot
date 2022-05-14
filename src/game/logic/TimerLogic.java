package game.logic;

import game.objectsOnField.movingObjects.Shot;
import game.objectsOnField.movingObjects.enemies.Hunter;
import game.objectsOnField.movingObjects.robot.ModelUpdateEvent;
import game.objectsOnField.movingObjects.robot.Robot;
import game.objectsOnField.stationaryObjects.ScorePoint;
import game.objectsOnField.stationaryObjects.bonuses.Bonus;
import game.objectsOnField.stationaryObjects.obstacle.Obstacle;

import java.util.ArrayList;
import java.util.TimerTask;

public class TimerLogic {
    Creator creator = new Creator();
    public void timersForCreateObject(java.util.Timer timer,
                                       ArrayList<Bonus> bonuses,
                                       ArrayList<Hunter> hunters ,
                                       ArrayList<Obstacle> obstacles,
                                       Robot firstRobot,
                                       Robot secondRobot,
                                       ModelUpdateEvent modelUpdateEvent
                                       ) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                bonuses.add(creator.randomBonus());
            }
        }, 0, 1200);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                obstacles.add(creator.randomObstacle());
            }
        }, 0, 3000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Hunter hunter = creator.hunter(firstRobot);
                hunter.indexRobot = 0;
                hunters.add(hunter);
                modelUpdateEvent.addPropertyChangeListener(hunter);
            }
        }, 0, 2500);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Hunter hunter = creator.hunter(secondRobot);
                hunter.indexRobot = 1;
                hunters.add(hunter);
                modelUpdateEvent.addPropertyChangeListener(hunter);
            }
        }, 0, 1200);
    }
}
