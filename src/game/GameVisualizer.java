package game;

import game.loadingLogic.LoadedEnemy;
import game.logic.controllers.createController.CreateController;
import game.logic.controllers.paintController.PaintControllers;
import game.logic.controllers.moveController.MoveController;
import game.logic.controllers.ñollisionController.CollisionControllers;
import game.logic.controllers.createController.Creator;
import game.objectsOnField.movingObjects.MovingObjects;
import game.objectsOnField.movingObjects.enemies.EnemyLogic;
import game.objectsOnField.movingObjects.robot.ModelUpdateEvent;
import game.objectsOnField.movingObjects.robot.Robot;
import game.objectsOnField.movingObjects.Shot;
import game.objectsOnField.stationaryObjects.ScorePoint;
import game.objectsOnField.stationaryObjects.bonuses.Bonus;
import game.objectsOnField.stationaryObjects.obstacle.Obstacle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


public class GameVisualizer extends JPanel {

    public ModelUpdateEvent modelUpdateEvent = new ModelUpdateEvent();

    public Creator creator = new Creator();
    public volatile Robot firstRobot;
    public volatile Robot secondRobot;

    public ScorePoint scorePoint = creator.scorePoint();
    public ArrayList<Bonus> bonuses = new ArrayList<>();
    public ArrayList<Shot> shots = new ArrayList<>();
    public ArrayList<Obstacle> obstacles = new ArrayList<>();
    public ArrayList<MovingObjects> enemies = new ArrayList<>();
    EnemyLogic otherEnemy;

    PaintControllers paintControllers;

    public GameVisualizer() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        LoadedEnemy loadedEnemy = new LoadedEnemy();
        otherEnemy = loadedEnemy.loadEnemy();
        System.out.println(loadedEnemy.loadEnemy());
        createRobot();
        createAllController();
        clickOnField();
    }
    private void createAllController() {
        paintControllers = new PaintControllers(this);
        new CreateController(this);
        new MoveController(this);
        new CollisionControllers(this);

    }

    private void clickOnField() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonEvent(e.getButton(), e.getPoint());
            }
        });
    }

    private void buttonEvent(int button, Point point) {
        switch (button) {
            case 1 -> setRobotsTarget(point);
            case 2, 3 -> setShot();
        }
    }

    private void setRobotsTarget(Point point) {
        firstRobot.setTarget(point);
        secondRobot.setTarget(point);
    }

    private void setShot() {
        if (secondRobot.shot() != null && !obstacles.isEmpty()) {
            Shot shot = secondRobot.shot();
            shot.setTarget(obstacles.get(obstacles.size() - 1).getPosition());

            shots.add(shot);
        }
    }

    private void createRobot() {
        firstRobot = new Robot(new Point(0, 0), new Point(0, 0));
        secondRobot = new Robot(new Point(0, 0), new Point(0, 0));
        firstRobot.setLife(5);
        secondRobot.setLife(3);

    }


    public void paint(Graphics g) {
        paintControllers.repaintGame.paint(g);
        otherEnemy.draw((Graphics2D) g);
    }
}
