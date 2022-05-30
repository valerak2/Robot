package serialization;


import serialization.state.*;


import java.io.*;
import java.util.*;


/**
 * Класс с реализацией сериализация и десериализации
 */
public class Data {
    /**
     * Словарь для хранения различных
     * состояний (идентификатор состояния: класс-запись состояния)
     */
    private final Map<String, Record> data;

    public void setState(String objectName, Record state) {
        data.put(objectName, state);
    }

    public Record getState(String key) {
        if (data.get(key) == null) {
            data.put(key, DefaultsState.valueOf(key).get());
        }
        return data.get(key);
    }

    /**
     * Конструктор класса, при создании экземляра класса, идет десериализация состояний приложения
     */
    public Data(String path) {
        Map<String, Record> object = readObject(path);
        data = Objects.requireNonNullElseGet(object, HashMap::new);
    }

    /**
     * Чтение объектов с файла
     */
    public void writeObject(String path) {
        new WriteData(path, data);
    }

    /**
     * Чтение объектов с файла
     */
    private Map<String, Record> readObject(String path) {
        ReadData readData = new ReadData(path);
        System.out.println(readData.getData());
        return readData.getData();
    }

}
