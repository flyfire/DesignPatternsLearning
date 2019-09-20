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

class EmptyPromotionStrategy : PromotionStrategy {
    override fun doPromotion(price: Float): Float {
        return price
    }
}

class PromotionStrategyFactory private constructor() {

    companion object {
        private val PROMOTION_STRATEGY_MAP = mutableMapOf<String, PromotionStrategy>()
        private val NON_POMOTION = EmptyPromotionStrategy()
        const val LIJIAN = "lijian"
        const val DISCOUNT = "discount"
        init {
            PROMOTION_STRATEGY_MAP[LIJIAN] = LiJianPromotionStrategy()
            PROMOTION_STRATEGY_MAP[DISCOUNT] = DiscountPromotionStrategy()
        }

        fun getPromotionStrategy(key: String): PromotionStrategy {
            return PROMOTION_STRATEGY_MAP[key] ?: NON_POMOTION
        }
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

    val activity101 = PromotionActivity(1000f, PromotionStrategyFactory.getPromotionStrategy(PromotionStrategyFactory.DISCOUNT))
    println(activity101.getPrice())
}

