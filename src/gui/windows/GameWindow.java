package gui.windows;


import gui.localization.Language;
import serialization.Data;
import serialization.state.RobotCustomize;
import gui.menu.options.CloseDialogPanel;
import game.objectsOnField.movingObjects.robot.CustomizeRobots;


import game.GameVisualizer;

import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;
import java.awt.*;

import javax.swing.*;

public class GameWindow extends JInternalFrame {
    GameVisualizer m_visualizer;

    public GameVisualizer getM_visualizer() {
        return m_visualizer;
    }

    public GameWindow() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        super(ResourceBundle.getBundle("lang", Language.language).getString("GameWindow.name"), true, true, true, true);
        m_visualizer = new GameVisualizer();
        //setCustomizeRobot(data);
        //setParametersRobot(data);

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

    // TODO: 19.05.2022 переделать сериализацию роботов
    private void setParametersRobot(Data data) {
       // RobotParameters robotParameters = (RobotParameters) data.getState("parameters");
        //m_visualizer.setRobotParameters(robotParameters);
    }
}