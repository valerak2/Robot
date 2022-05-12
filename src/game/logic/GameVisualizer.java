package game.logic;

import game.objectsOnTheField.ObjectOnTheField;
import game.objectsOnTheField.movingObjects.enemies.Hunter;
import game.objectsOnTheField.movingObjects.robot.ModelUpdateEvent;
import game.objectsOnTheField.movingObjects.robot.Robot;
import game.objectsOnTheField.movingObjects.Shot;
import game.objectsOnTheField.stationaryObjects.TargetPoint;
import game.objectsOnTheField.stationaryObjects.bonuses.Bonus;
import game.objectsOnTheField.stationaryObjects.bonuses.Heart;
import game.objectsOnTheField.stationaryObjects.bonuses.ResetRobot;
import game.logic.operations.PaintOperations;
import game.objectsOnTheField.stationaryObjects.bonuses.Speed;
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


    PaintOperations paintOperations = new PaintOperations();
    ModelUpdateEvent modelUpdateEvent = new ModelUpdateEvent();
    Graphics2D g2d;
    Robot firstRobot = new Robot(new Point(0, 0), new Point(0, 0));
    Robot secondRobot = new Robot(new Point(0, 0), new Point(0, 0));
    Map<String, ObjectOnTheField> objects;
    final java.util.Timer timer = new Timer("events generator", true);
    ArrayList<Bonus> bonuses = new ArrayList<>();
    ArrayList<Shot> shots = new ArrayList<>();

    public GameVisualizer() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                onRedrawEvent();
            }
        }, 0, 50);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                moveRobot1(firstRobot);
            }
        }, 0, 12);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                moveRobot1(secondRobot);
            }
        }, 0, 4);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (Shot shot : shots) {
                    shot.move();
                }
                ;
            }
        }, 0, 10);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                bonuses.add(randomBonus());
            }
        }, 0, 600);
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
                        shots.add(secondRobot.shot());
                }
                //System.out.println(e.getPoint());
                //repaint();
            }

        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        setDoubleBuffered(true);
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

    final int min = 0;
    final int max = 1920;

    public Point randomPoint() {
        int x = (int) ((Math.random() * (max - min)) + min);
        int y = (int) ((Math.random() * (max - min)) + min);
        return new Point(x, y);
    }

    public Bonus randomBonus() {
        Random random = new Random();
        int bonusID = random.nextInt(3);
        return switch (bonusID) {
            case 0 -> new Heart(randomPoint());
            case 1 -> new Speed(randomPoint());
            case 2 -> new ResetRobot(randomPoint());
            default -> throw new IllegalStateException("Unexpected value: " + bonusID);
        };
    }


    protected void moveRobot1(Robot robot) {
        robot.move();
        modelUpdateEvent.onModelUpdateEvent(firstRobot, secondRobot);

    }


    TargetPoint targetPoint = new TargetPoint(new Point(100, 100));

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        paintBackground(g2d);
        g.fillRect(0, 0, 1920, 1080);
        paintOperations.drawTarget1(g2d, firstRobot.getTarget());
        targetPoint.draw(g2d);
        //g2d.rotate(20);
        firstRobot.draw(g2d);
        secondRobot.draw(g2d);
        /*paintOperations.drawRobot1(g2d, firstRobot.getPosition());
        paintOperations.drawRobot1(g2d, secondRobot.getPosition());*/
        for (Bonus bonus : bonuses) {
            bonus.draw(g2d);
        }
        for (Shot shot : shots) {
            shot.draw(g2d);
        }
        targetPoint.checkCollision(g2d, firstRobot);
        checkCollisions(g2d);


    }


    private void paintRobot(Graphics g) {

    }

    public void checkCollisions(Graphics2D g) {
        ArrayList<ObjectOnTheField> crashed = new ArrayList<>();
        for (Bonus bonus : bonuses) {
            if (bonus.checkCollision(g, firstRobot)) {
                bonus.effect(firstRobot);
                crashed.add(bonus);
            }
            if (bonus.checkCollision(g, secondRobot)) {
                bonus.effect(secondRobot);
                crashed.add(bonus);
            }
        }
        for (Object bonus : crashed){
            bonuses.remove(bonus);
        }


    }

    private void paintBackground(Graphics g) {
        g.setColor(new Color(95, 38, 114));
        g.fillRect(0, 0, 1920, 1080);

    }
}
