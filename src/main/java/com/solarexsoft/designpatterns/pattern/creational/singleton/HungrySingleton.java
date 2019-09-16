package com.solarexsoft.designpatterns.pattern.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by houruhou on 2019/9/16.
 * Desc:
 */
public class HungrySingleton implements Serializable{
    private static final HungrySingleton hungrySingleton = new HungrySingleton();
    private HungrySingleton(){
        // walkaround 对类加载时就创建好对象的方式是有效的
        if (hungrySingleton != null) {
            throw new RuntimeException("instantiate HungrySingleton using reflect is not allowed");
        }
    }
    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    static class HungrySingletonRunnable implements Runnable {
        @Override
        public void run() {
            HungrySingleton instance = HungrySingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + "->" + instance);
        }
    }

    private Object readResolve() {
        return hungrySingleton;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        HungrySingleton instance = HungrySingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + "->" + instance);
        Thread t1 = new Thread(new HungrySingletonRunnable(), "t1");
        Thread t2 = new Thread(new HungrySingletonRunnable(), "t2");
        t1.start();
        t2.start();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("hungry_singleton.txt"));
        oos.writeObject(instance);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("hungry_singleton.txt"));
        HungrySingleton hungrySingleton = (HungrySingleton) ois.readObject();
        System.out.println("main read object = " + hungrySingleton);
        System.out.println(instance == hungrySingleton);

        Class clz = HungrySingleton.class;
        Constructor constructor = clz.getDeclaredConstructor();
        constructor.setAccessible(true);
        HungrySingleton reflectInstance = (HungrySingleton) constructor.newInstance();
        System.out.println(instance);
        System.out.println(reflectInstance);
        System.out.println(instance == reflectInstance);
    }
}
