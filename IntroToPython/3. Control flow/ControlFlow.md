# Introduction to Python

## Control flow elements

#### Table of contents

1. [Control flow](#controlflow)
2. [Conditional statements](#conditionals)
- [Conditions](#conditions)
- [Conditional statement structure](#conditionalstructure)
- [Chained conditions](#chainedconditions)
- [Review](#review1)
3. [Loops](#loops)
- [While loops](#whileloops)
- [A note on scope](#scope)
- [For loops](#forloops)
- [Review](#review2)

<a id="controlflow"></a>
## 1. Control flow

In programming, __control flow__ refers to the act of modifying how programs behave by selecting what gets executed. When we chatted about the __interpreter__ earlier on, we mentioned that it read code from top to bottom, line by line, executing it as it went. This type of __linear__ execution guarantees that code is executed in the same order every time unless it is forced otherwise.

In this section, we will be learning about some control flow elements that we can use in Python to alter how our programs behave based on input or design. We will touch __conditional statements__ and __loops__, as they are the two main ways by which a programmer can alter the behaviour of their creations.

<a id="conditionals"></a>
## 2. Conditional statements

__Conditional statements__ are __code blocks__ that are only executed if a set of conditions is satisfied. They allow programs to exhibit a great level of flexibility, as the conditions can be tailored to the programmer's needs.

<a id="conditions"></a>
### Conditions

__Conditions__ are the core of conditional statements. They are __boolean__ expressions (which you may remember from the discussion on datatypes) which represent tests that you can run on data.

Boolean expressions are formed using a special set of operators which, instead of producing numerical values like the operators we've seen in the last section, produce `True` or `False` values that can be used as conditions:

|Operator|Meaning|
|---|---|
|`A == B`|A "is equal to" B|
|`A != B`|A "is not equal to" B|
|`A > B`|A "is greater than" B|
|`A < B`|A "is lesser than" B|
|`A >= B`|A "is greater than or equal to" B|
|`A <= B`|A "is lesser than or equal to" B|

As you might've guessed, these operators are mainly used on __numerical variables and values__. There also exist operators that are handy to handle Strings and other collections; for instance, the `in` operator can be used to see if a substring or character is inside of a string:

```python
sentence = "The sky is blue, the grass is green."
substring = "sky"

test1 = substring in sentence #True, since the word "sky" is in the string.
test2 = 'T' in sentence #Also True for the same reason.
test3 = "Pineapple" in sentence #False.
```

You can easily play with the `in` operator and the numerical comparison operators outlines above in the interpreter's console before including them in longer scripts.

Note that all of these operators will return either `True` or `False`, which can then be used as a condition or stored in a variable for later use.

#### Try it out

Using the __interpreter's console__, try out the operators with different values to see what the output is. Is a String considered to be "within" itself? (eg. `"hello" in "hello"`)

<a id="conditionalstructure"></a>
### Conditional statement structure

Conditional statements follow a very simple structure that is the combination of three types of elements: `if` blocks, `elif` blocks and `else` blocks.

The `if` block defines a block of code that is only executed if the conditions attached to the `if` keyword are met. Otherwise, the block is skipped by the interpreter.

A canonical model for the `if` block would be:

```python
if condition:
	#Code executed only if the condition is satisfied.
```

Note that just like the code blocks initiated by `def`, conditional statements are __indented__. Again, this indentation will serve to identify what is contained in the block and what isn't.

Based on what we just discussed around conditions, we can use __boolean expressions__ to replace the `condition` placeholder and get a proper statement:

```python
value = 10

if value >= 5: 
	print("The value is greater than or equal to 5.")

print("I am executed if the condition if false or after the conditional block is itself executed")
```

In the above case, the `print` function call is only executed if the condition `value >= 5` returns `True`. If the condition returns `False`, then the block is simply skipped and the next line that has the same level of indentation as the `if` statement is read by the interpreter.

The `else` statement adds a bit more nuance to the mix by allowing us to provide an alternative code block that is only executed __if the `if` isn't__.

```python
value = 10

if value >= 5:
	print("The value is greater than or equal to 5.")
else:
	print("The value isn't greater than or equal to 5.)
```

In this case, the `if` and its condition are evaluated first, and if `value >= 5` returns `False`, the contents of the `else` block are executed.

With `value` as 10, the `if` block is chosen, and with anything lesser than 5, the `else` is chosen instead.

Having this `if`/`else` binary is extremely useful if you want one of two routines to run based on input. It allows you, for example, to identify when invalid input is given to a function:

```python
def meters_to_feet(meters):
	if meters < 0:
		print("A distance cannot be negative!")
		return 0
	else:
		#Convert the value
```

The `elif` statement allows you to insert other conditions to be checked if the previous ones aren't satisfied:

```python
value = 10

if value <= 2:
	print("The value is lesser than or equal to 2.")
elif value <= 4:
	print("The value is lesser than or equal to 4 (but greater than 2).")
elif value <= 6:
	print("The value is lesser than or equal to 6 (but greater than 4).")
else:
	print("The value is pretty big.")
```

The `elif` statements can be placed after an `if` and are semantically equivalent to __else if__. As such, they will only be evaluated if the previous `if`/`elif` failed to satisfy their condition.

Note that you can have as many `elif` statements as you want, but a chain such as the one above can only contain one `if` and one `else`. Moreover, only the `if` is truly mandatory; you could use `if`/`elif` without an `else`.

#### Try it out

_The structures presented in this subsection can be written out in the interpreter's console, but it's much easier if you write them out as scripts for batch execution._

- Reusing the code we've written for the __Celsius to Fahrenheit__ converter, add a small `if` statement that verifies whether the value give to the function is valid or not (you'll have a bit of research to do to see what is valid Celsius value).
- Write a small conditional structure that will print whether a number if even or not. In both cases, your structure should print a string that tells the user if the number if odd or even. _Hint: the `%` operator is a mathematical operation called __modulo__ and calculates the __remainder__ in the division of the two operands. For instance, 10 % 3 = 1 since 10 / 3 = 9 with a remainder of 1_

<a id="chainedconditions"></a>
### Chained conditions

The conditions we described in the first part of this section only featured one boolean expression, limiting how precise our conditions can be. Python however gives us keywords that will allow us to easily connect multiple expressions together to have more complex conditions at our disposal. We will call these keywords __boolean connectors__.

_For all of the keywords in the table below, `A` and `B` are boolean expressions that resolve to `True` or `False`._

|Keyword|Effect|
|---|---|
|`A and B`|Both conditions `A` and `B` must be true|
|`A or B`|Either `A` or `B` must be true|

These keywords can be combined to form complex expressions that will give depth to your conditional statements.

Note that expressions are always read left to right and that expressions within parentheses are evaluated first. Moreover, parentheses can be used to group expressions together:

```python
value = 10

"""
In this chained expression, either the first two must both be true, or the third must be in order for print() to be executed.
"""
if (value > 0 and value < 20) or value == 10:
	print("The value is either between 0-20 exclusive or is equal to 10")
```

### Try it out

Using the __interpreter's console__, try the following:

- Can you produce a __chained condition__ that will check if a certain value is positive and lesser than 100?
- Can you write out an expression that will only return true if a string contains both the phrase "The sky is blue" and the word "clouds"?

<a id="review1"></a>
### Review

- __Conditions__ are __boolean expressions__ that evaluate to `True` or `False`.
- The result of those expressions can be saved into variables, corresponding to the __boolean__ datatype.
- Conditions can use __numerical comparison operators__ that evaluate whether values are lesser, greater or equal to another.
- They can also use __collection comparison operators__ like `in` to evaluate whether an element is part of a collection. This applies to Strings.
- Boolean expressions can be __chained__ using `and` and `or` to build conditions that rely on multiple expressions.
- __Conditional statements__ use conditions to selectively execute code.
- Conditional statements are made of three different blocks: `if`, `elif` and `else`.
- The general model for conditional elements is:
```python
if condition:
	#Code that executes if condition is `True`
elif condition2:
	#Code that executes if condition is `False` and condition2 is `True`
else:
	#Code that executes is both of the above are `False`
```
- Only the `if` is mandatory for a conditional statement to be valid.
- An arbitrary number of `elif` can be added after an `if` to evaluate extra conditions.
- `else` will only be executed if none of the previous `if` and `elif` are executed.

<a id="loops"></a>
## 3. Loops

As we mentioned earlier, control flow can also be altered by having certain blocks of code be executed __repeatedly__, with or without changing the data being operated on. This comes handy if you have repetitive tasks or have a __collection of data__ to apply a specific set of operations on. In this case, __iterating__ over your collection (as we'll see later) or simply __looping__ over code will allow you to not copy/paste code in your scripts.

__Loops__ are split in two categories: __while__ and __for__ loops. The first relies on __conditions__, much like the __conditional blocks__ discussed earlier, while the second is used to __iterate over a range of values__.

<a id="whileloops"></a>
### While loops

__While loops__ are the simplest kind of loop in terms of semantics. Their general form is reminiscent of that of __conditional blocks__:

```python
while condition:
	#Code
```

Everything that we said about __conditions__ will apply to the `condition` placeholder here; the role of the __while loop__'s condition is to serve as an __exit condition__: as long as the condition is true, the loop will be repeated.

For example, a loop that would print all the integer values between 0 and 100 would look like this:

```python
number = 0

while number <= 100:
	print(number)

	number = number + 1
```

In this case, we replaced the placeholder condition by `number <= 100`, which is evaluated to `True` as long as `number` is below or equal to 100. Notice that at the end of the loop's code, we __increment__ the value of `number`. This is an extremely important step without which our loop would be __infinite__. 

For obvious reasons and in most cases, __infinite loops__ are undesirable. If the __exit condition__ of a loop is unreachable, the interpreter will continuously repeat the code enclosed in the __while__ block, stalling and forcing you to manually interrupt execution. Depending on what is being done in the block, an infinite loop can also crash your system as code that would request resources from the system would continuously do so until stopped.

#### Try it out

Now that we know that we can use loops to __repeat operations__ without have to explicitly duplicate code, can you use a __while loop__ to calculate the sum of all factors of 9 or 12 (exclusively, so a number that can be divided by 9 and 12 wouldn't be counted) under 10000?

<a id="scope"></a>
### A note on scope

As we introduce different block-like structures, it's important to mention __variable scope__. Variable scope refers to the area in which your variables live and are accessible by others. The default scope of variables is limited to the code block they are declared in and its children; this means that a variable declared inside a function is __local__ to that function and will cease to exist once the function's execution is done. Let's illustrate this by an example:

```python
def my_func(parameter):
	A = 0

	print(parameter)

my_func("Hello") #Prints "Hello")
print(A) #Erroneous code, A isn't defined OUTSIDE of the function my_func
```

This implies that a variable declared __outside__ of the function is accessible from within; it is however not recommended to do so because it's harder to exert control on __global variables__ (available to all, declared in the script outside of any other function or block), which leads to programs that are hard to debug and troubleshoot.

The concept of scope applies to any block-like construct such as __functions__, __conditional blocks__ and __loops__, even if they are nested within each other. For an example of a nested block structure, look below:

```python
def my_nested_function(number):
	if number > 0:
		#counter is defined in the if block; it is accessible within this block and its children.
		counter = 0

		while counter <= 10:
			#sentence is defined within the while block, if it accessible only within the while block and its children.
			#Note that we can use "number" here because we are within that variable's scope.
			#As an input parameter to the function, its scope is the entire function and its children.
			sentence = "The number is " + number
			print(sentence)
			#We can also use counter, because it was declared in the if block, and the while block is within the if block.
			counter = counter + 1
```

<a id="forloops"></a>
### For loops

__For loops__ introduce a different way of describing repetition. Instead of repeating as long as a condition is true, we will __walk through a collection of data__. The most basic collection we can muster is a simple range of numbers, which we can generate using the `range()` function.

The `range()` function will generate a range of numbers given boundaries, you can use it by providing a maximum, both a minimum and a maximum, or a minimum, a maximum and a step:

```python
#Prints [0, 1, 2, 3, 4]
print(range(5))

#Prints [5,6,7,8,9]
print(range(5,10))

#Prints [0,2,4,6,8]
print(range(0,10,2))
```

Note that when using `range()`, the maximum parameter is __excluded__ from the range, which is why we get `[0,1,2,3,4]` when executing `range(5)`.

Using that kind of collection, we can put together a `for` loop following model:

```python
for item in collection:
	#Code
```

In this snippet, the `collection` placeholder is replaced by our collection (eg. the `range()` function call) and the `item` placeholder is a variable that we can use __within__ the loop to access the element we are on in the collection:

```python
for number in range(10):
	print(number)
```

The above loop has `number` take all the values in `range(10)` (which is really `[0,1,2,3,4,5,6,7,8,9]`) sequentially. At each loop cycle, the value of `number` is printed to the screen. The result is then numbers 0-9 printed sequentially.

__Strings__ can also be used as collections using the same syntax; to iterate through all of the characters of a string, you can then simply type:

```python
my_string = "Hello, World!"

for character in my_string:
	print(character)
```

Later, we'll see that Python offers us __list__ and __dictionary__ structures that will also behave as collections and that will be traversable using the same kind of syntax.

#### Try it out

Looking back at the __Try it out__ segment of the __ While loops__ section, can you find a way to rewrite a solution to that problem using __for loops__ instead of __while loops__?

<a id="review2"></a>
### Review

- __Loops__ are another way to alter the flow of a script. By definition, loop blocks will have the interpreter __repeat__ a block of code a set number of times.
- Loop structures are split in two categories: __for loops__ and __while loops__.
- __While loops__ contain code that is repeated as long as the __exit condition__ is met. The condition follows the same format as the ones in the `if` blocks discussed earlier. A typical While loop looks like this:

```python
while condition:
	#Code
```
- __For loops__ repeat their operations __over a collection__. This allows for loops to "walk through" a collection of elements such as a __string__ or a __range__.
- You can create a range using the `range()` function. Its model is `range(min, max, step)`. The `min` and `max` define the range over which numbers will be generated. The `step` defines the jump between each value. An example usage of the `range()` function would be `range(0,10,1)` which would output `[0,1,2,3,4,5,6,7,8,9]`.
- Using this, you can build a __for loop__ using the model below:
```python
for item in collection:
	#code
```
- Just like __conditional blocks__, __loops__ are __block structures__. As such, the code contained in them is __indented__ and is subject to __scope__.
- __Scope__ represents the area over which variables are accessible. By default, the scope of a variable is __the block it's declared in and all its children__. This means that a variable created in an `if` block can be accessed anywhere within that `if` block.