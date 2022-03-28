package gui;

import logic.CustomizeRobots;

import java.io.*;
import java.lang.reflect.Parameter;

public class Serialization implements Serializable {
    private File file;

    public void writeObject1(MainApplicationFrame frame) {
        File file = new File("data.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(frame);
            oos.close();//oos - это внешний поток.Если мы закрываем внешний то и внутренний тоже.
            } catch (Exception e) {
            e.printStackTrace();
        }finally {

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    public void readObject() throws IOException {
        InputStream is = new FileInputStream(file);
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(is));
            try
            {   MainApplicationFrame restoredFrame =(MainApplicationFrame)ois.readObject();
                Parameter restoredParameters = (Parameter)ois.readObject();
                CustomizeRobots restoredCustomizeRobots =(CustomizeRobots)ois.readObject();
                new Data(restoredFrame,restoredParameters,restoredCustomizeRobots);
            }
            catch (ClassNotFoundException ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                ois.close();
            }
        }
        finally
        {
            is.close();
        }
        catch (IOException ex)
    { ex.printStackTrace(); }}


    static class Person
            implements Serializable
    {
        private int m_iAge;
        private String m_strName;

        private Person()
        {}

        private Person(int iAge, String strName)
        {
            m_iAge = iAge;
            m_strName = strName;
        }

        public int getAge()
        {
            return m_iAge;
        }

        public String getName()
        {
            return m_strName;
        }




    public static void test8()
    {
        Person person = new Person(20, "Ivanov Ivan");
        File file = new File("data.bin");
        try
        {
            OutputStream os = new FileOutputStream(file);
            try
            {
                ObjectOutputStream oos =
                        new ObjectOutputStream(new BufferedOutputStream(os));
                try
                {
                    oos.writeObject(person);
                    oos.flush();
                }
                finally
                {
                    oos.close();
                }
            }
            finally
            {
                os.close();
            }
            InputStream is = new FileInputStream(file);
            try
            {
                ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(is));
                try
                {
                    Person restored = (Person)ois.readObject();
                    System.out.println(restored.getName()+": "+restored.getAge());
                    boolean bSame = (person == restored);
                    System.out.println("Same object: "+bSame);
                }
                catch (ClassNotFoundException ex)
                {
                    ex.printStackTrace();
                }
                finally
                {
                    ois.close();
                }
            }
            finally
            {
                is.close();
            }
        }
        catch (IOException ex)
        { ex.printStackTrace(); }
    }}

}
   /* public MainApplicationFrame readObject1(){
        try{
            //Читаем с файла объект Users(достаем фигуру с коробки и надуваем)
            FileInputStream fis = new FileInputStrea("имя коробки");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj= ois.readObject();//Получаем объекты в том порядке,в котором
            //записывали(Спустили фигуру собачки и положили в коробку первую,значит
            //и достаем тогда её первой и надуваем
            //Так как Object нужно привести к типу ниже в иерархии
            //Users users = obj;
            ois.close();

    } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

*/

