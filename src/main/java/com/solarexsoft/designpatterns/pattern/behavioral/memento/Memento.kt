package com.solarexsoft.designpatterns.pattern.behavioral.memento

import java.util.*

/**
 * Created by houruhou on 2019/9/20.
 * Desc:
 */
data class Article(var title: String, var content: String) {
    fun saveToMemento(): ArticleMemento {
        return ArticleMemento(title, content)
    }

    fun restoreFromMemento(memento: ArticleMemento?) {
        title = (if (memento == null) {
        } else {
            memento.title
        }).toString()
        content = (if (memento == null) {
        } else {
            memento.content
        }).toString()
    }
}

data class ArticleMemento(val title: String, val content: String)

class ArticleMementoManager {
    private val STACK = Stack<ArticleMemento>()

    fun addMemento(memento: ArticleMemento) {
        STACK.push(memento)
    }

    fun getMemento(): ArticleMemento? {
        return STACK.pop()
    }
}

fun main() {
    val manager = ArticleMementoManager()
    val article = Article("111", "111111111")
    println(article)
    manager.addMemento(article.saveToMemento())
    article.title = "222"
    article.content = "22222222"
    println(article)
    manager.addMemento(article.saveToMemento())
    article.title = "333"
    article.content = "33333333"
    println(article)
    article.restoreFromMemento(manager.getMemento())
    println(article)
    article.restoreFromMemento(manager.getMemento())
    println(article)
}