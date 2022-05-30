package game.logic.controllers.ñollisionController;

import game.GameVisualizer;

public class CollisionControllers {

    public CollisionControllers(GameVisualizer gameVisualizer) {
        CollisionsWithRobot collisionsWithRobot = new CollisionsWithRobot(gameVisualizer);
        collisionsWithRobot.run();

        CheckerLifeRobot checkerLifeRobot = new CheckerLifeRobot(gameVisualizer);
        checkerLifeRobot.run();

        CollisionsWithShots collisionsWithShots = new CollisionsWithShots(gameVisualizer);
        collisionsWithShots.run();
    }
}
