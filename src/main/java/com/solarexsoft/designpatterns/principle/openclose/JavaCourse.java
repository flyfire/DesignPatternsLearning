package com.solarexsoft.designpatterns.principle.openclose;

/**
 * Created by houruhou on 2019/9/15.
 * Desc:
 */
public class JavaCourse implements ICourse {
    int id;
    String name;
    float price;

    public JavaCourse(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Float getPrice() {
        return this.price;
    }
}
