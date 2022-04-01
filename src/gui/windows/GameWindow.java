package gui.windows;


import gui.serialization.Data;
import gui.serialization.state.RobotCustomize;
import gui.serialization.state.RobotParameters;
import gui.menu.CloseDialogPanel;
import logic.CustomizeRobots;

import logic.GameVisualizer;

import java.awt.*;

import javax.swing.*;

public class GameWindow extends JInternalFrame {
    GameVisualizer m_visualizer;

    public GameVisualizer getM_visualizer() {
        return m_visualizer;
    }

    public GameWindow(Data data) {
        super("Игровое поле", true, true, true, true);
        m_visualizer = new GameVisualizer();
        setCustomizeRobot(data);
        setParametersRobot(data);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_visualizer, BorderLayout.CENTER);
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        CloseDialogPanel.addJInternalListener(this);
    }

    private void setCustomizeRobot(Data data) {
        RobotCustomize robotCustomize = (RobotCustomize) data.getState("customize");
        CustomizeRobots customizeRobots = new CustomizeRobots();
        customizeRobots.setFigureRobots(robotCustomize.figureRobots());
        customizeRobots.setColorRobots(robotCustomize.colorRobots());
    }

    private void setParametersRobot(Data data) {
        RobotParameters robotParameters = (RobotParameters) data.getState("parameters");
        m_visualizer.getP().builderParameters(
                robotParameters.robotPositionX(),
                robotParameters.robotPositionY(),
                robotParameters.robotDirection(),
                robotParameters.targetPositionX(),
                robotParameters.targetPositionY());

    }
}