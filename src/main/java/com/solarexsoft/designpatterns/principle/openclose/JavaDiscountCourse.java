package com.solarexsoft.designpatterns.principle.openclose;

/**
 * Created by houruhou on 2019/9/15.
 * Desc:
 */
public class JavaDiscountCourse extends JavaCourse {
    public JavaDiscountCourse(int id, String name, float price) {
        super(id, name, price);
    }

    public float getOriginalPrice() {
        return super.getPrice();
    }

    @Override
    public Float getPrice() {
        return super.getPrice() * 0.8f;
    }
}
