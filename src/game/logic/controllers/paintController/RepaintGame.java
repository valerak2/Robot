package game.logic.controllers.paintController;

import game.GameVisualizer;
import game.logic.controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RepaintGame extends JPanel implements Controller {
    private final GameVisualizer gameVisualizer;
    public Painter painter = new Painter();

    public RepaintGame(GameVisualizer gameVisualizer) {
        this.gameVisualizer = gameVisualizer;
        run();
    }

    public void run() {
        ScheduledExecutorService painter = Executors.newSingleThreadScheduledExecutor();
        painter.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                onRedrawEvent();
            }
        }, 0, 1, TimeUnit.MILLISECONDS);

    }

    protected void onRedrawEvent() {
        EventQueue.invokeLater(gameVisualizer::repaint);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if (PaintControllers.gameOver) {
            painter.printGameOver(g2d);
        } else {
            paintRobots(g2d);
            try {
                paintObjects(g2d);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Метод отрисовки объектов с использованием встроенных методов java.awt.Graphics2D
     */
    private void paintRobots(Graphics2D g2d){
        painter.paintBackground(g2d);
        gameVisualizer.scorePoint.draw(g2d);
        gameVisualizer.firstRobot.draw(g2d);
        gameVisualizer.secondRobot.draw(g2d);
        gameVisualizer.firstRobot.drawTarget(g2d);
    }

    /**
     * Метод отрисовки объектов с использованием картинок .jpg
     */
    private void paintObjects(Graphics2D g2d) throws IOException {
        painter.drawArrayObjects(g2d, gameVisualizer.bonuses);
        painter.drawArrayObjects(g2d, gameVisualizer.shots);
        painter.drawArrayObjects(g2d, gameVisualizer.obstacles);
        painter.drawArrayObjects(g2d, gameVisualizer.enemies);
    }

}
