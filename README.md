This is the *Coffee Machine (Kotlin)* project I made myself.


<p>What can be better than a cup of coffee during a break? A coffee that you don’t have to make yourself. It’s enough to press a couple of buttons on the machine and you get a cup of energy; but first, we should teach the machine how to do it. In this project, you will work on programming a coffee machine simulator. The machine works with typical products: coffee, milk, sugar, and plastic cups; if it runs out of something, it shows a notification. You can get three types of coffee: espresso, cappuccino, and latte. Since nothing’s for free, it also collects the money.</p>

Here's the link to the project: https://hyperskill.org/projects/67

Check out my profile: https://hyperskill.org/profile/619269930

## What I did in each stage

The project is built up across six stages, each adding functionality on top of the last.

### Stage 1 — Making coffee
Printed a fixed sequence of lines describing the coffee-making process (grinding beans, boiling water, pouring, etc.).
No input yet — just simulating the steps of making one cup.

### Stage 2 — Ingredient calculator
Read the desired number of cups from input and calculated how much of each ingredient was needed,
using 200 ml of water, 50 ml of milk, and 15 g of coffee beans per cup, then printed the required amounts.

### Stage 3 — Estimate the number of servings
Read the currently available water, milk, and beans plus the number of cups requested, then reported whether the machine could make that many cups:
- `Yes, I can make that amount of coffee` when supplies matched.
- `Yes, I can make that amount of coffee (and even N more than that)` when there was extra.
- `No, I can make only N cups of coffee` when supplies fell short.

### Stage 4 — Buy, fill, take
Modeled a real machine with limited stock (400 ml water, 540 ml milk, 120 g beans, 9 cups, $550). 
Handled a single action per run — `buy` (espresso / latte / cappuccino, each with its own recipe and price), 
`fill` to replenish supplies, or `take` to collect the cash — printing the machine's state before and after.

### Stage 5 — Keep track of the supplies
Wrapped everything in a loop so the machine runs continuously until `exit`. 
Added the `remaining` command to show current stock, `back` to cancel a purchase, and out-of-resource messages (e.g. `Sorry, not enough water!`) so it stops when it can't make a drink.

### Stage 6 — Brush up your code
Refactored into a `CoffeeMachine` class driven by a single `process(input)` method.
Instead of reading input directly,
the class tracks its current state via a `State` enum (choosing an action, choosing a coffee, filling each ingredient) and
interprets each input line based on that state — closely mirroring how a real event-driven device works.