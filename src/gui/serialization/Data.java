package gui.serialization;

import gui.serialization.state.RobotCustomize;
import gui.serialization.state.RobotParameters;
import gui.serialization.state.WindowState;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Data {
    private final Map<String, Record> windowAndRobotState;

    public void setState(String objectName, Record state) {
        windowAndRobotState.put(objectName, state);
    }

    public Record getState(String key) {
        if (windowAndRobotState.get(key) == null) {
            switch (key) {
                case "logWindow":
                    windowAndRobotState.put("logWindow", new WindowState(500, 500, 50, 50, false));
                case "gameWindow":
                    windowAndRobotState.put("gameWindow", new WindowState(200, 600, 10, 10, false));
                case "coordinateWindow":
                    windowAndRobotState.put("coordinateWindow", new WindowState(150, 100, 0, 0, false));
                case "customize":
                    windowAndRobotState.put("customize", new RobotCustomize(Color.RED, "Oval"));
                case "parameters":
                    windowAndRobotState.put("parameters", new RobotParameters(100, 100, 0, 150, 100));

            }
        }
        return windowAndRobotState.get(key);
    }

    public Data() {
        String file = System.getProperty("user.home") + File.separator + "window_and_robot_states";
        Map<String, Record> object = readObject(file);
        windowAndRobotState = Objects.requireNonNullElseGet(object, HashMap::new);
    }

    public void writeObject(String path) {
        try {
            FileOutputStream fileData = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileData);
            objectOut.writeObject(windowAndRobotState);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public Map<String, Record> readObject(String path) {
        try {
            FileInputStream fileData = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fileData);
            Map<String, Record> restoredData = (Map<String, Record>) ois.readObject();
            ois.close();
            return restoredData;
        } catch (Exception FileNotFoundException) {
            createFile(path);
            readObject(path);
        }
        return null;
    }

    public void createFile(String path) {
        try {
            File file = new File(path);
            if (file.createNewFile())
                System.out.println("File created");
            writeObject(path);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
