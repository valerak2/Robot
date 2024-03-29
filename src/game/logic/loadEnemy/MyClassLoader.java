package game.logic.loadEnemy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> findClass(String name) {
        byte[] b = customLoadClassFromFile(name);

        return defineClass(name, b, 0, b.length);
    }

    private byte[] customLoadClassFromFile(String filename)  {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(
                filename.replace('.', File.separatorChar) + ".class");
        byte[] buffer;
        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        int nextValue;
        try {
            while ((nextValue = inStream.read()) != -1) {
                bStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = bStream.toByteArray();
        return buffer;
    }
}