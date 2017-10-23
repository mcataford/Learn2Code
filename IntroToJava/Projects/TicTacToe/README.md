# A game of Tic Tac Toe

In this project, you'll be working on a simple __game playing bot__ that implements a playing strategy. Your goal is to produce an AI that has a high change of winning a game of __tic tac toe__.

## Table of contents

1. [Running the game](#exec)
2. [Built-in strategy](#builtin_strat)
3. [Building your playing agent](#your_strat)
4. [Once you have something good](#smth_good)

<a id="exec"></a>
### Running the game

To run this game, you will need to use the __command prompt__. Navigate to the game's folder using `cd` (if you are unsure of how to use the command line, refer to [this document]()) and use the following to compile and run:

To compile the game code:

```bash
javac Driver.java
```

To run the game:

```bash
java Driver
```

The game itself runs in your command prompt and prints output to the screen.

#### Game options

You can tweak the game options in `Driver.java` by modifying the two arguments given to the TicTacToe constructor:

```java
public TicTacToe(boolean manual, boolean start) { ... }
```

The first parameter, `manual`, determines if you play manually or if you use your playing agent.
The second parameter, `start` determines if you play first.

<a id="builtin_strat"></a>
### Built-in strategy

The game contains a simple bot that will select random moves available on the game board. This is meant as a simple benchmark to test your own game-playing agent. More robust players will be added later to up the ante.

You can look at the pre-built playing agent in `RandomAI.java`; its function is fairly naive and simply generates random coordinate sets until one is deemed valid (ie. there is no prior marking at that location).

Surely you can do better!

<a id="your_strat"></a>
Building your playing agent

To build your own Tic Tac Toe bot, you will have to edit `OtherAI.java`. This file is structured exactly like `RandomAI.java` and will be picked up automatically by the game when "non-manual mode" is selected (see the __Game options__).

Your agent's code should determine a move to make based on the current state of the board (accessible through the 2D array `board` given as parameter) and store that move in the `move` array, an integer array that stores the coordinates of your move following the format [row, column].

Make sure that your bot's move is valid before giving it to the game, as an invalid move will have the game reprompt your AI for another potential move, which can lead to an __infinite loop__.

Tweaking a copy of `RandomAI.java`'s strategy might be a good place to start.

Here are a few things to consider when developing your agent:

- Can it detect "winning conditions" and go for the kill?
- Can it foil the other player's winning conditions?
- Is it affect by who plays first?
- Are some moves more valuable than others?

Try playing Tic Tac Toe on paper against your friends to see what could potentially be a good strategy!

<a id="smth_good"></a>
### 4. Once you have something good

Once you have a solid strategy, feel free to let me know at [marc@marccataford.com](mailto:marc@marccataford.com)! We could then organize a small contest between agents to see who has the best tricks!
