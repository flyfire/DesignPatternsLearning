package com.solarexsoft.designpatterns.pattern.creational.abstractfactory

/**
 * Created by houruhou on 2019/9/15.
 * Desc:
 */
interface CourseFactory {
    fun getVideo(): CourseVideo
    fun getArticle(): CourseArticle
}

abstract class CourseVideo {
    abstract fun produce()
}

abstract class CourseArticle {
    abstract fun write()
}

class MathVideo : CourseVideo() {
    override fun produce() {
        println("math video")
    }
}

class MathArticle : CourseArticle() {
    override fun write() {
        println("matho article")
    }
}

class MathFactory : CourseFactory {
    override fun getVideo(): CourseVideo {
        return MathVideo()
    }

    override fun getArticle(): CourseArticle {
        return MathArticle()
    }
}

class EnglishVideo : CourseVideo() {
    override fun produce() {
        println("english video")
    }
}

class EnglishArticle : CourseArticle() {
    override fun write() {
        println("english article")
    }
}

class EnglishFactory : CourseFactory {
    override fun getVideo(): CourseVideo {
        return EnglishVideo()
    }

    override fun getArticle(): CourseArticle {
        return EnglishArticle()
    }
}

fun main() {
    val factory = EnglishFactory()
    factory.getVideo().produce()
    factory.getArticle().write()
}

// 工厂方法关注单一产品等级结构，抽象工厂关注产品族
// java.sql.Connection createStatement() prepareStatement