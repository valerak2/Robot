package game.logic;

import game.logic.checker.Checker;
import game.logic.checker.CheckerLifeRobot;
import game.logic.timer.Creator;
import game.logic.timer.TimerCreator;
import game.logic.timer.TimerMoveObject;
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
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class GameVisualizer extends JPanel {


    public ModelUpdateEvent modelUpdateEvent = new ModelUpdateEvent();

    public Creator creator = new Creator();
    Painter painter = new Painter();
    public volatile Robot firstRobot = new Robot(new Point(0, 0), new Point(0, 0));
    public volatile Robot secondRobot = new Robot(new Point(0, 0), new Point(0, 0));
    public ScorePoint scorePoint = creator.scorePoint();
    public volatile Boolean gameOver = false;
    public volatile ArrayList<Bonus> bonuses = new ArrayList<>();
    public volatile ArrayList<Shot> shots = new ArrayList<>();
    public volatile ArrayList<Obstacle> obstacles = new ArrayList<>();
    public volatile ArrayList<MovingObjects> enemies = new ArrayList<>();
    public Graphics2D g2d;

    public GameVisualizer() {
        createRobot();
        ScheduledExecutorService painter = Executors.newSingleThreadScheduledExecutor();
        painter.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                onRedrawEvent();
            }
        }, 0, 3, TimeUnit.MILLISECONDS);

        TimerCreator timerCreator = new TimerCreator(this);
        TimerMoveObject timerMoveObject = new TimerMoveObject(this);
        Checker checker = new Checker(this);
        checker.run();
        timerCreator.run();
        timerMoveObject.run();
        checker.run();
        ScheduledExecutorService executor1 = Executors.newSingleThreadScheduledExecutor();
        CheckerLifeRobot checkerLifeRobot = new CheckerLifeRobot(this);
        executor1.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkerLifeRobot.run();
            }
        }, 0, 12, TimeUnit.MILLISECONDS);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch (e.getButton()) {
                    case 1:
                        firstRobot.setTarget(e.getPoint());
                        secondRobot.setTarget(e.getPoint());
                    case 3:
                        if (secondRobot.shot() != null) {
                            Shot shot = secondRobot.shot();
                            shot.setTarget(creator.randomPoint());
                            shots.add(shot);
                        }
                }
            }

        });
    }

    protected void onRedrawEvent() {
        EventQueue.invokeLater(this::repaint);
    }

    public void createRobot() {
        firstRobot = new Robot(new Point(0, 0), new Point(0, 0));
        secondRobot = new Robot(new Point(0, 0), new Point(0, 0));
        firstRobot.setLife(5);
        secondRobot.setLife(3);

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g2d = (Graphics2D) g;
        if (gameOver) {
            painter.printGameOver(g2d);
        } else {
            try {
                paintObjects(g2d);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void paintObjects(Graphics2D g2d) throws IOException {
        painter.paintBackground(g2d);
        scorePoint.draw(g2d);
        firstRobot.draw(g2d);
        secondRobot.draw(g2d);
        firstRobot.drawTarget(g2d);
        painter.drawArrayObjects(g2d, bonuses);
        painter.drawArrayObjects(g2d, shots);
        painter.drawArrayObjects(g2d, obstacles);
        painter.drawArrayObjects(g2d, enemies);
    }
}
