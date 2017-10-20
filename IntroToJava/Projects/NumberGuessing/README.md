# Introduction to Java programming

## A simple number guessing game

### 0. Objective

The objective of this small project is to build an __interactive__ number guessing game where one player attempts to guess a random integers; the score of the player is determined by how many tries were necessary to get to the right answer.

### 1. Theory

### Generating random numbers

In Java, a simple way of generating random numbers is to use the built-in `Math` package. The `Math` package implements a certain amount of complex mathematical functions that will prove themselves useful later on; for the needs of our game, we will use its `random()` function.

The `random()` function generates a random `double` between 0.0 and 1.0. Note that 1.0 is excluded from this range so that the values you can get satisfy the inequality `0 <= number < 1.0`.

Generating a random number is then a simple matter of typing:

```java
double my_number = Math.random();
```

In the context of our game, we will want to transform this `double` value into an integer so that the player can guess an integer value between 0 and an arbitrary (but fair) maximum.

### Converting `double` to `int`

We already know that `double` contain a lot of information than `int` does, and that converting from one to the other results in a loss of precision. In our case, the loss of precision isn't a bit concern: we actively want to drop the precision allowed by the fractional part of the number that is generated.

To transform a value that is between 0 and 1 into a useful integer of an arbitrary range, you can make clever use of a __product__ and a __type cast__ so that your `0 <= number < 1.0` value becomes a `0 <= number < 100` value.

### Getting user input using `Scanner`

`Scanner` is the most basic device by which Java can prod the user for information. Knowing how it works would involve getting to know __objects__ better, which will come a bit later in the course. For the time being, we will simply use `Scanner` by following the guidelines below:

- __Setting up__ `Scanner` involved two steps: __importing__ the `Scanner` class and __creating__ a `Scanner` variable.
- __Using__ the `Scanner` is a matter of using the method `nextInt()` on your `Scanner` variable.

Here is an example in which we set up a `Scanner` and then ask the user for an arbitrary integer:

```java
/*
*	Setting up the Scanner pt.1
*	
*	We use the "import" keyword to allow the usage of the Scanner class
*	in our program.
*
*	We will see more about the "import" keyword a bit later.
*/
import java.util.Scanner;

public class MyScannerDemo {
	public static void main(String[] args) {
		/*
		*	Setting up the Scanner pt.2
		*
		*	Since our Scanner is imported, we can use it 
		*	as a variable type the same way we did for
		*	String.
		*
		*	This is called an "object instantiation"; we will
		*	discuss it further in the Objects portion of the course.
		*/
		Scanner my_scanner = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int value = my_scanner.nextInt();

		System.out.println("You typed " + value);
	}

}
```

### 2. Game mechanics

The general game flow is as follows:

- The program __prompts__ the user for a number to use as upper bound for the range over which guessing will happen;
- The program __generates__ a random integer between 0 and the number specified by the user, __this is the number that the user will have to guess;
- Then the game starts: each turn, the user will be prompted for a guess and the game will provide feedback to notify the user whether the guess is too high or too low. If the player guessed right, the game ends here -- otherwise, the game proceeds to the next turn.

You should __keep track of the turns__ so that when the player eventually guesses right, you can assign them a score based on how many tries were needed to get there.

### 3. Demo

You can find a compiled example of the game [here](). To run it, simply open up a command prompt and navigate to the file (using `cd`), then use `java NumberGuessing` to execute it.