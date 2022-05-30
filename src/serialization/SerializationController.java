package serialization;

import gui.windows.CreatorWindows;
import gui.windows.GameWindow;
import gui.windows.LogWindow;
import gui.windows.StatisticsWindow;

import java.io.File;

public class SerializationController {
    private static SerializationController INSTANCE;
    public String path = System.getProperty("user.home") + File.separator + "window_and_robot_states";
    Data data;
    public Data getData() {
        return data;
    }

    public static SerializationController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SerializationController();
        }
        return INSTANCE;
    }
    public SerializationController() {
        data = new Data(path);
    }
    public void collectData(){
        CollectorData collectorData = new CollectorData(data);
        collectorData.options();
        collectorData.robots();
        data.writeObject(path);
    }
    public void collectParametersWindow(CollectorData collectorData, GameWindow gameWindow, LogWindow logWindow, StatisticsWindow statisticsWindow){
        collectorData.windows(gameWindow,logWindow,statisticsWindow);
    }

}
