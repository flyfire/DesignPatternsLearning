package com.solarexsoft.designpatterns.pattern.creational.singleton;

import java.io.*;

/**
 * Created by houruhou on 2019/9/16.
 * Desc:
 */
public class HungrySingleton implements Serializable{
    private static final HungrySingleton hungrySingleton = new HungrySingleton();
    private HungrySingleton(){
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

    public Object readResolve() {
        return hungrySingleton;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
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
    }
}
