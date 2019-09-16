package com.solarexsoft.designpatterns.pattern.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by houruhou on 2019/9/16.
 * Desc:
 */
public enum EnumSingleton {
    INSTANCE;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingleton enumSingleton = EnumSingleton.getInstance();
        enumSingleton.setData(new Object());

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("enum_singleton.txt"));
        oos.writeObject(enumSingleton);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("enum_singleton.txt"));
        EnumSingleton instance = (EnumSingleton) ois.readObject();
        System.out.println(enumSingleton == instance);
        System.out.println(enumSingleton.getData() == instance.getData());

        Class clz = EnumSingleton.class;
        Constructor constructor = clz.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        EnumSingleton reflectInstance = (EnumSingleton) constructor.newInstance("solarex", 1);
        System.out.println(reflectInstance);
        System.out.println(enumSingleton == reflectInstance);
    }
}
