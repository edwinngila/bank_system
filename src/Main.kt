fun main() {
    val savings = SavingsAccount(10000.0)
    val checking = CheckingAccount(2000.0)

    savings.deposit(10000.0)
    checking.withdraw(2000.0)

    println("${savings.accountType()} has balance: ${savings.getBalance()}")
    println("${checking.accountType()} has balance: ${checking.getBalance()}")
}

interface BackAccount{
    fun deposit(amount:Double)
    fun withdraw(amount:Double)
    fun getBalance():Double
}

abstract class AbstractAccount(private var balance:Double) :BackAccount{

    override fun deposit(amount: Double) {
        if (amount > 0){
            balance+=amount
        }
    }

    override fun withdraw(amount: Double) {
        if (amount >0 && amount<=balance){
            balance -= amount
        }
    }

    override fun getBalance(): Double {
        return balance
    }

    abstract fun accountType():String
}

class SavingsAccount(balance: Double) : AbstractAccount(balance){
    override fun accountType(): String {
        return "Savings Account"
    }
}

class CheckingAccount(balance: Double) : AbstractAccount(balance){
    override fun accountType(): String {
        return "Checking account"
    }
}