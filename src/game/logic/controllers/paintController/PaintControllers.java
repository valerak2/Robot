package game.logic.controllers.paintController;

import game.GameVisualizer;

public class PaintControllers {
    static volatile Boolean gameOver = false;
    public RepaintGame repaintGame;

    public PaintControllers(GameVisualizer gameVisualizer) {
        repaintGame = new RepaintGame(gameVisualizer);
        new GameOverIController(gameVisualizer);
    }

}
