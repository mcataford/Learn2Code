# Introduction to Web development

## Javascript

So far, we have been discussed __static__ elements. __HTML__ and __CSS__ allow for very little interactivity (past the pseudoselectors such as `:hover` and basic `keyframes` in CSS, of course). This is because HTML and CSS code is interpreted by the browser and used to generate the page you see, but it isn't actively being reinterpreted or executed. To add interactivity to our web pages, we will need to look at code that can __run__ independently of the page: enter __Javascript__.

Javascript is a simple programming language that __runs in the browser__ (and outside, if you use frameworks like [NodeJS](https://nodejs.org/en/)). As such, it is in perfect position for interactivity: since it is a proper programming language, it can listen to input and produce output; look for user actions and produce results.

#### Table of contents

1. [Basic Javascript](#js)
- [Including scripts in webpages](#js_embed)
- [Producing output in the console](#js_console)
- [Variables and operations](#js_vars_ops)
- [Basic page modification](#js_pageedit)
2. [Javascript programming](#more_js)
- [Conditional statements](#js_cond)
- [Loops](#js_loops)
- [Arrays](#js_arrays)

<a id="js"></a>
## 1. Basic Javascript

In the first part of this section, we will look at basic Javascript concepts. Since Javascript is a proper programming language, we need to understand its syntax in order to make __scripts__ that will produce the output we desire.

<a id="js_embed"></a>
### Including scripts in webpages

Before we can play with Javascript, we need a way of including Javascript code on our pages. Much like how we embedded CSS using the `<style>` tag, Javascript can be embedded in any HTML page using a special tag: `<script>`. The `<script>` tag can be used to insert a snippet of code in our pages which will be executed __when the page loads__.

In any page, you can either use the `<script>` tags to contain Javascript code, or you can use the tag's `src` attribute to specify a path to a file you'd like to include in your page. The paths leading to files in `<script>` tags will use the same convention as the ones in the `<link>` tag's `href`:

```html
<html>
	<head>
		<!-- Embed a block of JS -->
		<script>
			//Code ...
		</script>

		<!-- Include a file containing JS -->
		<script src="path/to/file.js"></script>
	</head>

	<!-- Rest of page -->
</html>
```

For clarity, we will assume that all the code mentioned here is already included in a page so that we can focus on Javascript syntax.

<a id="js_console"></a>
### Producing output in the console

Until we produce code that can interact with our page, we will also need a way of producing an output we can inspect visually. This is where the __code inspector__ feature of your browser comes in.

Any browser's code inspector contains a __Console__ or __Web console__ tab that allows you to see the output of the Javascript code running on your page. In Firefox, this tab is visible next to the __Inspector__ tab we've used previously to look at how pages were structured:

![The Console tab](assets/console.PNG)

To produce output in this tab, we will use the `console.log()` function. We will discuss it at length later, but `console.log` will output its results directly to the console tab of your browser; for example, `console.log(6)` would output the value `6` to the console tab. 

<a id="js_vars_ops"></a>
### Variables and operations

The primary function of a programming language is to allow us to manipulate data. To manipulate data, we need to store it somewhere; __variables__ will allow us to do this. Javascript variables will allow you to __store__ any element of data and label it so that you can use it later.

For now, we will distinguish two kinds of data: numerical data and strings.

__Numerical data__ represents any number, integral or not, and is written out directly: `1`, `10.1`, `-56.32`. On them, we can apply any mathematical operation.

__Strings__, on the other end, can be any collection of characters enclosed by single or double quotes. For example, `"Hello, World" and 'Hi!'` are both strings.

Either of these are can be stored in a variable. To do so, you can use the `var` keyword:

```javascript
var my_variable = 1821;
var my_name = "Marc";
```

Notice a few things:

- The `var` keyword announces that we are creating a __variable__ with the name `my_variable`. A variable can only be created __once__!
- The operator `=`, called the __assignment operator__, allows us to assign a value to a variable.
- Any Javascript statement can be ended by an optional semi-colon for clarity.

Once a variable is created, you can use it by referring to its name. Depending on which type of data you are storing, usual operators such as `+`, `-`, `*` and `/` apply:

```javascript
var first = 1;
var second = 2;
var third = 10;

//Adds all three variables' values
var sum = first + second + third; 

//Divides the third by the second
var quotient = third / second;

//Subtracts the first from the second
var diff = second - first;

//Multiplies the first by the second
var product = first * second;
```

Basic arithmetic will apply to any numerical value stored in a variable, and precision will adjust automatically: an expression such as `10 / 2` will produce an integer, while `10 / 3` will produce a floating point value without needing you to intervene.

While most operations are not defined for strings, `+` can be used to __concatenate__ strings together; combining smaller strings (or strings and numerical values) into longer strings:

```javascript
var my_name = "Marc";
var my_age = 27;
var my_sentence = "My name is " + my_name + " and I am " + my_age + ".";
```

<hr>

#### Try it out!

Build a small webpage stub containing a `<script>` tag which links to an external JS file; in this file, declare a handful of variables and play with `console.log()` to print the results of operations in the console. __Make sure that you can use your browser to inspect and see the output of your Javascript code!__

<hr>

<a id="js_pageedit"></a>
### Basic page modification

To make our variable manipulations, happening behind the scenes, truly interesting, we need a way to connect our Javascript code to the visual representation of the page so that the output of our programs is no longer tucked away in the code inspector.

In the interest of simplicity, we will use jQuery to manipulate our page; jQuery is a Javascript framework that simplifies interactions between our code and what appears on the page. In be able to use it, we need to add a `<script>` tag that includes it at the top of our page, before any scripts that would use jQuery to manipulate the page:

```html
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
```

This tag gets the jQuery library from a _content distribution network__, which we discussed in the very first lesson. Once included in your page, you can use any of [jQuery's functions](http://api.jquery.com/).

In our case, we will start off by manipulating the page, and before we can do so, we need to __access__ page elements. The jQuery convention to do so is as follows:

```javascript
$(css selector)
```

Here, `css selector` can be replaced by any __string__ containing a CSS select just like the selectors we used in our stylesheets!

For example, given the following elements:

```html
<div class="my_block">
	<p id="first_paragraph">Hello, world!</p>
	<p id="second_paragraph">Much less important text! :(</p>
</div>
```

We can select the `<div>` element by using `$(".my_block")`, the first paragraph with `$("#first_paragraph")` and all `<p>` tags with `$("p")`.

Once selected, you can directly edit these elements on the page using the following functions:

|Function|Effect|Example|
|---|---|---|
|`.text(str)`|Replaces the __text__ inside a tag.|`$("#first_paragraph").text("Text!");`|
|`.html(str)`|Replaces the __html__ inside a tag, allowing you to insert more tags inside.|`$(".my_block").html("<h1>Hey!</h1>");`|
|`.append(str|element)`|Adds the text/html or jQuery element at the end of the specified tag.|`$(".my_block").append("<h1>Hey!</h1>");`|
|`.prepend(str|element)`|Adds the text/html or jQuery element at the beginning of the specified tag.|`$(".my_block").append("<h1>Hey!</h1>");`|
|`.remove()`|Removes the element from the page.|`$("#second_paragraph").remove()`|

More of these functions exist and can be found in the reference material linked earlier; however, these are the ones we will use the most in our practice.

Additionally, you can __create__ new tags and insert them on your page using the `append` and `prepend` functions above by __storing a jQuery selection statement in a variable__:

```javascript
//This tag only exists in our variable, but not yet on the page!
var my_new_tag = $("<h1>");

//This adds the new tag to the page by appending it to the <body> tag.
$("body").append(my_new_tag);
```

<hr>

#### Try it out!

Using the __Web console__ of your browser (accessed through the _Inspect element_ menu), let's manipulate [Google](http://www.google.ca)'s home page.

- The Google logo has __id__ `hplogo`, can you use jQuery to remove it from the page?
- Can you add a a sentence anywhere on the page while preserving the content that is already there?
- Can you replace all the page's content by a __heading tag__ of your choice (use the `.html()` function)?
- Try adding a tag using `.text()`, what happens then?
- Can you use the console to create a tag (hint: read the last part of the last section about creating new tags inside variables) and insert it in the page?

<hr>

<a id="more_js"></a>
## 2. Javascript programming

Now that we have introduced __Javascript__ and how it runs in your browser, __variables__ and their associated operations, and how __jQuery__ can be used to modify the content of the page in real-time, it's time we delve further in the built-in features of the Javascript language and how we can use them in conjunction with the functions defined by jQuery.

Our survey of Javascript will cover __control flow elements__ such as __conditional statements__ and __loops__, as well as data structures such as __arrays__ and __objects__.

<hr>

#### Control flow?

__Control flow elements__ are blocks or statements that affect the way your scripts are executed. Normally, our scripts are executed from top to bottom, linearly. However, the Javascript language gives us tools to alter the flow of our scripts and __selectively execute__ certain parts, or __repeat__ others. Whenever we talk about __control flow elements__, we will talk about elements that will break that "linearity." 

<hr>

<a id="js_cond"></a>
### Conditional statements

__Conditional statements__ are blocks that will __selectively__ execute their contents based on the evaluation of a set of __conditions__. Using those blocks, we will be able to choose when certain parts of our scripts execute; leading to code that is adaptable to user input or two other circumstances related to the browser and the page's rendering.

__Conditions__ are __boolean__ statements that are equivalent to `true` or `false`; as such, they encapsulate all __comparisons__ and other functions that produce boolean values.

The simplest form of __comparison__, and the one we will use the most often, is numerical in nature; you can use any numerical comparison operators you've learned in algebra to build these conditions:

|Operator|Meaning|
|---|---|
|`A == B`|A "is equal to" B|
|`A != B`|A "is not equal to" B|
|`A > B`|A "is greater than" B|
|`A < B`|A "is lesser than" B|
|`A >= B`|A "is greater than or equal to" B|
|`A <= B`|A "is lesser than or equal to" B|

Using these operators, you can build conditions that compare literal (directly written out) values or variables! You can also combine simpler statements built from the operators above using the connectors below:

|Keyword|Effect|
|---|---|
|`A && B`|Both conditions `A` and `B` must be true|
|`A || B`|Either `A` or `B` must be true|

As such, you can build conditions such as `i >= 10 && i < 100`, which would translate to `this statement is true if and only if 'i' is greater than or equal to 10, and lesser than 100`.

These conditions can be used to build conditional statements:

```javascript
if(condition1) {
	//Code executed if condition1 is true.
} else if(condition2) {
	//Code executed if condition2 is true, and condition1 false.
} else {
	//Code executed if all of the above are false.
}
```

In this model, the `if`, `else if` and `else` keywords define blocks to which we can attach a condition and whose contents will only be executed if the condition assigned to it is true.

In this structure, only the `if` is necessary; `else if` and `else` are absolutely optional. Let's look at different forms the model can take:

#### Single `if` statement

A single `if` statement can be inserted in your code; if its condition is true, then the associated contents will be executed before continuing to the code that comes next. If the condition is false, the block is simply skipped.

```javascript
//Code

if(condition) {
	//Code executed only if 'condition' is true.
}

//Code
```

#### `if`/`else` duo

In the case of a `if`/`else` duo, if the `if` condition is true, its code is executed, otherwise the `else` is executed. This defines an alternate scenario to a satisfied condition that isn't a simple "skip the block."

```javascript
//Code

if(condition) {
	//Code executed only if 'condition' is true.
} else {
	//Code executed if the condition is false.
}

//Code
```

#### `if`/`else if` duo

An `if`/`else if` duo works the same way as the `if`/`else` variety, but doesn't always execute the "fallback" code. It acts as stacked `if` statements: if the first `if` is unsatisfied, the second is looked at and if its condition is true, its content is executed. Note that you can add as many `else if` blocks as you want; the first one to have a satisfied condition is executed. If none are satisfied, the entire construct is skipped.

```javascript
//Code

if(condition) {
	//Code executed only if 'condition' is true.
} else if(condition2) {
	//Code that is executed only if condition2 is true and condition is false.
}

//Code
```


#### `if`/`else if`.`else` structure

This structure is the most "complete". Similarly to the previous case, if the `if` condition is satisfied, its associated code runs. Otherwise, the `else if` blocks are looked at sequentially. Finally, if none of the `else if` statements run, the `else` will run.

```javascript
//Code

if(condition) {
	//Code executed only if 'condition' is true.
} else if(condition2) {
	//Code that is executed only if condition2 is true and condition is false.
}

//Code
```

These four structural models can be mixed and matched (and nested) to build complex filters that selectively execute code according to your needs.

<hr>

#### Tip

`console.log` calls are especially useful in the context of conditional statements, as they will easily allow you to track which block is executed. Simply insert such statements in your blocks' code and look at your browser's web console for a detailed trace!

<hr>

<a id="js_loops"></a>
### Loops

Just like conditional statements, __loops__ also allow you to modify the way your scripts are executed. Rather than allowing you to define code that is only executed in some cases, loops will allow you to __repeat__ code without having to actually have duplicated code. This will be especially useful for code that generates regular and repetitive HTML structures.

We will consider two loops types: `while` and `for` loops. Both of them work roughly the same way and can accomplish the same tasks; the difference is mainly semantic in nature.

__`While` loops__ are described as "code that executes as long as a given condition is true." They have the following structure:

```javascript
while(condition) {
	//Code to be repeated
}
```

In this case, we must make sure that our condition is __reachable__, lest we produce an infinite loop that can easily make your user's browser unresponsive. Since Javascript runs continuously in the background of browser, an infinite loop could lock up the browser and prevent any further action from taking place, forcing your viewers to forcibly close the page.

A simple example of `while` loop is as follows:

```javascript
var counter = 0;

while(counter < 10) {
	console.log(counter);
	counter = counter + 1;
}
```

In this case, the statement `console.log(counter)` would be repeatedly executed, printing the value of the `counter` variable as it increases from its initial `0` value to its maximal value `9`. In the last iteration, `9` is printed, then the counter is incremented, which makes the `counter < 10` loops condition go false, ending the loop.

__`For` loops__ are quite similar to `while` loops: they will also be defined as `execute some code as long as a condition is true`, but will include space to define a counter without needing to define a variable outside the loop and increment it at each cycle.

`For` loops follow the model:

```javascript
for(counter ; condition ; counter manipulation) {
	//Code to be repeated.
}
```

The middle field `condition` is the same as the `while` loop's ; the remaining two will be filled with the counter variable's creation and initialization, and the counter manipulation that we apply at the end of each cycle.

For example, the loop we wrote earlier would take the `for` form:

```javascript
for(var counter = 0 ; counter < 10 ; counter = counter + 1) {
	console.log(counter);
}
```

Note that the condition hasn't changed, but the `var counter = 0;` and `counter = counter + 1;` statements were brought together with the condition, producing a more concise loop definition.

The two previous example also show that the same functionality can be implemented using either of the two loop types. The task of choosing which form is appropriate is left to the coder, who will see if a __counter__ is important (leading to `for` loops) or if a condition that isn't necessarily dependent on a counter is central to the loop's function (in which case a `while` loop would be useful).