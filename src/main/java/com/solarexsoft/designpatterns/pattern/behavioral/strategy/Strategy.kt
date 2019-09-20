package com.solarexsoft.designpatterns.pattern.behavioral.strategy

/**
 * Created by houruhou on 2019/9/20.
 * Desc:
 */
interface PromotionStrategy {
    fun doPromotion(price: Float): Float
}

class LiJianPromotionStrategy : PromotionStrategy {
    override fun doPromotion(price: Float): Float {
        return if (price > 50) price - 20.0f else price
    }
}

class DiscountPromotionStrategy : PromotionStrategy {
    override fun doPromotion(price: Float): Float {
        return if (price > 100) price * 0.8f else price
    }
}

class PromotionActivity(var originalPrice: Float, var promotionStrategy: PromotionStrategy) {
    fun getPrice():Float {
        return promotionStrategy.doPromotion(originalPrice)
    }
}

fun main() {
    val activity618 = PromotionActivity(800f, DiscountPromotionStrategy())
    println(activity618.getPrice())
    activity618.originalPrice = 500f
    activity618.promotionStrategy = LiJianPromotionStrategy()
    println(activity618.getPrice())

    val activity1111 = PromotionActivity(120f, LiJianPromotionStrategy())
    println(activity1111.getPrice())
}