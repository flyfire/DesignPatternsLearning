package com.solarexsoft.designpatterns.principle.openclose

/**
 * Created by houruhou on 2019/9/15.
 * Desc:
 */
fun main() {
    val course: ICourse = JavaDiscountCourse(96, "Java", 200.0f);
    val javaCourse: JavaDiscountCourse = course as JavaDiscountCourse;
    println("id = ${course.id}, name = ${course.name}, price = ${course.getPrice()}, originalPrice = ${javaCourse.originalPrice}")
}