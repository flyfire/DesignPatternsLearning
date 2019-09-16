package com.solarexsoft.designpatterns.pattern.creational.singleton;

import java.io.*;

/**
 * Created by houruhou on 2019/9/16.
 * Desc:
 */
public class LazySingleton implements Serializable {
    private static LazySingleton lazySingleton = null;
    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    static class LazySingletonRunnable implements Runnable{

        @Override
        public void run() {
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + "-->" + instance);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + "-->" + lazySingleton);
        Thread t1 = new Thread(new LazySingletonRunnable(), "t1");
        Thread t2 = new Thread(new LazySingletonRunnable(), "t2");
        t1.start();
        t2.start();
        System.out.println("main program end");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lazy_singleton.txt"));
        oos.writeObject(lazySingleton);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lazy_singleton.txt"));
        LazySingleton instance = (LazySingleton) ois.readObject();
        System.out.println("main -> read object instance = " + instance);
    }
}

