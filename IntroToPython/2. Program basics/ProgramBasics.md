# Introduction to Python

## Python basics

#### Table of contents

1. Executing code
2. Variables
3. Functions
4. Review

## 1. Executing code

### 1.1 Using the Python interpreter console

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

### 1.2 Executing whole scripts at once

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

### Try it out

Open up the interpreter console and try to find the following:

- The Fahrenheit equivalent of 25 degrees Celsius. (You can read about the sequence of operations to achieve the conversion [here];(https://www.mathsisfun.com/temperature-conversion.html))
- The __first four bits__ (i.e. rightmost) of 1543;
- The number formed by the bits that 1543 and 670 have in common.

Can you do the same, but by executing a whole file at once? Try solving each all of the above problems in a single file so that you can print the results together.

## 2. Variables

As you saw when playing with the interpreter, while you can use your computer to do math right now, the results are ephemeral and do not persist between entries. Of course, you can chain operations to compute complex results (such as in the temperature conversion exercise above), but it has limits that easily reached.

To solve the problem of having results persist between entries, we can use __variables__. Variables in programming are just like variables in algebra: they are vessels that can hold data. While mathematical variables can only contain numbers or sets of numbers, programming variables act as __symbolic replacement__ for any piece of data, however big it may be. As we delve deeper into Python, we'll see how big the contents of variables can get.

### 2.1 Soft typing

Python is a __soft typed__ language: its variables don't have an assigned type, and the type of a single variable can change during its lifetime. This is in stark contrast with Java, where you are required to declare a variable's type when creating it and then stick to that type until the variable is no longer needed.

Not having to choose a type for our variables allows us to create new ones using two pieces of information: a (unique) name and a piece of data that will act as initial value. We can then __declare and initialize__ a variable by typing `variable_name = value`.

### 2.2 Variable names

Variables can have any name that is alphanumerical and that doesn't start with a number. Moreover, you can use underscores as needed.

Some [conventions](https://www.python.org/dev/peps/pep-0008/#naming-conventions) exist to help you in naming your variables properly. You can however diverge from those rules as much as you want, as long as you are consistent. 

In this course, we'll use the following convention:

- Variable names will be __lowercase__;
- Words will be separated by __underscores__;
- Names should not be longer than 30 characters for conciseness.

No matter the convention used, common sense applies: __names should be descriptive__. Naming variables `x` or `i` might make sense if you are writing fast and are not planning on rereading your code ever, but for any code that will need maintenance in the future, you can save time by giving proper descriptive names to your variables. This will not only make rereading your code easier in the long run, it will also help collaborators who would like to help you out by fixing bugs or extending your code, but who would rather avoid spending hours figuring out which of `x1, x2, x3, x4, x5 ...` contains the data they are looking for.

### 2.3 Reusing variables

Since Python variables do not have a fixed type, you can __reuse__ a variable at will. If the data stored in the variable is different than the previous content, the variable will be transformed.

### 2.4 Data types

Since you do not define the type of your variables, you will need to convey that information through the __format__ of the data so that the interpreter can guess. Here is the format of the first handful of data types we will be working with:

|Data type|Meaning|Example|
|---|---|---|
|Integer|Any integer, positive or negative|`my_age = 27`|
|Float|Any number, rational or not, positive or negative|`my_height = 180.1`|
|String|Any collection of characters, usually representing words or sentences|`my_message = "Hello, world!"`|
|Boolean|True or false values, mostly used in conditions|`is_programming_cool = True`|

We'll add to this list as we get deeper into programming, but for now, know that any plain number, such as `27` or `180.1` will be interpreted as a numerical value, any collection of characters surrounded by single or double quotation marks will be considered a string, and any of the two values `True` or `False` (notice the uppercase first letter) will be considered a boolean.

### 2.5 Summary

- The __Python interpreter console__ can help you executing commands directly;
- You can create variables by choosing a name (see section 2.2) and an initial value (see section 2.4), and type `variable_name = value`;
- Variables can be __reused__ by using the assignment operator `=` with a variable name that already exists;
- You do not have to choose a variable type yourself, the initial value (and any subsequent values) will let Python know how your variable should be interpeted.

### Try it out

Now that we can create variables, let's try to combine them with what we know of __operators__!

- Create a few variables containing different kinds of data and try using operators on them.
- What happens if you add __integer__ and __float__ variables together?

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

#### The return statement

In our previous example, we used `print` to display the output of our function to the screen. This is handy if you want to see what the result is, but you can't __reuse__ the product of the function.

The `return` keyword will solve that problem: it allows the function to give back data after it's done. If a function uses the `return` keyword, you can capture its output in a variable:

```python

def celsius_to_fahrenheit(celsius):
	return celsius * 9/5 + 32

fahrenheit = celsius_to_fahrenheit(0)

print(fahrenheit)
```

In the snippet above, we call `celsius_to_fahrenheit`, which executes the function just above it. When the interpreter hits the `return` statement, it saves the result, jumps back to where it was and releases the data, which is stored in `fahrenheit`. The act of executing the `return` statement and jumping back is also called "returning to the caller," since we go back to the position where the function was called with data to store.



