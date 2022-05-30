package serialization;


import serialization.state.*;


import java.io.*;
import java.util.*;


/**
 * ����� � ����������� ������������ � ��������������
 */
public class Data {
    /**
     * ������� ��� �������� ���������
     * ��������� (������������� ���������: �����-������ ���������)
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
     * ����������� ������, ��� �������� ��������� ������, ���� �������������� ��������� ����������
     */
    public Data(String path) {
        Map<String, Record> object = readObject(path);
        data = Objects.requireNonNullElseGet(object, HashMap::new);
    }

    /**
     * ������ �������� � �����
     */
    public void writeObject(String path) {
        new WriteData(path, data);
    }

    /**
     * ������ �������� � �����
     */
    private Map<String, Record> readObject(String path) {
        ReadData readData = new ReadData(path);
        System.out.println(readData.getData());
        return readData.getData();
    }

}
