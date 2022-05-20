package game.logic.ñollisionController;

import game.GameVisualizer;

public class CollisionController {

    public CollisionController(GameVisualizer gameVisualizer) {
        CollisionsWithRobot collisionsWithRobot = new CollisionsWithRobot(gameVisualizer);
        collisionsWithRobot.run();

        CheckerLifeRobot checkerLifeRobot = new CheckerLifeRobot(gameVisualizer);
        checkerLifeRobot.run();

        CollisionsWithShots collisionsWithShots = new CollisionsWithShots(gameVisualizer);
        collisionsWithShots.run();
    }
}
