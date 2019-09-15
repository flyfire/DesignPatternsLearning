package com.solarexsoft.designpatterns.pattern.creational.simplefactory

/**
 * Created by houruhou on 2019/9/15.
 * Desc:
 */
interface Video {
    fun produce()
}

class JavaVideo : Video {
    override fun produce() {
        println("produce java video")
    }
}

class PythonVideo : Video {
    override fun produce() {
        println("produce python video")
    }
}

class VideoFactory {
    companion object {
        fun <T:Video> createVideo(clz: Class<T>):T = clz.newInstance()
    }
}

fun main() {
    VideoFactory.createVideo(JavaVideo::class.java).produce()
}

// Calendar.java getInstance
// DriverManager.java getConnection sql connection