package com.solarexsoft.designpatterns.principle.dependenceinversion

/**
 * Created by houruhou on 2019/9/15.
 * Desc:
 */
class SolarexStudyClient(private val course: IStudyCourse){
    fun study(){
        course.studyCourse()
    }
}

fun main() {
    val client = SolarexStudyClient(PythonStudyCourse())
    client.study()
}