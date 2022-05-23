package game.logic.paintController;

import game.GameVisualizer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PaintController extends JPanel {
    final GameVisualizer gameVisualizer;
    public Painter painter = new Painter();
    volatile Boolean gameOver = false;

    public PaintController(GameVisualizer gameVisualizer) {
        this.gameVisualizer = gameVisualizer;
        ScheduledExecutorService painter = Executors.newSingleThreadScheduledExecutor();
        painter.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                onRedrawEvent();
            }
        }, 0, 3, TimeUnit.MILLISECONDS);
        ScheduledExecutorService checker = Executors.newSingleThreadScheduledExecutor();
        checker.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkGameOver();
            }
        }, 0, 3, TimeUnit.MILLISECONDS);
    }
    protected void onRedrawEvent() {
        EventQueue.invokeLater(gameVisualizer::repaint);
    }
    private void checkGameOver() {
        if (gameVisualizer.firstRobot.getLife() <= 0 & gameVisualizer.secondRobot.getLife() <= 0) {
            gameOver = true;
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        gameVisualizer.g2d = (Graphics2D) g;
        if (gameOver) {
            painter.printGameOver(gameVisualizer.g2d);
        } else {
            try {
                paintObjects(gameVisualizer.g2d);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void paintObjects(Graphics2D g2d) throws IOException {
        painter.paintBackground(g2d);
        gameVisualizer.scorePoint.draw(g2d);
        gameVisualizer.firstRobot.draw(g2d);
        gameVisualizer.secondRobot.draw(g2d);
        gameVisualizer.firstRobot.drawTarget(g2d);
        painter.drawArrayObjects(g2d, gameVisualizer.bonuses);
        painter.drawArrayObjects(g2d, gameVisualizer.shots);
        painter.drawArrayObjects(g2d, gameVisualizer.obstacles);
        painter.drawArrayObjects(g2d, gameVisualizer.enemies);
    }
}
