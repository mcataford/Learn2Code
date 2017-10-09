# Introduction to Java programming

## Classes, Methods and Variables

In this section, we will be exposed to our first Java program, _Hello, World_. We will define a few keywords that will be omnipresent throughout the course and will produce our first original programs.

#### Table of contents

1. [Hello, World!](#helloworld)
- [Our first program](#firstprogram)
- [Some definitions](#definitions)
- [A useful template](#usefultemplate)
- [Review](#review1)
2. [Variables](#variables)
- [Data types](#datatypes)
- [Primitives](#primitives)
- [Operations on primitives](#operations1)
- [Reference types](#references)
- [Strings](#strings)
- [Operations on Strings](#operations-strings)
- [Declaring and initializing variables](#newvariables)
- [Review](#review2)

<a id="helloworld"></a>
### 1. Hello, World!

<a id="firstprogram"></a>
### Our first program

The first piece of code we'll be exposed to is the _Hello, World!_ program, which gained notoriety (history).

The main functionality of the _Hello, World!_ program is to "print," or display, the words "Hello, World!" on the screen. In the future, every time we'll refer to __printing__ a value, it will be implied that we mean to display it on the screen.

Here's the full _Hello, World!_ program in Java:

```java
public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello, World!");
	}
}
```

If you retype (or carefully copy and paste) this small bit of code in a file called _HelloWorld.java_ and then try to run it, you should see the "Hello, World!" output appear. 

Let's quickly discuss the different parts of the _Hello, World!_ program to get started with our learning of Java syntax.

<a id="definitions"></a>
#### A few definitions

If we read the program's code from top to bottom, the first element we encounter is the statement

```java
public class HelloWorld { ... }
```

This is a __class declaration__. In Java, __classes__ are the __outer container__ that encapsulate our code. We will later see that they have a much bigger role than being simple containers, but this will only become relevant when we discuss the concept of __programming objects__.

For the moment being, our classes obey a single rule: __the name of a class should be identical in case and content to the name of the file it is in!__ This means that the _Hello, World!_ program above should be placed in _HelloWorld.java_ since its class name is _HelloWorld_.

The keyword __public__ will be defined later as it becomes more relevant.

Once past the class, we see that we have another line full of keywords:

```java
public class HelloWorld {
	public static void main(String[] args) {...}
}
```

While we'll ignore most of the keywords for now, you should commit how this line looks to memory: this is an example of __method__. Methods in Java are equivalent to __functions__ in other programming languages. In broad terms, methods will accept input, perform some predetermined data processing that may or may not depend on its input, and produce some sort of output in the form of reusable data, printed data or influence on other aspects of the program. 

This method is a bit special. You should commit how it looks to memory, as we'll see it often: it's called the __main method__ and is the sole method that is automatically run when you run the file it is in. In the first part of the course, we'll be putting most of our code in the main method, until we learn about the process of creating our own methods.

The third major part of the _Hello, World!_ program is the innermost line:

```java
public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello, World!");
	}
}
```

`System.out.println("Hello, World!");` is a __statement__. Statements in Java can describe operations, variable assignments or, in this case, a __method call__ (i.e. the usage of a method). Statements occupy the most space in Java programs as they are where the "magic" happens.

In this specific case, we called this statement a __method call__ because it executes the `println` function, which displays text on the screen. A good indicator that something is a method call is the presence of a method name (in this case, `System.out.println`) and a set of parentheses. In fact, every time you see parentheses used in that manner, you should think about methods.

There are also other smaller details worth noting in the _Hello, World!_ program. First, the __class__ and __method__ definitions are following by __braces__. Those braces (`{` and `}`) come in couples and define where a block of code (which can be a class, a method or a control flow element) starts and ends. __Forgetting either of those braces where they are necessary will prevent our program from compiling!__

In the same vein, notice the semicolon at the end of the `System.out.println` statement. In Java, semicolons mark the end of every statement line (or of every line that isn't opening or closing a block). These semicolons help the compiler in the tough task of delimiting statements when it's reading your Java files.

One last essential element, not pictured in the standard _Hello, World!_, is documentation. Java allows programmers to annotate their code using __comments__ so that they can easily revisit their work later on, share their process with others without having to explain their train of thought each time and document issues or features that are in development.

Comments can be added anywhere in your code by using either the one-line comment or multiline comment syntax:

```java
//Two slashes followed by text will create a one-line comment.

/*
A slash followed by an asterisk will open a multiline comment.
An asterisk followed by a slash will close the last multiline comment that was opened.
Between those two markers, you can write any number of lines.
*/
```

Comments are _ignored_ by the compiler, so you can include as many as you need in your code. While learning, it's absolutely normal to end up with more comments than code; as you become more experienced, comments should become more scarce and focused on the non-obvious as not to crowd your code.

<a id="usefultemplate"></a>
### A useful template

The _Hello, World!_ program is not only a nice, simple Java program example, it's also a useful template. The manner in which a class is declared and in which the main method is written out is a formula that we will reuse until we learn more about how classes and methods work. We will hollow out the _Hello, World!_ program to produce the following model:

```java
public class FileName {
	public static void main(String[] args) {
		//Your code.
	}
}
```

As mentioned before, you should ensure that `FileName` is replaced by the actual name of the file in which the class is stored, such as in the _HelloWorld.java_ example.

<a id="review1"></a>
### Review

- The _Hello, World!_ program is a classic example used to demonstrate some features of many programming languages.
- In Java, it exposes us to __classes__, __methods__ and __statements__, as well as to a few syntactic quirks of the language.
- For now, __classes__ are containers for our programs; they will play a bigger role later.
- The name of a class must match the name of the file it's in (i.e. the _HelloWorld_ class should be in _HelloWorld.java_).
- __Methods__ are akin to __functions__ in other languages; they are input/output systems that allow some form of data processing to happen.
- The method present in the _Hello, World!_ program is called the __main method__ and is the one executed when you run your program.
- It will always be written the same way (i.e. `public static void main(String[] args) {...}`), so you can commit its definition to memory so you can reuse it.
- The innermost line of the _Hello, World!_ program (`System.out.println("Hello, world!");`) is called a __statement__.
- Statements can be variable assignments (as we'll see in the next section) or __method calls__ (the act of executing a method such as the __println__ method).
- The __println__ method (`System.out.println`) is a method we will use often; it "prints" (or displays) data on your screen as text.
- Every __code block__ (class or method definition and control flow elements) is surrounded by __braces__ (`{ ... }`).
- Every element that is not a code block, such as __statements__, must be followed by a __semicolon__ to signal to the compiler that the statement stops there.

<a id="variables"></a>
### 2. Variables

As we've seen in the _Hello, World!_ program, we can use the `System.out.println` method to display text on the screen. While this is practical to show the results of an operation on the screen, whatever we print on the screen cannot be salvaged and reused by our program: printing to the screen is a one-way road. This absence of __data persistence__ severely limits how complex our programs can be, since we have no way of keeping track of intermediate results or to handle large amounts of data without typing it out each time.

To solve this issue, we can use __variables__. In programming, variables are __symbolic placeholders__ for data. They allow you to store data in memory and label the location where it is stored so that you can retrieve it later.

Before we can fully appreciate how variables work, we need to define "data," as you can imagine that numbers are not necessarily stored the same way as sentences in memory.

<a id="datatypes"></a>
### Data types

Java classifies data into different __data types__. These categories define what the data is and how it can be used. We'll say that the data type of a piece of information defines which operations can be executed on it.

To begin exploring data types, we must first divide them into two groups: __primitives__ and __references__.

<a id="primitives"></a>
### Primitives

__Primitive__ data types refer to data that can be represented as a single numerical value. For example, `10` is a primitive because it can be represented as a single number; `"Hello, World!"`, on the other hand, is much more complex.

There exist about ten primitive data types in Java, but we will focus on four that we will primarily use:

|Shorthand|Meaning|Example|
|---|---|---|
|`int`|Integer|10, 2, 0, -1|
|`double`|Fractional number|10.1, 0.0, -1.2|
|`char`|Single character|a, b, c, =, (|
|`boolean`|True or false value, relevant to conditions|true, false|

The other primitive types can be found in details [here](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html).

The __shorthand__ defined in the first column is what we will use in code to identify the data type.

Note that we include `char` as a primitive data type: single characters can be represented as numbers using the [ASCII table](http://www.asciitable.com/), a translation table that associates each character with a number from 0-127. There exist a broader table, called the __extended ASCII table__ and which includes twice as many characters as the regular ASCII table, but it is not in use by Java.

<a id="operations1"></a>
### Operations on primitives

Being numerical data, any basic mathematical operation can be applied on primitives (at the exception of `boolean` variables, which we'll discuss later).

|Operator|Effect|
|---|---|
|+|Sum|
|-|Subtraction|
|*|Product|
|/|Division|

There are also a number of __binary operations__ that you can use on numbers to act on them as __binary numbers__ rather than __decimal numbers__. You can read more about them [here](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html).

<a id="references"></a>
### Reference types

__Reference types__ refer to data that is too large or complex to be expressed as a single number. In this case, the data will be stored in memory and we'll keep track of its __address__, or "reference."

Later on, we will see that we can make our own reference types, which we'll call __objects__. For the time being, we should look back as we've already been exposed to reference types earlier in this section.

<a id="strings"></a>
### Strings

__Strings__ refer to any __collection of characters__. They may be word fragments, random letters, whole sentences and even whole literary works. They are easily recognizable by the __double quotation marks__ that surround them.

The sole statement of our _Hello, World!_ program featured a String: "Hello, World!". We didn't store it in a variable, but if we had, we would've had to use a reference type to store the memory address at which the characters are stored.

<a id="operations-strings"></a>
### Operations on Strings

There are no "globally defined" operations on reference types like there are on primitives. Instead, we will look at operation on single reference types.

Of all the operators we've seen earlier, a single one is applicable to Strings: the summation. Of course, the idea of the summation doesn't make sense when dealing with characters and words -- which is why we instead call it __concatenation__.

__Concatenation__ is the act of "gluing" several Strings together to make a longer String. It is represented by the `+` operator and is executed as long as the left-hand side operand is a String.

For example, `"Hello " + "World!"` would merge the two separate Strings `"Hello "` and `"World!"` into a bigger `"Hello World!"` String. 

Concatenation also works if the right-hand side operand is not a String but a primitive instead. In this case, the primitive will be converted to a String and then concatenated as done previously. Moreover, you can chain concatenation operations and make larger Strings: `"My name is " + "Marc" + " and I am " + 27 + " years old."` would be perfectly correct and would result in the longer "`My name is Marc and I am 27 years old."` String.

### Try it out

Now that you know about data types and the operations permitted on them, try them out using the _Hello, World!_ template we produced earlier.

Since the call to `System.out.println` will print whatever we give it as input to the screen, try out __concatenation__ and other mathematical operations to see what happens!

You can also add more than one instance of the `System.out.println` statement if you want to print multiple elements sequentially.

<a id="newvariables"></a>
### Declaring and initializing variables

Creating variables is the combination of two acts: __declaring__ and __initializing__.

__Declaring__ refers to the association of a datatype and a variable name. It creates the variable as a container and makes it available for use. __Note that once a variable is declared, the name chosen for it is attached with the datatype you used to declare it!__

You can declare a variable by typing `datatype variable_name`. In this template, `datatype` would be replaced by one of the shorthand codes mentioned earlier and `variable_name`, by your chosen variable name.

Once a variable declared, it __exists__, but it is not usable yet! For safety reasons, uninitialized variables cannot be used since their content is, by default, "undefined." 

To __initialize__ a variable, we can simply use the __assignment operator__ `=` and associated a value that matches the variable's datatype.

```java
//datatype variable_name = value;

int my_age = 27;
double my_height = 180.1;
String my_name = "Marc";
char first_initial = 'M';
```

The above are all examples of __declaration__ directly followed by __initialization__ of variables. Note that the __name__ of the variable must stand as a single "block" (no spaces allowed). It is customary to limit variable names to alphanumerical characters and underscores.

Once declared and initialized, a variable can be used in lieu of literal values in operations or method calls. For example:

```java
//Without variables
System.out.println("Hello, World!");

//With variables
String helloworld = "Hello, World!";
System.out.println(helloworld);
```

In both cases, the result is exactly the same since the variable is just a placeholder for its content.

### Try it out

By declaring variables of the appropriate type, concatenation and a `System.out.println` statement, can you transform the _Hello, World!_ program so that it prints a sentence or two introducing you by writing our your name, your age, your height and any other relevant information?

The output of your program should look something like `Hi, my name is Marc, I am 27 years old, I am 180.1cm high and my favourite letter is C.

<a id="review-2"></a>
### Review

- Before creating a variable, you need to choose a __datatype__, a __name__ and an __initial value__.
- The __datatype__ can be any of the shorthand codes describing primitives (`int`, `double`, `char`, `boolean`, etc) or reference types (`String`).
- The __variable name__ should be composed of alphanumerical characters and underscores. No spaces allowed.
- Once you have those, you can __declare__ a variable by typing the following statement: `datatype variable_name;`.
- You should also __initialize__ your variables by using the __assignment operator__ `=` along with a value that is appropriate for the datatype you chose: `variable_name = value;`.
- You can __declare__ and __initialize__ a variable at the same time by combining both statements: `datatype variable_name = value;`. For an integer, this could look like `int my_age = 27;`.
- Once declared, your variable can be used as a symbolic replacement for the data it contains.
- You can __operate__ on numbers using any basic mathematical operator (`+`, `-`, `*`, `/`).
- You can also use the __concatenation operator__ `+` on __Strings__ to merge shorter Strings into longer ones.