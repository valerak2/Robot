package game.logic.loadEnemy;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class LoadedEnemy {
    String modulePath = "C:\\modules";
    public LoadedEnemyLogic loadEnemy(String name) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> clazz = myClassLoader.findClass(name);
        return ((LoadedEnemyLogic) clazz.getDeclaredConstructor().newInstance());
    }

    public void loadEnemyTest(ArrayList<LoadedEnemyLogic> l_enemies) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        MyClassLoader myClassLoader = new MyClassLoader();

        File dir = new File(modulePath);
        if (dir.exists()){
        String[] classes = dir.list();
        for (String module : classes) {
            String name = module.split(".class")[0];
            Class<?> clazz = myClassLoader.findClass(name);
            LoadedEnemyLogic enemy = ((LoadedEnemyLogic) clazz.getDeclaredConstructor().newInstance());
            LoadedEnemyLogic enemy2 = ((LoadedEnemyLogic) clazz.getDeclaredConstructor().newInstance());
            l_enemies.add(enemy);
            l_enemies.add(enemy2);
            System.out.println(l_enemies);
        }}
    }
}
