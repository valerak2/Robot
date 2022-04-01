package gui.Storemanager;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Data {
    private final Map<String, WindowState> windowStateStore;
    private final Map<String, RobotCustomize> robotCustomizeStore;
    private final Map<String, RobotParameters> robotParametersStore;


    public void setStateWindows(String window, WindowState state) {
        windowStateStore.put(window, state);
    }

    public void setRobotCustomize(String robot, RobotCustomize state) {
        robotCustomizeStore.put(robot, state);
    }
    public void setRobotParameters(String robot, RobotParameters state) {
        robotParametersStore.put(robot, state);
    }

    public WindowState getStateWindows(String key) {
        if (windowStateStore.get(key) == null) {
            windowStateStore.put(key, new WindowState(500, 500, 10, 10, false));
        }
        return windowStateStore.get(key);
    }

    public RobotCustomize getCustomizeRobot(String key) {
        if (robotCustomizeStore.get(key) == null) {
            robotCustomizeStore.put(key, new RobotCustomize(Color.RED, "Oval"));
        }
        return robotCustomizeStore.get(key);
    }
    public RobotParameters getParametersRobot(String key) {
        if (robotParametersStore.get(key) == null) {
            robotParametersStore.put(key, new RobotParameters(100,100,0,150,100));
        }
        return robotParametersStore.get(key);
    }

    public Data() {
        //File file1 = new File("C://", "robotState");
        String file = System.getProperty("user.home") + File.separator + "robotState";
        Object[] object = readObject(file);
        if (object == null) {
            windowStateStore = new HashMap<>();
            robotCustomizeStore = new HashMap<>();
            robotParametersStore = new HashMap<>();
        } else {
            windowStateStore = (Map<String, WindowState>) object[0];
            robotCustomizeStore = (Map<String, RobotCustomize>) object[1];
            if (object[2] == null){ robotParametersStore =new HashMap<>();}
            else robotParametersStore = (Map<String, RobotParameters>) object[2];
        }
    }

    public void writeObject(String path) {
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(windowStateStore);
            objectOut.writeObject(robotCustomizeStore);
            objectOut.writeObject(robotParametersStore);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static Object[] readObject(String path) {
        try {
            FileInputStream fileOut = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fileOut);
            Map<String, WindowState> restoredWindow = (Map<String, WindowState>) ois.readObject();
            Map<String, RobotCustomize> restoredRobotCustomize = (Map<String, RobotCustomize>) ois.readObject();
            Map<String, RobotParameters> restoredRobotParameters = (Map<String, RobotParameters>) ois.readObject();

            Object[] result = new Object[]{restoredWindow, restoredRobotCustomize,restoredRobotParameters};
            ois.close();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
