package game.loadingLogic;

import game.objectsOnField.movingObjects.enemies.EnemyLogic;

import java.lang.reflect.InvocationTargetException;

public class LoadedEnemy {
    public EnemyLogic loadEnemy() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> clazz = myClassLoader.findClass("Sun");
        return ((EnemyLogic) clazz.getDeclaredConstructor().newInstance());
    }
}
