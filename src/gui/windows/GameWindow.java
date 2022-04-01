package gui.windows;

import gui.Storemanager.Data;
import gui.Storemanager.RobotCustomize;
import gui.Storemanager.RobotParameters;
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
        setParametrsRobot(data);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_visualizer, BorderLayout.CENTER);
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        CloseDialogPanel.addJInternalListener(this);
    }
    private void setCustomizeRobot(Data data){
        RobotCustomize robotParameters = data.getCustomizeRobot("customize");
        CustomizeRobots customizeRobots = new CustomizeRobots();
        customizeRobots.setFigureRobots(robotParameters.figureRobots());
        customizeRobots.setColorRobots(robotParameters.colorRobots());
    }
    private void setParametrsRobot(Data data){
        RobotParameters robotParameters = data.getParametersRobot("parameters");
        m_visualizer.getP().Parameters1(
                robotParameters.robotPositionX(),
                robotParameters.robotPositionY(),
                robotParameters.robotDirection(),
                robotParameters.targetPositionX(),
                robotParameters.targetPositionY());
    }
}