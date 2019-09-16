package com.solarexsoft.designpatterns.pattern.creational.singleton;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by houruhou on 2019/9/16.
 * Desc:
 */
public class StaticInnerClassSingleton implements Serializable {
    private StaticInnerClassSingleton(){
        if (InnerClass.staticInnerClassSingleton != null) {
            throw new RuntimeException("cant instantiate StaticInnerClassSingleton using reflect");
        }
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

    private Object readResolve() {
        return InnerClass.staticInnerClassSingleton;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /*
        Class clz = StaticInnerClassSingleton.class;
        Constructor constructor = clz.getDeclaredConstructor();
        constructor.setAccessible(true);
        StaticInnerClassSingleton reflectInstance = (StaticInnerClassSingleton) constructor.newInstance();
        System.out.println("reflectInstance = " + reflectInstance);
        */
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
        System.out.println(innerClassSingleton == instance);

        Class clz = StaticInnerClassSingleton.class;
        Constructor constructor = clz.getDeclaredConstructor();
        constructor.setAccessible(true);
        StaticInnerClassSingleton reflectInstanceNew = (StaticInnerClassSingleton) constructor.newInstance();
        System.out.println(innerClassSingleton);
        System.out.println("reflectInstanceNew = " + reflectInstanceNew);
        System.out.println(innerClassSingleton == reflectInstanceNew);
    }
}
