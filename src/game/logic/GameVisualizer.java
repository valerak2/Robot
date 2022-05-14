package game.logic;

import game.objectsOnField.ObjectOnTheField;
import game.objectsOnField.movingObjects.enemies.Hunter;
import game.objectsOnField.movingObjects.robot.CrashedRobot;
import game.objectsOnField.movingObjects.robot.ModelUpdateEvent;
import game.objectsOnField.movingObjects.robot.Robot;
import game.objectsOnField.movingObjects.Shot;
import game.objectsOnField.stationaryObjects.ScorePoint;
import game.objectsOnField.stationaryObjects.bonuses.Bonus;
import game.objectsOnField.stationaryObjects.obstacle.Obstacle;
import gui.serialization.state.RobotParameters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.Timer;


public class GameVisualizer extends JPanel {


    ModelUpdateEvent modelUpdateEvent = new ModelUpdateEvent();
    final java.util.Timer timer = new Timer("events generator", true);

    //Graphics2D g2d;
    Creator creator = new Creator();
    Painter painter = new Painter();
    Robot firstRobot = new Robot(new Point(0, 0), new Point(0, 0));
    Robot secondRobot = new Robot(new Point(0, 0), new Point(0, 0));
    ScorePoint scorePoint = creator.scorePoint();
    Boolean gameOver = false;
    ArrayList<Bonus> bonuses = new ArrayList<>();
    ArrayList<Shot> shots = new ArrayList<>();
    ArrayList<Hunter> hunters = new ArrayList<>();
    ArrayList<Obstacle> obstacles = new ArrayList<>();
    //TimerLogic timerLogic = new TimerLogic();
    Checker checker = new Checker(this);

    public GameVisualizer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                onRedrawEvent();
            }
        }, 0, 5);
        timersForMove();
        /*timerLogic.timersForCreateObject(timer,
                bonuses,
                hunters,
                obstacles,
                firstRobot,
                secondRobot,
                modelUpdateEvent
        );*/
        timersForCreateObject();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getButton());
                switch (e.getButton()) {
                    case 1:
                        firstRobot.setTarget(e.getPoint());//System.out.println('1');
                        secondRobot.setTarget(e.getPoint());
                        //case 2: shots.add(secondRobot.shot()); //System.out.println('2');
                    case 3:
                        if (secondRobot.shot() != null) {
                            shots.add(secondRobot.shot());
                        }
                }
            }

        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                System.out.println(e.getKeyLocation());
            }
        });
        setDoubleBuffered(true);
    }

    private void timersForMove() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (Shot shot : shots) {
                    shot.move();
                }

            }
        }, 0, 10);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                moveRobots(firstRobot);
            }
        }, 0, 12);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                moveRobots(secondRobot);
            }
        }, 0, 4);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (Hunter hunter : hunters) {
                    hunter.move();
                }

            }
        }, 0, 30);

    }

    private void timersForCreateObject() {
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

    protected void onRedrawEvent() {
        EventQueue.invokeLater(this::repaint);
    }

    public void createsRobots(RobotParameters robotParameters) {
        firstRobot = new Robot(new Point(robotParameters.robotPositionX(), robotParameters.robotPositionY()), new Point(0, 0));
        secondRobot = new Robot(new Point(robotParameters.robotPositionX() + 200, robotParameters.robotPositionY() + 200), new Point(0, 0));
        firstRobot.setLife(5);
        secondRobot.setLife(3);
    }

    protected void moveRobots(Robot robot) {
        robot.move();
        modelUpdateEvent.onModelUpdateEvent(firstRobot, secondRobot);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if (gameOver) {
            painter.printGameOver(g2d);
        } else paintObjects(g2d);


    }


    private void paintObjects(Graphics2D g2d) {
        painter.paintBackground(g2d);
        scorePoint.draw(g2d);
        firstRobot.draw(g2d);
        secondRobot.draw(g2d);
        firstRobot.drawTarget(g2d);
        painter.drawArrayObjects(g2d, bonuses);
        painter.drawArrayObjects(g2d, shots);
        painter.drawArrayObjects(g2d, obstacles);
        painter.drawArrayObjects(g2d, hunters);
        checkCollisions(g2d);
    }


    public void checkCollisions(Graphics2D g) {
        checker.collisionsTarget(g);
        checker.collisionsObjects(g, bonuses);
        checker.collisionsObjects(g, obstacles);
        checker.collisionsObjects(g, hunters);
    }

}
