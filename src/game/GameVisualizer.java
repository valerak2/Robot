package game;

import game.logic.createController.CreateController;
import game.logic.paintController.PaintController;
import game.logic.moveController.MoveController;
import game.logic.ñollisionController.CollisionController;
import game.logic.createController.Creator;
import game.objectsOnField.movingObjects.MovingObjects;
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
import java.util.*;


public class GameVisualizer extends JPanel {


    public ModelUpdateEvent modelUpdateEvent = new ModelUpdateEvent();

    public Creator creator = new Creator();
    public volatile Robot firstRobot;
    public volatile Robot secondRobot;


    public volatile Boolean gameOver = false;
    public ScorePoint scorePoint = creator.scorePoint();
    public volatile ArrayList<Bonus> bonuses = new ArrayList<>();
    public volatile ArrayList<Shot> shots = new ArrayList<>();
    public volatile ArrayList<Obstacle> obstacles = new ArrayList<>();
    public volatile ArrayList<MovingObjects> enemies = new ArrayList<>();

    public Graphics2D g2d;
    PaintController paintController;

    public GameVisualizer() {
        createRobot();
        paintController = new PaintController(this);
        new CreateController(this);
        new MoveController(this);
        new CollisionController(this);
        clickOnField();
    }

    private void clickOnField() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch (e.getButton()) {
                    case 1:
                        firstRobot.setTarget(e.getPoint());
                        secondRobot.setTarget(e.getPoint());
                    case 3:
                        if (secondRobot.shot() != null && !obstacles.isEmpty()) {
                            Shot shot = secondRobot.shot();
                            shot.setTarget(obstacles.get(0).getPosition());
                            shots.add(shot);
                        }
                }
            }

        });
    }

    public void createRobot() {
        firstRobot = new Robot(new Point(0, 0), new Point(0, 0));
        secondRobot = new Robot(new Point(0, 0), new Point(0, 0));
        firstRobot.setLife(0);
        secondRobot.setLife(0);

    }

    @Override
    public void paint(Graphics g) {
        paintController.paint(g);
    }
}
