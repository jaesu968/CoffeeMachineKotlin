package machine

// store state in an enum class
enum class State {
    CHOOSING_ACTION,
    CHOOSING_COFFEE,
    FILL_WATER,
    FILL_MILK,
    FILL_BEANS,
    FILL_CUPS
}

class CoffeeMachine {
    // a class to store default variables
    private var water = 400
    private var milk = 540
    private var beans = 120
    private var cups = 9
    private var cash = 550
    private var state = State.CHOOSING_ACTION

    var isRunning = true

    // function to process state
    fun process(input: String) {
        when (state) {
            State.CHOOSING_ACTION -> handleAction(input)
            State.CHOOSING_COFFEE -> handleCoffee(input)
            State.FILL_WATER -> {
                water += input.toInt(); askMilk()
            }

            State.FILL_MILK -> {
                milk += input.toInt(); askBeans()
            }

            State.FILL_BEANS -> {
                beans += input.toInt(); askCups()
            }

            State.FILL_CUPS -> {
                cups += input.toInt(); state = State.CHOOSING_ACTION; askAction()
            }
        }
    }

    fun handleAction(input: String) {
        when (input) {
            "buy" -> {
                askCoffee(); state = State.CHOOSING_COFFEE
            }

            "fill" -> {
                // askWater() will start a chain effect to askMilk(), askBeans(), askCups(), askAction()
                askWater(); state = State.FILL_WATER

            }

            "take" -> {
                println("I gave you \$$cash"); cash = 0; askAction()
            }

            "remaining" -> {
                printState(); askAction()
            }

            "exit" -> {
                isRunning = false
            }
        }
    }

    fun handleCoffee(input: String) {
        when (input) {
            "1" -> makeCoffee(250, 0, 16, 4) // espresso
            "2" -> makeCoffee(350, 75, 20, 7) // latte
            "3" -> makeCoffee(200, 100, 12, 6) // cappuccino
            "back" -> {} // just fall through the menu
        }
        // set state
        state = State.CHOOSING_ACTION
        askAction()
    }

    // make coffee
    private fun makeCoffee(w: Int, m: Int, b: Int, price: Int) {
        // error validation make sure there is enough , other
        when {
            water < w -> println("Sorry, not enough water!")
            milk < m -> println("Sorry, not enough milk!")
            beans < b -> println("Sorry, not enough beans!")
            cups < 1 -> println("Sorry, not enough cups!")
            else -> {
                println("I have enough resources, making you a coffee!")
                water -= w
                milk -= m
                beans -= b
                cups -= 1
                cash += price
            }
        }
    }

    private fun askAction() = println("\nWrite action (buy, fill, take, remaining, exit):")
    private fun askCoffee() = println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    private fun askWater() = println("\nWrite how many ml of water you want to add:")
    private fun askMilk() = println("Write how many ml of milk you want to add:")
    private fun askBeans() = println("Write how many grams of coffee beans you want to add:")
    private fun askCups() = println("Write how many disposable cups you want to add:")

    fun printState() {
        println()
        println("The coffee machine has:")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$beans g of coffee beans")
        println("$cups disposable cups")
        println("$$cash of money")
    }

    fun start(){
        askAction()
    }
}

fun main() {
    // create a Coffee Machine object to work with
    val machine = CoffeeMachine()
    machine.start()
    // run a while loop
    while(machine.isRunning) {
        machine.process(readln())
    }
}






