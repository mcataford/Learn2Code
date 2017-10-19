# Introduction to Java programming

## Control flow

In this section, we will explore how we can use __conditional statements__ and __loops__ to modify the way our programs behave and to have our programs work differently based on output.

#### Table of contents

1. [Control flow](#controlflow)
2. [Conditional statements](#conditionalstatements)
- [Conditions](#conditions)
- [Conditional structures](#conditionalstructures)
- [Chained conditions](#chainedconditions)
- [Review](#review1)
3. [Loops](#loops)
- [`while` loops](#whileloops)
- [A note on scope](#scope)
- [`for` loops](#forloops)

<a id="controlflow"></a>
## 1. Control flow

__Control flow__ is the idea of controlling how programs are executed so that their output can be dependent on certain conditions or, on a broader level, so that the execution of a program is more than a top-down readthrough.

Forcing the flow of our programs to follow a certain path is useful to conditionally execute code based on user input or intermediate results generated earlier and to abstract away repetitive code blocks by having Java repeat certain statements internally instead of having us write them several times.

<a id="conditionalstatements"></a>
## 2. Conditional statements

__Conditional statements__ are constructs that encapsulate code that will only be executed if certain conditions are true. Executed or not, the code contained in those blocks is compiled (so it has to be syntactically sound), but it may go unused when you execute your program.

To decide which blocks are executed, we will use __conditions__, which are really just __boolean expressions__ that are evaluated to be `true` or `false`.

<a id="conditions"></a>
### Primitives and conditions

As we mentioned earlier, __conditions__ are boolean. This should remind you of the boolean datatype we discussed previously. In fact, boolean variables can be used as conditions and can contain the result of condition evaluations.

To form proper conditions, we need to build boolean expressions which will use special operators not unlike the ones we have seen when we looked at operations on variables:

|Operator|Meaning|
|---|---|
|`A == B`|A "is equal to" B|
|`A != B`|A "is not equal to" B|
|`A > B`|A "is greater than" B|
|`A < B`|A "is lesser than" B|
|`A >= B`|A "is greater than or equal to" B|
|`A <= B`|A "is lesser than or equal to" B|

Any of these operators, when used with two primitive values, will produce a __boolean__, which can then be used as a condition.

We will later see that similar constructs exist for reference types.

<a id="conditionalstructures"></a>
### Conditional structures

Once we have conditions we want to evaluate, we can build __conditional blocks__ around them such that the code that those blocks contain will only be executed if the conditions given are `true`. 

Conditional blocks can be initiated using three keywords: `if`, `else if` and `else`.

The `if` keyword initiates the most basic conditional block:

```java
if(condition) {
	//This code is only executed if "condition" is true.
}
```

If the specified condition, made of boolean expressions, is `true`, the code within is executed, otherwise, the entire block is simply skipped and the next line after the closing brace of the `if` block is executed instead.

A real-world example of this would be:

```java
int some_value = 10;

if(some_value >= 5) {
	System.out.println("The value is larger than or equal to 5.");
}
```

In this scenario, `some_value` is tested to see if it is greater than or equal to 5 (by the `>=` operator). Since it is, the `some_value >= 5` statement is evaluated to `true`, which allows the print statement to be executed.

As we mentioned, if the condition specified with the `if` statement is `false`, the block is simply ignored. We can add an alternate route to the `if` block by using `else`. 

An `else` block will only be executed if the `if` it is associated with isn't:

```java
int some_value = 3;

if(some_value >= 5) {
	System.out.println("The value is larger than or equal to 5.");
} else {
	System.out.println("The value is smaller than 5.);
}
```

In this new scenario, `some_value >= 5` is no longer true since `some_value = 3`. In this case, the `else` is executed instead of the `if`.

This allows a useful binary where we execute one block or the other, allowing us to deeply alter how our programs behave.

We can add "in-between" blocks by using `else if`, in which case conditions are evaluated from the top and the first one that is `true` is chosen:

```java
int some_value = 7;

if(some_value >= 20) {
	System.out.println("The value is larger than or equal to 20.");
} else if(some_value >= 10) {
	System.out.println("The value is larger than or equal to 10.");
} else if(some_value >= 5) {
	System.out.println("The value is larger than or equal to 5.");
} else {
	System.out.println("The value is smaller than 5.);
}
```

Since `some_value` is not larger than or equal to 20, the `if` is overlooked. Next, the `else if` tests if `some_value` is larger than or equal to 10, which is still `false`. The next `else if` is however satisfied, which prints the appropriate output.

Of all three, only `if` is mandatory for a conditional statement to be valid. `else if` and `else` are not both needed, so you can form structures with `if` and `else if`, or with `if` and `else`. You however cannot have either `else` or `else if` without an `if`.

<a id="chainedconditions"></a>
### Chained conditions

Earlier, we looked at simple expressions that only had one boolean component. Java offers us two operators that will allow us to combine simple conditions into more complex ones such that you can test if two or more conditions are true simultaneously, if at least one of a group is true, and any combination in between:

|Keyword|Effect|
|---|---|
|`A && B`|Both conditions `A` and `B` must be true|
|`A \|\| B`|Either `A` or `B` must be true|

Using `&&` and `||`, you can build large conditions that cover very precise cases. For example, you could write `x >= 0 && x <= 10` to evaluate if `x` is included between 0 and 10. Similarly, `x <= 0 || x >= 10` would test if `x` is below or equal to 0 __or__ greater than or equal to 10.

Of course, both operators can be used in conjunction with each other; in this case, you must use parentheses to determine which expressions are associated with each other.

```java
//Assume some_value is defined.

if((some_value >= 0 && some_value <= 10) || some_value == 20) {
	//This is only executed if:
	//some_value is between 0-10, inclusively OR equal to 20.
}
```

Expressions are read from left to right, and not using parentheses for conditions in which `&&` and `||` are combined might lead to undesired outcomes.

<a id="review1"></a>
### Review

- __Conditions__ are __boolean expressions__ that evaluate to `true` or `false`.
- The result of those expressions can be saved into variables, corresponding to the __boolean__ datatype.
- Conditions can use __numerical comparison operators__ that evaluate whether values are lesser, greater or equal to another.
- Boolean expressions can be __chained__ using `&&` and `||` to build conditions that rely on multiple expressions.
- __Conditional statements__ use conditions to selectively execute code.
- Conditional statements are made of three different blocks: `if`, `else if` and `else`.
- The general model for conditional elements is:
```java
if(condition) {
	//Executes if "condition" is true.
} else if(condition2) {
	//Executes if "condition2" is true.
} else {
	//Executes if all else fails.
}
```
- Only the `if` is mandatory for a conditional statement to be valid.
- An arbitrary number of `else if` can be added after an `if` to evaluate extra conditions.
- `else` will only be executed if none of the previous `if` and `else if` are executed.

<a id="loops"></a>
## 3. Loops

Aside from __selective execution__, __repetition__ is the other main way by which we can alter the flow of our programs. Much like __conditional statements__, __loops__ are code blocks delimited by braces and that operate on the code they contain. We will discuss two types of loops, __for loops__ and __while loops__, but in both cases, the functionality is the same, only the semantics and the syntax changes.

<a id="whileloops"></a>
### `while` loops

__While loops__ are __condition-based blocks__. Their continued execution depend on the condition(s) attached to them, conditions which follow the same model as the ones discussed in conjunction with the `if` blocks:

```java
while(condition) {
	//Code.
}
```

In this template, the `while` keyword introduces the block, the `condition` placeholder can be any boolean expression or value, and `//Code.` is the code payload that will be repeated. As long as `condition` can be evaluated to `true`, the code contained in the `while` block is repeated.

__Be extremely careful!__ The loop's condition must be satisfiable! If your loop can never reach a state where the condition is no longer met, it will execute forever and become an __infinite loop__ which can then eventually crash your system.

Let's look at a more complex `while` loop:

```java
int i = 0;

while(i <= 10) {
	System.out.println(i);
	i = i + 1;
}
```

In the fragment above, the loop is __not infinite__ because while `i` is initially 0, it will be incremented at each iteration and will eventually break the condition `i <= 10`. However, if the last line of our loop wasn't there (i.e. `i = i + 1`), then the value of `i` would remain 0, thus never reaching a point where `i <= 10`.

<hr>

#### Try it out!

Using a `while` loop,  could you compute the sum of all numbers between 0 and 1000 that are multiples of 3 or 5 but not both?

<hr>

<a id="scope"></a>
### A note on scope

In the previous fragment, notice that we defined the `i` variable __outside__ of the loop block, yet we use it __inside__ the loop block. This bring forth the idea of __scope__.

In programming, __scope__ is the notion that variables exist as long as they are relevant before being destroyed by Java's garbage collector. A variable lives __within the block in which it is declared and its children__.

```java
public class MyClass {
	public static void main(String[] args) {
		int i = 0;

		while(i <= 10) {
			System.out.println(i);
			i = i + 1;
		}
	}
}
```

In this more complete example, `i` is declared __in the main method__, it is then available for use anywhere within the main method and within its children. The `while` loop block being in the main method, it is considered to be a child of the main method. As such `i` can be used in there.

Note that this relationship isn't reversible: something declared in a child isn't available outside that child.

<hr>

#### Try it out!

What happens if you try to access a variable __out of scope__? Try writing a program in which a parent attempts to access a variable declared in its child. What happens then?

<hr>

<a id="forloop"></a>
### `for` loops

__For loops__ are functionally the same as __while loops__: they outline code that is to be repeated a certain number of times. Unlike `while` loops, `for` loops will need more setup to properly define a __counter variable__ that will track the state of the loop.

```java
for(initialize the counter ; condition ; update the counter) {
	//Code.
}
```

In this simple model, we notice that the `for` loop header has three components:

- The first will __initialize__ the counter used by the loop. Here, we can __declare and initialize__ a variable or reuse a variable and give it a new value.
- The second is a __condition__ just like the `while` loop's: as long as this condition is satisfied, the loop will continue operating.
- The third is executed __at the end of every loop iteration__ and is usually an operation executed on the counter to make sure that the condition is eventually broken (so that the loop can end).

A `for` loop version of the `while` loop we wrote earlier would be:

```java
for(int i = 0 ; i <= 10 ; i = i + 1) {
	System.out.println(i);
}
```

Here, we __declare and initialize__ the variable `i`, which will serve as our counter; at each iteration, the condition `i <= 10` is checked to make sure that we are allowed to run the loop's code again, then we run the loop's code. Finally, the `i = i + 1` statement is executed to update `i` and the program goes back to the condition to see if it can run through the loop one more time.

The difference between a `for` and `while` loop is primarily syntactic, and as we just saw, we can rewrite any `while` loop into a `for` loop (and vice-versa). Moreover, one shouldn't perform worse or better than the other. 

Choosing which loop type to use is then left to the programmer's discretion, depending on what is more convenient to implement the functionality being worked on.

<hr>

#### Try it out!

Can you write a `for` loop that would __print__ all of the __odd numbers__ between 100 and 200? Try doing it using an `if` block, without, and once you are done, try converting your `for` loop into a `while` loop.

<hr>