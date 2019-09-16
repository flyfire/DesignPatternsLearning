package com.solarexsoft.designpatterns.pattern.creational.singleton;

import java.io.*;

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

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        EnumSingleton enumSingleton = EnumSingleton.getInstance();
        enumSingleton.setData(new Object());

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("enum_singleton.txt"));
        oos.writeObject(enumSingleton);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("enum_singleton.txt"));
        EnumSingleton instance = (EnumSingleton) ois.readObject();
        System.out.println(enumSingleton == instance);
        System.out.println(enumSingleton.getData() == instance.getData());
    }
}
