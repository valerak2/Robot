package gui.Serialization;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Data {
    private final Map<String, WindowState> windowStateStore;


    public void setState(String window, WindowState state) {
        windowStateStore.put(window, state);
    }

    public WindowState getState(String key){
        if (windowStateStore.get(key) == null) {
            windowStateStore.put(key, new WindowState(500, 500, 10, 10, false));
        }
        return windowStateStore.get(key);
    }
    public Data(){
        //File file1 = new File("C://", "robotState");
        String file = System.getProperty("user.home") + File.separator + "robotState";
        Object object = readObject(file);
        if (object == null){
            windowStateStore = new HashMap<>();
        } else {
            windowStateStore = (Map<String, WindowState>) object;
        }
    }

    public void writeObject(String path) {
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(windowStateStore);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static Object readObject(String path) {
        try {
            FileInputStream fileOut = new FileInputStream(path);
            ObjectInputStream objectOut = new ObjectInputStream(fileOut);
            var result = objectOut.readObject();
            objectOut.close();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
