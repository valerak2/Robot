package gui.windows;

import log.Logger;
import serialization.CollectorData;
import serialization.Data;
import serialization.SerializationController;
import serialization.state.WindowState;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class CreatorWindows {
    Logger logger = Logger.getInstance();
    Data data = SerializationController.getInstance().getData();
    GameWindow gameWindow = new GameWindow();
    LogWindow logWindow = new LogWindow();
    StatisticsWindow statisticsWindow = StatisticsWindow.getInstance();
    public CreatorWindows(JDesktopPane desktopPane) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        WindowState gameWindowParams = (WindowState) data.getState("gameWindow");
        desktopPane.add(createWindow(gameWindowParams,gameWindow));
        gameWindow.setVisible(true);
        System.out.println(gameWindow);

        WindowState logWindowParams = (WindowState) data.getState("logWindow");
        desktopPane.add(createWindow(logWindowParams, logWindow));
        logWindow.setVisible(true);
        System.out.println(logWindow);


        WindowState coordinateWindowParams = (WindowState) data.getState("statisticsWindow");
        desktopPane.add(createWindow(coordinateWindowParams, statisticsWindow));
        statisticsWindow.setVisible(true);

    }
    private <Window extends JInternalFrame>void generateWindow(JDesktopPane desktop, Window window){

    }
    private <Window extends JInternalFrame> Window createWindow(WindowState windowParams, Window window) {
        window.setLocation(windowParams.positionX(), windowParams.positionY());
        window.setSize(windowParams.width(), windowParams.height());
        try {
            window.setIcon(true);
            window.setClosed(false);
        } catch (Exception ignored) {
        }
        logger.info(window.getTitle() + "was created");
        return window;
    }
    public void collectData(CollectorData collectorData){
    }
}
