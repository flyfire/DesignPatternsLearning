package com.solarexsoft.designpatterns.pattern.behavioral.state

/**
 * Created by houruhou on 2019/9/20.
 * Desc:
 */
abstract class MovieState {
    var context: MovieContext? = null
    abstract fun play()
    abstract fun speed()
    abstract fun pause()
    abstract fun stop()
}

class MovieContext {
    var state:MovieState? = null
    fun setMovieState(movieState: MovieState) {
        state = movieState
        state?.context = this
    }

    fun play() {
        state?.play()
    }

    fun speed() {
        state?.speed()
    }

    fun pause() {
        state?.pause()
    }

    fun stop() {
        state?.stop()
    }

    companion object {
        val PLAY_STATE = PlayState()
        val SPEED_STATE = SpeedState()
        val PAUSE_STATE = PauseState()
        val STOP_STATE = StopState()
    }
}

class PlayState : MovieState() {
    override fun play() {
        println("play")
    }

    override fun speed() {
        context?.setMovieState(MovieContext.PLAY_STATE)
    }

    override fun pause() {
        context?.setMovieState(MovieContext.PAUSE_STATE)
    }

    override fun stop() {
        context?.setMovieState(MovieContext.STOP_STATE)
    }
}
class SpeedState : MovieState() {
    override fun play() {
        context?.setMovieState(MovieContext.PLAY_STATE)
    }

    override fun speed() {
        println("speed")
    }

    override fun pause() {
        context?.setMovieState(MovieContext.PAUSE_STATE)
    }

    override fun stop() {
        context?.setMovieState(MovieContext.STOP_STATE)
    }
}

class PauseState : MovieState() {
    override fun play() {
        context?.setMovieState(MovieContext.PLAY_STATE)
    }

    override fun speed() {
        context?.setMovieState(MovieContext.SPEED_STATE)
    }

    override fun pause() {
        println("pause")
    }

    override fun stop() {
        context?.setMovieState(MovieContext.STOP_STATE)
    }
}

class StopState: MovieState() {
    override fun play() {
        context?.setMovieState(MovieContext.PLAY_STATE)
    }

    override fun speed() {
        println("error: cant speed at stop mode")
    }

    override fun pause() {
        println("error: cant pause at pause mode")
    }

    override fun stop() {
        println("stop")
    }
}

fun main() {
    val context = MovieContext()
    context.setMovieState(MovieContext.PLAY_STATE)
    println(message = context.state?.javaClass?.simpleName)
    context.pause()
    println(message = context.state?.javaClass?.simpleName)
    context.speed()
    println(message = context.state?.javaClass?.simpleName)
    context.pause()
    println(message = context.state?.javaClass?.simpleName)
    context.stop()
    println(message = context.state?.javaClass?.simpleName)
    context.speed()
    println(message = context.state?.javaClass?.simpleName)
}