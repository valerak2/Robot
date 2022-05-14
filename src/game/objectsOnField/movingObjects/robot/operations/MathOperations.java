package game.objectsOnField.movingObjects.robot.operations;

class MathOperations {
    static double distance(int x1, int y1, int x2, int y2) {
        int diffX = x1 - x2;
        int diffY = y1 - y2;
        return Math.sqrt(diffX * diffX + diffY * diffY);
    }

    static double angleTo(double fromX, double fromY, double toX, double toY) {
        double diffX = toX - fromX;
        double diffY = toY - fromY;

        return asNormalizedRadians(Math.atan2(diffY, diffX));
    }

    static double applyLimits(double value, double min, double max) {
        if (value < min)
            return min;
        return Math.min(value, max);
    }

    static double asNormalizedRadians(double angle) {
        while (angle < 0) angle += Math.PI;
        while (angle >= 2 * Math.PI) angle -= Math.PI;
        return angle;
    }
}