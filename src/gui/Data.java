package gui;

import logic.CustomizeRobots;

import java.lang.reflect.Parameter;

class Data {
    private Parameter parametersOfRobot;
    private CustomizeRobots customizeRobots;
    private MainApplicationFrame frame;

    Data(MainApplicationFrame frame1, Parameter parametersOfRobot1, CustomizeRobots customizeRobots1) {
        frame = frame1;
        parametersOfRobot = parametersOfRobot1;
        customizeRobots = customizeRobots1;
    }

    public CustomizeRobots getCustomizeRobots() {
        return customizeRobots;
    }

    public Parameter getParametersOfRobot() {
        return parametersOfRobot;
    }

    public MainApplicationFrame getFrame() {
        return frame;
    }

    public void setCustomizeRobots(CustomizeRobots customizeRobots) {
        this.customizeRobots = customizeRobots;
    }

    public void setParametersOfRobot(Parameter parametersOfRobot) {
        this.parametersOfRobot = parametersOfRobot;
    }

    public void setData() {

    }
}
