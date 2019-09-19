package com.solarexsoft.designpatterns.pattern.structural.bridge

/**
 * Created by houruhou on 2019/9/19.
 * Desc:
 */
interface Account {
    fun openAccount():Account
    fun showAccountType()
}

class DepositeAccount : Account{
    override fun openAccount(): Account {
        println("打开活期账号")
        return DepositeAccount()
    }

    override fun showAccountType() {
        println("这是一个活期账号")
    }
}

class SavingAccount : Account {
    override fun openAccount(): Account {
        println("打开定期账号")
        return SavingAccount()
    }

    override fun showAccountType() {
        println("这是一个定期账号")
    }
}

abstract class Bank constructor(protected open val account: Account) {
    abstract fun openAccount(): Account
}

class ABCBank(override val account: Account) : Bank(account) {
    override fun openAccount(): Account {
        println("打开农业银行账号")
        return account
    }
}

class ICBCBank(override val account: Account): Bank(account) {
    override fun openAccount(): Account {
        println("打开工商银行账号")
        return account
    }
}

fun main() {
    val abcBank = ABCBank(DepositeAccount())
    abcBank.openAccount().showAccountType()
    val icbcBank = ICBCBank(SavingAccount())
    icbcBank.openAccount().showAccountType()
}