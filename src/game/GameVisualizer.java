package game;

import game.logic.loadEnemy.LoadedEnemy;
import game.logic.controllers.createController.CreateController;
import game.logic.controllers.paintController.PaintControllers;
import game.logic.controllers.moveController.MoveController;
import game.logic.controllers.ñollisionController.CollisionControllers;
import game.logic.controllers.createController.Creator;
import game.objectsOnField.movingObjects.MovingObjects;
import game.logic.loadEnemy.LoadedEnemyLogic;
import game.objectsOnField.movingObjects.robot.ModelUpdateEvent;
import game.objectsOnField.movingObjects.robot.Robot;
import game.objectsOnField.movingObjects.Shot;
import game.objectsOnField.stationaryObjects.ScorePoint;
import game.objectsOnField.stationaryObjects.bonuses.Bonus;
import game.objectsOnField.stationaryObjects.obstacle.Obstacle;
import log.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


public class GameVisualizer extends JPanel {

    public ModelUpdateEvent modelUpdateEvent = new ModelUpdateEvent();
    Logger logger = Logger.getInstance();

    public Creator creator = new Creator();
    public volatile Robot firstRobot;
    public volatile Robot secondRobot;

    public ScorePoint scorePoint = creator.scorePoint();
    public ArrayList<Bonus> bonuses = new ArrayList<>();
    public ArrayList<Shot> shots = new ArrayList<>();
    public ArrayList<Obstacle> obstacles = new ArrayList<>();
    public ArrayList<MovingObjects> enemies = new ArrayList<>();
    public ArrayList<LoadedEnemyLogic> l_enemies = new ArrayList<>();

    PaintControllers paintControllers;

    public GameVisualizer() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        createRobots();
        loadEnemies();
        createAllController();
        clickOnField();

    }
    private void loadEnemies() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        LoadedEnemy loadedEnemy = new LoadedEnemy();
        loadedEnemy.loadEnemyTest(l_enemies);
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

    private void createRobots() {
        firstRobot = new Robot(new Point(0, 0), new Point(0, 0));
        secondRobot = new Robot(new Point(0, 0), new Point(0, 0));
        firstRobot.setLife(3);
        secondRobot.setLife(5);
        logger.gameInfo("Èãðà íà÷àëàñü");

    }


    public void paint(Graphics g) {
        paintControllers.repaintGame.paint(g);
    }
}
