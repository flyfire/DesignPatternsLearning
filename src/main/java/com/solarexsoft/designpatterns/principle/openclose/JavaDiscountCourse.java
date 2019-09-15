package com.solarexsoft.designpatterns.principle.openclose;

/**
 * Created by houruhou on 2019/9/15.
 * Desc:
 */
public class JavaDiscountCourse extends JavaCourse {
    public JavaDiscountCourse(int id, String name, float price) {
        super(id, name, price);
    }

    public float getDiscountPrice() {
        return super.getPrice() * 0.8f;
    }
}
