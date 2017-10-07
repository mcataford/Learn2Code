# Introduction to Python

## Python basics

#### Table of contents

1. [Executing code](#executing-code)
- [Using the Python interpreter console](#interpreter-console)
- [Executing whole scripts at once](#batch-execution)
2. [Variables](#variables)
- [Soft typing](#soft-typing)
- [Variable naming](#variable-naming)
- [Reusing variables](#variable-reuse)
- [Data types](#data-types)
- [Operations on strings](#operations-strings)
3. [Functions](#functions)
- [The `return` statement](#return-statement)
- [Nesting functions](#nesting-functions)
4. [Review, summary & exercises](#review-and-summary)

<a id="executing-code"></a>
## 1. Executing code

<a id="interpreter-console"></a>
### Using the Python interpreter console

When we introduced the __Python interpreter__, we mentioned that it had the power to read our programs line by line, executing them as it goes. Of course, this is usually done on a completed program contained in one or several files; however, the interpreter also allows us to _interactively_ run commands.

This "interactive mode" is handy when it comes to testing: testing a handful of lines may be faster if you don't have to set up the rest of the program. Moreover, being able to manually enter statements to be executed is a great way to explore what Python has to offer.

To open the interpreter's console, either open __IDLE__ or a command prompt/terminal window in which you run the `py` (or `python3`) command.

![The interpreter's console](repl.png)

In here, you can evaluate simple math or Python statements. For example:

```python
>>> 3 + 5
8

>>> 2 ** 32
4294967296
```

All the simple mathematical operators can be used in this command-line interface (and in Python programming in general):

|Operator(s)|Significance|
|---|---|
|A+B,A-B,A/B,A*B|Add, subtract, divide and multiply|
|A**B|A to the power of B|
|A << B|(Binary)  A shifted left B times (or A * (2 ** B))|
|A >> B|(Binary) A shifted right B times (or A / (2 ** B))|
|A & B|Binary operator A AND B|
|A \| B|Binary operator A OR B|
|A ^ B|Binary operator A XOR B|
|~A|Binary operator NOT A|

Using these, you can implement some pretty complicated mathematical processes. 

#### Binary operators

While you may be familiar with the classical decimal operators, the __binary operators__ are seldom played with in classrooms before you start talking about computer science or logic.

The basis for these operators is the __binary representation__ of numbers, which is based on 1s and 0s. In the binary representation of a number, each digit represents a power of 2, the rightmost being 2^0 (or 1).

Here are some decimal numbers and their binary equivalents:

|Decimal|Binary|
|---|---|
|0|0|
|2|10|
|5|101|

If you read from the right, you can see that 2 = 0 * 2^0 + 1 * 2^1. Similarly, 5 = 1 * 2^0 + 0 * 2^1 + 1 * 2^2. For the needs of understanding the operators, we do not have to be too familiar with how binary numbers are interpreted, but if you'd like to know more, you can read more about it [here](https://www.mathsisfun.com/binary-number-system.html).

Binary operators such as the ones presented earlier operate on single __bits__, which are the digits of the binary representation of a number. The left and right shift operators will either multiply or divide by a power of two, as they are _pushing_ bits in one direction of the other. As such, if 5 is 101, then `5 << 1` would shift everything to the right, appending zeroes to the new position: `5 << 1 = "101" << 1 = "1010" = 10`. Similarly, `5 >> 1 = "101" >> 1 = "10" = 2`. Since binary operations represent _integer operations_, we are really dividing 5 by 2 and discarding the remainder.

The AND, OR, XOR and NOT operators are simpler:

|Operator|Effect|Example|
|---|---|---|
|&|The result only has 1s where both operands had 1s.|101 & 011 = 001|
|\||The result only has 1s where either operands had 1s.|101 \| 011 = 111|
|~|The result only has 1s where the operand had 0s|~101 = 010|
|^|The result only has 1s where one operand or the other had 1s, but not both.|101 ^ 110 = 010|

These operators can be handy if you are doing discrete mathematics (using integers only), if you are implementing operations that can _afford_ to do expensive operations all the time (more on this later) and if you are looking at patterns in numbers.

<a id="batch-execution"></a>
### Executing whole scripts at once

While we can use the console to execute single commands, it's not that handy for longer sequences -- especially since you'd have to re-enter all the statements one at a time if you wanted to execute your code a second time!

To solve this issue, we can build __scripts__. Python scripts are collections of statements that are stored in _.py_ files and that you can give to the interpreter all at once. The interpreter will then execute the whole script automatically without having you enter statements manually.

Any statement that you can type in the Python interpreter console can be put in a file for batch execution.

Create a file called `my_first_script.py` and write out a sequence of mathematical statements. Notice that if you open this with IDLE, you will be given the opportunity to __run__ the file.

There are a few differences between using the console and executing files, the most important of which is that the console __automatically prints output__. When executing files, you will have to manually "print" values. You can do so by using the `print()` function (our first function!).

For example:

```python
print(1+2+3+4+5)
```

Executing this through IDLE (or through your command line, if you type `py <filename>` or `python3 <filename>`) will print the result of the operation contained within the print statement's parentheses.

#### Commenting

As you start writing longer and longer scripts, adding __comments__ to your code is going to become crucial. Comments are not only meant as notes on how code works, it's also documentation to help others read and understand your programs, to facilitate issue tracking and to insert development notes for future features.

Comments are ignored by the interpreter, and can be easily inserted by using one of the two following ways:

```python
# Single line comments can be inserted with a hashbang. These should be small and need to stand on a single line.

"""
You can insert larger comments by using three double quotation marks to open and to close a paragraph.
Within the two sets of quotation marks, you can write freely and use as many lines as you wish.
"""
```

It's always good to insert comments as you are planning and implementing your ideas, this way you can easily see logical mistakes or design flaws early on.

#### Review

Open up the interpreter console and try to find the following:

- The Fahrenheit equivalent of 25 degrees Celsius. (You can read about the sequence of operations to achieve the conversion [here];(https://www.mathsisfun.com/temperature-conversion.html))
- The __first four bits__ (i.e. rightmost) of 1543;
- The number formed by the bits that 1543 and 670 have in common.

Can you do the same, but by executing a whole file at once? Try solving each all of the above problems in a single file so that you can print the results together.

<a id="variables"></a>
## 2. Variables

As you saw when playing with the interpreter, while you can use your computer to do math right now, the results are ephemeral and do not persist between entries. Of course, you can chain operations to compute complex results (such as in the temperature conversion exercise above), but it has limits that easily reached.

To solve the problem of having results persist between entries, we can use __variables__. Variables in programming are just like variables in algebra: they are vessels that can hold data. While mathematical variables can only contain numbers or sets of numbers, programming variables act as __symbolic replacement__ for any piece of data, however big it may be. As we delve deeper into Python, we'll see how big the contents of variables can get.

<a id="soft-typing"></a>
### Soft typing

Python is a __soft typed__ language: its variables don't have an assigned type, and the type of a single variable can change during its lifetime. This is in stark contrast with Java, where you are required to declare a variable's type when creating it and then stick to that type until the variable is no longer needed.

Not having to choose a type for our variables allows us to create new ones using two pieces of information: a (unique) name and a piece of data that will act as initial value. We can then __declare and initialize__ a variable by typing `variable_name = value`.

<a id="variable-naming"></a>
### Variable names

Variables can have any name that is alphanumerical and that doesn't start with a number. Moreover, you can use underscores as needed.

Some [conventions](https://www.python.org/dev/peps/pep-0008/#naming-conventions) exist to help you in naming your variables properly. You can however diverge from those rules as much as you want, as long as you are consistent. 

In this course, we'll use the following convention:

- Variable names will be __lowercase__;
- Words will be separated by __underscores__;
- Names should not be longer than 30 characters for conciseness.

No matter the convention used, common sense applies: __names should be descriptive__. Naming variables `x` or `i` might make sense if you are writing fast and are not planning on rereading your code ever, but for any code that will need maintenance in the future, you can save time by giving proper descriptive names to your variables. This will not only make rereading your code easier in the long run, it will also help collaborators who would like to help you out by fixing bugs or extending your code, but who would rather avoid spending hours figuring out which of `x1, x2, x3, x4, x5 ...` contains the data they are looking for.

<a id="variable-reuse"></a>
### Reusing variables

Since Python variables do not have a fixed type, you can __reuse__ a variable at will. If the data stored in the variable is different than the previous content, the variable will be transformed.

<a id="data-types"></a>
### Data types

Since you do not define the type of your variables, you will need to convey that information through the __format__ of the data so that the interpreter can guess. Here is the format of the first handful of data types we will be working with:

|Data type|Meaning|Example|
|---|---|---|
|Integer|Any integer, positive or negative|`my_age = 27`|
|Float|Any number, rational or not, positive or negative|`my_height = 180.1`|
|String|Any collection of characters, usually representing words or sentences|`my_message = "Hello, world!"`|
|Boolean|True or false values, mostly used in conditions|`is_programming_cool = True`|

We'll add to this list as we get deeper into programming, but for now, know that any plain number, such as `27` or `180.1` will be interpreted as a numerical value, any collection of characters surrounded by single or double quotation marks will be considered a string, and any of the two values `True` or `False` (notice the uppercase first letter) will be considered a boolean.

<a id="operations-strings"></a>
### Operations on strings

Now that we know about different types of data that can be stored in variables, it's time to revisit what we said about __operators__. If you experimented with operations that involved numerical values and strings (or even boolean) values, you probably noticed that errors arise if types are mismatched when an operator is applied.

All the operators we've discussed in the previous sections work perfectly well when numerical types are involved, but if we consider strings, most operations do not make sense. However, one operation keeps its meaning: addition.

Using the `+` operation on strings __concatenates__ them, effectively gluing them together into a bigger string. Of course, we can combine strings or string variables directly:

```python
hello = "Hello"
world = " World"
print(hello + world) #prints "Hello World"
```

Of course, we might want to use concatenation to insert other values in our strings, such as numbers. To be able to achieve this, we need to __cast__ (or convert) values into strings. This can be achieved with the help of the `str()` function. `str()` will convert the values it is given into a string, allowing you to take numerical values or numerical variables and inserting them in strings:

```python
print("I am " + str(27) + " years old.") #prints "I am 27 years old."
```

If you skip on using `str()` to convert the numerical value `27` into a string, a `TypeError` will appear informing you that the conversion needs to be explicitly written out.

Note that type conversions also work the other way: `int()` and `float()` will convert a non-integer or non-float value into an integer or a float. This way, you can convert strings that represent numbers into actual numbers to be able to operate on them.

### Summary

- The __Python interpreter console__ can help you executing commands directly;
- You can create variables by choosing a name (see section 2.2) and an initial value (see section 2.4), and type `variable_name = value`;
- Variables can be __reused__ by using the assignment operator `=` with a variable name that already exists;
- You do not have to choose a variable type yourself, the initial value (and any subsequent values) will let Python know how your variable should be interpeted.

### Review

Now that we can create variables, let's try to combine them with what we know of __operators__!

- (Programming) Create a few variables containing different kinds of data and try using operators on them.
- (Short answer) What happens if you add __integer__ and __float__ variables together?

<a id="functions"></a>
## 3. Functions

Earlier, we said that being able to write __scripts__ helped us make our code easy to execute more than once. What if we wanted to reuse _smaller_ parts of what we've written?

__Functions__ will help us segmenting our code into parts that can be reused within the same script. If we define functions that implement processes that might be repeated (such as the conversion from Celsius to Fahrenheit), then we can convert values on the fly without having to write the code for it again.

In programming, functions are __input/output systems__. They allow programmers to build modules that can be given some input data and that can process it before giving it back.

The general form for defining a function is the following:

```python
def function_name(input1, input2, ...):
	#Code
```

A few things to note:
- The content of a function is __indented__ with tabs or spaces;
- The `def` keyword introduces the function definition;
- The parentheses next to the function name contain the __function's input parameters__. These values are placeholders that represent data provided when the function is used. They can be used as variables __within the function only__;
- You can use any number of input parameters, represented as a __comma-separated list__.

A more complete function example would be the following, which implements the conversion from Celsius to Fahrenheit:

```python
def celsius_to_fahrenheit(celsius):
	print(celsius * 9/5 + 32)
```  

In this example, the `celsius_to_fahrenheit` function takes in a single parameter, `celsius`, which is then converted to Fahrenheit and printed to the screen.

Once a function is defined, it can be __called__ using its name:

```python
celsius_to_fahrenheit(0) #Prints 32
celsius_to_fahrenheit(100) #Prints 212
```

Every time that a function is called, the interpreter jumps to its definition and uses the values passed to it (in this case `0` and `100`) as values for its input parameters. It then executes all the statements contained in the function's body, and once it's done, it goes back to where it was and continues execution.

Keep in mind that a function definition is just that: a definition. It isn't executed by the interpreter until the function is called.

#### Review

- (Short answer) What is the keyword used to define functions?
- (True/False) You can only have one input parameter to each function.
- (True/False) A function is only executed when called.
- (True/False) Indentation only adds decoration to a function's code.
- (Programming) Write a function that accepts __five input parameters__ representing assignment grades on a 100; your function should compute the final grade of a student that obtained the given grades if the first two are worth 15% of the grade, the third, 20% and the last two, 25%. You should print the resulting grade. __Test this with multiple sets of grades!__
- (Programming) We've done Celsius to Fahrenheit conversion earlier, write a function that implements the opposite!

<a id="return-statement"></a>
### The return statement

In our previous example, we used `print` to display the output of our function to the screen. This is handy if you want to see what the result is, but you can't __reuse__ the product of the function.

The `return` keyword will solve that problem: it allows the function to give back data after it's done. If a function uses the `return` keyword, you can capture its output in a variable:

```python
def celsius_to_fahrenheit(celsius):
	return celsius * 9/5 + 32

fahrenheit = celsius_to_fahrenheit(0)

print(fahrenheit)
```

In the snippet above, we call `celsius_to_fahrenheit`, which executes the function just above it. When the interpreter hits the `return` statement, it saves the result, jumps back to where it was and releases the data, which is stored in `fahrenheit`. The act of executing the `return` statement and jumping back is also called "returning to the caller," since we go back to the position where the function was called with data to store.

#### Review

- (Short answer) What does __returning to the caller__ mean?
- (True/False) Using the `return` keyword allows you to save the output of a function after the function is done executing.
- 
- (Programming) Revisit the function you have written in the previous _Review_ segment and adjust them so that they __return__ values instead of printing them. You should be able to save their return value in a variable, and then use `print()` on this variable to display it to the screen.

<a id="nesting-functions"></a>
### Nesting functions

Functions can also be __nested__; you can use functions within functions. Let us define some simple functions:

```python
def double_the_value(number):
	return number * 2

def triple_the_value(number):
	return number * 3

def multiply_by_six(number):
	double = double_the_value(number)
	times_six = triple_the_value(double)

	return times_six

multiplied_by_six = multiply_by_six(2)
print(multiplied_by_six) #Prints 12
```

In the above snippet, we use `double_the_value` and `triple_the_value` inside of `multiply_by_six`. As the code gets executed, the interpreter jumps from one point to the other to execute the functions, then comes back to where it was and carries on. This process happens until the end of the program is reached.

Note that we use the `return` statement in each of these functions: it allows the result of one function to be used by the next. Also note that for conciseness, we could opt to write the last two lines as `print(multiply_by_six(2))`. This shorter form produces the same output as its longer form; the only difference is readability.

#### Review

- (Short answer) Can you explain how the `return` statement makes nesting functions possible?

## 4. Review & Summary

With the basics of __variables__ and __functions__ in hand, we've now got the tools to build simple programs. Of course, we'll need a few more blocks to be able to put together truly useful software. Here is a quick outline of what we've seen in this section:

- We can __create variables__ by typing `variable_name = initial_value`;
- You can use classical mathematical operators on numerical values and `+` on strings to __concatenate__ them;
- You can convert values from type to type using `str()`, `float()` and `int()`;
- A hashbang `#` or two sets of three double quotation marks will create a __comment__ that is ignored by the interpreter but that improves readability immensely;
- __Functions__ can be defined using the `def` keyword and have the general form:

```python
def my_function(parameter):
	#Code
```

- The `return` keyword allows you to capture the output of your functions so that you can use the results of one operation for further purpose.