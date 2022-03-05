package logic;

import gui.CustomizeRobots;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.TimerTask;


import static logic.MathOperations.*;
import static logic.PaintOperations.*;
import static logic.PaintOperations.drawFigure;

public class GameVisualizer extends JPanel {
    Parameters p = new Parameters();

    public GameVisualizer() {

        p.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                onRedrawEvent();
            }
        }, 0, 50);
        p.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                onModelUpdateEvent();
            }
        }, 0, 10);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                p.setTargetPosition(e.getPoint());
                repaint();
            }
        });
        setDoubleBuffered(true);
    }

    protected void onRedrawEvent() {
        EventQueue.invokeLater(this::repaint);
    }

    protected void onModelUpdateEvent() {
        double distance = distance(p.targetPositionX,
                p.targetPositionY,
                p.robotPositionX,
                p.robotPositionY);
        if (distance < 0.5) return;
        double angleToTarget = angleTo(p.robotPositionX,
                p.robotPositionY,
                p.targetPositionX,
                p.targetPositionY);
        double angularVelocity = 0;
        if (angleToTarget > p.robotDirection) {
            angularVelocity = Parameters.maxAngularVelocity;
        }
        if (angleToTarget < p.robotDirection) {
            angularVelocity = -Parameters.maxAngularVelocity;
        }

        moveRobot(angularVelocity, 10);
    }

    private void moveRobot(double angularVelocity, double duration) {
        double velocity = applyLimits(Parameters.maxVelocity, 0, Parameters.maxVelocity);
        angularVelocity = applyLimits(angularVelocity, -Parameters.maxAngularVelocity, Parameters.maxAngularVelocity);
        double newPositionX = p.robotPositionX +
                (velocity / angularVelocity) *
                        (Math.sin(p.robotDirection + angularVelocity * duration) -
                                Math.sin(p.robotDirection));
        if (!Double.isFinite(newPositionX))
            newPositionX = p.robotPositionX + velocity * duration * Math.cos(p.robotDirection);

        double newPositionY = p.robotPositionY -
                (velocity / angularVelocity) *
                        (Math.cos(p.robotDirection + angularVelocity * duration) -
                                Math.cos(p.robotDirection));
        if (!Double.isFinite(newPositionY))
            newPositionY = p.robotPositionY + velocity * duration * Math.sin(p.robotDirection);

        p.robotPositionX = newPositionX;
        p.robotPositionY = newPositionY;
        p.robotDirection = asNormalizedRadians(p.robotDirection + angularVelocity * duration);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        drawRobot(g2d);
        drawTarget(g2d, p.targetPositionX, p.targetPositionY);
    }

    private void drawRobot(Graphics2D g) {
        int robotCenterX = round(p.robotPositionX);
        int robotCenterY = round(p.robotPositionY);
        String figure = CustomizeRobots.getFigureRobots();
        AffineTransform t = AffineTransform.getRotateInstance(p.robotDirection, robotCenterX, robotCenterY);
        g.setTransform(t);
        g.setColor(CustomizeRobots.getColorRobots());
        fillFigure(g, figure, robotCenterX, robotCenterY, 30, 10);
        g.setColor(Color.BLACK);
        drawFigure(g, figure, robotCenterX, robotCenterY, 30, 10);
        g.setColor(Color.WHITE);
        fillFigure(g, figure, robotCenterX + 10, robotCenterY, 5, 5);
        g.setColor(Color.BLACK);
        drawFigure(g, figure, robotCenterX + 10, robotCenterY, 5, 5);
    }

}
