package com.solarexsoft.designpatterns.pattern.creational.singleton;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;

import java.io.*;

/**
 * Created by houruhou on 2019/9/16.
 * Desc:
 */
public class StaticInnerClassSingleton implements Serializable {
    private StaticInnerClassSingleton(){
    }
    private static class InnerClass {
        // 类初始化锁
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }
    static class StaticInnerClassSingletonRunnable implements Runnable{
        @Override
        public void run() {
            StaticInnerClassSingleton instance = StaticInnerClassSingleton.InnerClass.staticInnerClassSingleton;
            System.out.println(Thread.currentThread().getName() + "->" + instance);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        StaticInnerClassSingleton innerClassSingleton = InnerClass.staticInnerClassSingleton;
        System.out.println(Thread.currentThread().getName() + "->" + innerClassSingleton);
        Thread t1 = new Thread(new StaticInnerClassSingletonRunnable(), "t1");
        Thread t2 = new Thread(new StaticInnerClassSingletonRunnable(), "t2");
        t1.start();
        t2.start();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("static_innerclass_singleton.txt"));
        oos.writeObject(innerClassSingleton);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("static_innerclass_singleton.txt"));
        StaticInnerClassSingleton instance = (StaticInnerClassSingleton) ois.readObject();
        System.out.println("main read object = " + instance);
    }
}
