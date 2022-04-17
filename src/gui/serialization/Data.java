package gui.serialization;

import gui.serialization.state.OptionState;
import gui.serialization.state.RobotCustomize;
import gui.serialization.state.RobotParameters;
import gui.serialization.state.WindowState;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Data {
    private final Map<String, Record> windowAndRobotState;

    public void setState(String objectName, Record state) {
        windowAndRobotState.put(objectName, state);
    }

    public Record getState(String key) {
        if (windowAndRobotState.get(key) == null) {
            switch (key) {
                case "logWindow":
                    windowAndRobotState.put("logWindow", new WindowState(500, 500, 50, 50, false, false));
                case "gameWindow":
                    windowAndRobotState.put("gameWindow", new WindowState(200, 600, 10, 10, false, false));
                case "coordinateWindow":
                    windowAndRobotState.put("coordinateWindow", new WindowState(150, 100, 0, 0, false, false));
                case "customize":
                    windowAndRobotState.put("customize", new RobotCustomize(Color.RED, "Oval"));
                case "parameters":
                    windowAndRobotState.put("parameters", new RobotParameters(100, 100, 0, 150, 100));
                case "options":
                    windowAndRobotState.put("options", new OptionState("eng", " "));

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
            FileWriter fileWriter = new FileWriter(path);
            for (String key : windowAndRobotState.keySet()) {
                fileWriter.write(key + ":" + windowAndRobotState.get(key) + "\n");
            }
            fileWriter.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Map<String, Record> readObject(String path) {
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);
            Map<String, Record> restoredData = new HashMap<>();
            String line;
            while ((line = reader.readLine()) != null) {
               fillRestoredData(line, restoredData);
            }
            reader.close();
            fileReader.close();
            return restoredData;
        } catch (Exception FileNotFoundException) {
            createFile(path);
            readObject(path);
        }
        return null;
    }
    private void fillRestoredData(String line, Map<String, Record> restoredData){
        String[] obj = line.split(":");
        String[] record = obj[1].split(",");
        ArrayList<String> prm = new ArrayList<>();
        for (String s : record) {
            String[] buf = s.split("=");
            prm.add(buf[1]);
        }
        switch (obj[0]) {
            case "logWindow" -> restoredData.put("logWindow", new WindowState(
                    Integer.parseInt(prm.get(0)),
                    Integer.parseInt(prm.get(1)),
                    Integer.parseInt(prm.get(2)),
                    Integer.parseInt(prm.get(3)),
                    Boolean.parseBoolean(prm.get(4)),
                    Boolean.parseBoolean(prm.get(5).replace("]", ""))));
            case "gameWindow" -> restoredData.put("gameWindow", new WindowState(
                    Integer.parseInt(prm.get(0)),
                    Integer.parseInt(prm.get(1)),
                    Integer.parseInt(prm.get(2)),
                    Integer.parseInt(prm.get(3)),
                    Boolean.parseBoolean(prm.get(4)),
                    Boolean.parseBoolean(prm.get(5).replace("]", ""))));
            case "coordinateWindow" -> restoredData.put("coordinateWindow", new WindowState(Integer.parseInt(prm.get(0)),
                    Integer.parseInt(prm.get(1)),
                    Integer.parseInt(prm.get(2)),
                    Integer.parseInt(prm.get(3)),
                    Boolean.parseBoolean(prm.get(4)),
                    Boolean.parseBoolean(prm.get(5).replace("]", ""))));
            case "customize" -> {
                String correctColor = prm.get(0).replace("java.awt.Color[", "");
                if (correctColor.equals("r")) correctColor = "255";
                restoredData.put("customize", new RobotCustomize(
                        new Color(Integer.parseInt(correctColor),
                                Integer.parseInt(prm.get(1)),
                                Integer.parseInt(prm.get(2).replace("]", ""))),
                        prm.get(3).replace("]", "")));
            }
            case "parameters" -> restoredData.put("parameters", new RobotParameters(
                    Double.parseDouble(prm.get(0)),
                    Double.parseDouble(prm.get(1)),
                    Double.parseDouble(prm.get(2)),
                    Integer.parseInt(prm.get(3)),
                    Integer.parseInt(prm.get(4).replace("]", ""))));
            case "options" -> restoredData.put("options", new OptionState(prm.get(0).replace("]", ""), ""));}


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
