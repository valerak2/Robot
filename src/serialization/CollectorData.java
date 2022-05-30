package serialization;

import game.objectsOnField.movingObjects.robot.CustomizeRobots;
import gui.localization.Language;
import gui.windows.GameWindow;
import gui.windows.LogWindow;
import gui.windows.StatisticsWindow;
import serialization.state.OptionState;
import serialization.state.RobotCustomize;
import serialization.state.WindowState;

public class CollectorData {
    Data data;

    public CollectorData(Data data) {
        this.data = data;
    }

    public void options(){
        data.setState("options", new OptionState(Language.getLanguageString(), " "));
    }
    public void robots(){
        data.setState("customize", new RobotCustomize(
                CustomizeRobots.getColorRobots(),
                CustomizeRobots.getFigureRobots()));
    }
    public void windows(GameWindow gameWindow, LogWindow logWindow, StatisticsWindow statisticsWindow){
         data.setState("logWindow", new WindowState(
                logWindow.getWidth(),
                logWindow.getHeight(),
                logWindow.getX(),
                logWindow.getY(),
                logWindow.isIcon()));
        data.setState("statisticsWindow", new WindowState(
                statisticsWindow.getWidth(),
                statisticsWindow.getHeight(),
                statisticsWindow.getX(),
                statisticsWindow.getY(),
                statisticsWindow.isIcon()));
        data.setState("gameWindow", new WindowState(
                gameWindow.getWidth(),
                gameWindow.getHeight(),
                gameWindow.getX(),
                gameWindow.getY(),
                gameWindow.isIcon()));
    }
}
