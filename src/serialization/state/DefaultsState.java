package serialization.state;

import java.awt.*;

public enum DefaultsState {
    gameWindow("gameWindow") {
        Record value() {
            return new WindowState(
                    200, 600, 10, 10, false);
        }
    },
    statisticsWindow("statisticsWindow") {
        Record value() {
            return new WindowState(
                    150, 100, 90, 90, false);
        }
    },
    logWindow("logWindow") {
        Record value() {
            return new WindowState(
                    500, 500, 50, 50, false);
        }
    },
    options("options") {
        @Override
        Record value() {
            return new OptionState("eng", " ");
        }
    },
    customize("customize") {
        @Override
        Record value() {
            return new RobotCustomize(Color.RED, "Oval");
        }
    },
    parametersRobots("parametersRobots") {
        @Override
        Record value() {
            return new RobotParameters(new Point(100,100), new Point(100,100));
        }
    };
    DefaultsState(String nameState) {
    }

    abstract Record value();

    public Record get() {
        return value();
    }

    ;
}

