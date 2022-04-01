package logic;

import logic.operations.MoveOperations;
import logic.operations.PaintOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TimerTask;


public class GameVisualizer extends JPanel {

    private final Parameters p = new Parameters();

    public Parameters getP() {
        return p;
    }

    MoveOperations moveOperations = new MoveOperations(p);
    PaintOperations paintOperations = new PaintOperations();

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
        if (!moveOperations.checkDistant()) return;
        moveOperations.robotDirection();
        moveOperations.moveOnX();
        moveOperations.moveOnY();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        paintOperations.drawRobot(g2d, p.getRobotPositionX(), p.getRobotPositionY(), p.getRobotDirection());
        paintOperations.drawTarget(g2d, p.getTargetPositionX(), p.getTargetPositionY());
    }
}
