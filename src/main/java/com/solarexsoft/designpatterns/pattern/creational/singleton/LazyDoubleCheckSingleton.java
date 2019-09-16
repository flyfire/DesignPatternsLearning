package com.solarexsoft.designpatterns.pattern.creational.singleton;

import java.io.*;

/**
 * Created by houruhou on 2019/9/16.
 * Desc:
 */
public class LazyDoubleCheckSingleton implements Serializable{
    private static volatile LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;
    private LazyDoubleCheckSingleton() {
    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (lazyDoubleCheckSingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazyDoubleCheckSingleton == null) {
                    // 1.分配内存给对象
                    // 2.初始化对象
                    // 3.设置lazyDoubleCheckSingleton指向刚分配的内存地址
                    // 2,3可能指令重排序，如重排序，其他线程可能访问到未完全初始化的对象
                    // volatile禁止指令重排序
                    // Class对象初始化锁允许2,3重排序，但是重排序对外部线程不可见
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }

    private Object readResolve() {
        if (lazyDoubleCheckSingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazyDoubleCheckSingleton == null) {
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }

    static class LazyDoubleCheckSingletonRunnable implements Runnable {
        @Override
        public void run() {
            LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + "-->" + instance);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + "-->" + instance);
        Thread t1 = new Thread(new LazyDoubleCheckSingletonRunnable(), "t1");
        Thread t2 = new Thread(new LazyDoubleCheckSingletonRunnable(), "t2");
        t1.start();
        t2.start();
        System.out.println("main program end");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lazy_double_check_singleton.txt"));
        oos.writeObject(instance);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lazy_double_check_singleton.txt"));
        LazyDoubleCheckSingleton doubleCheckSingleton = (LazyDoubleCheckSingleton) ois.readObject();
        System.out.println("main read object singleton = " + doubleCheckSingleton);
        System.out.println(instance == doubleCheckSingleton);
    }
}
