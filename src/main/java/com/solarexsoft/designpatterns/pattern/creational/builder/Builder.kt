package com.solarexsoft.designpatterns.pattern.creational.builder

/**
 * Created by houruhou on 2019/9/15.
 * Desc:
 */
class MoocCourse(builder: MoocCourseBuilder) {
    var name = "";
    var ppt = "";
    var article = "";

    init {
        this.name = builder.name
        this.ppt = builder.ppt
        this.article = builder.article
    }

    override fun toString(): String {
        return "name = $name,ppt = $ppt,article = $article"
    }
}

class MoocCourseBuilder() {
    var name = "";
    var ppt = "";
    var article = "";
    fun buildCourseName(name: String): MoocCourseBuilder {
        this.name = name
        return this
    }

    fun buildCoursePpt(ppt: String): MoocCourseBuilder {
        this.ppt = ppt
        return this
    }

    fun buildCourseArticle(article: String): MoocCourseBuilder {
        this.article = article
        return this
    }

    fun build(): MoocCourse {
        return MoocCourse(this)
    }
}

fun main() {
    val course =
        MoocCourseBuilder().buildCourseName("Python").buildCoursePpt("python ppt").buildCourseArticle("python article")
            .build()
    println(course)
}