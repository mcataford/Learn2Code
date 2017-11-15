# Introduction to Python programming

## Input and output

### Table of contents

1. [Basic user input](#user_in)
- [The `input()` function](#input_function)
- [Parsing input](#parsing_input)
2. [File input and output](#file_inout)

<a id="user_in"></a>
## 1. Basic user input

To make our scripts more interactive, it is crucial for us to query the user for data. Fortunately, Python makes polling the user exceedingly easy: it is all condensed into one function conveniently called `input()`.

<a id="input_func"></a>
### The `input()` function

`input()` is a __blocking function__ that will pause the execution of your script until a string is entered by the user. This implies that __any input queries by `input()` is a string__, which in turn prompts us to process the input string to get the data we need.

`input()` takes in one optional parameter: a __prompt message__. Any __string__ entered as parameter for `input()` will be displayed to the user before the script halts and waits for input.

Once the user types in something, that data is __returned__ by the `input()` function. This implies that you should __store it__ in a variable to be able to use it.

Consider the following example:

```python
my_input = input("Type in something!")
```

When executing this code fragment, the output will display `Type in something!` and then wait for the user's response. No matter what is entered, it will be captured as a __string__ and returned, to be stored in the `my_input` variable.

Note that since the value captured is a string, if we are prompting the user for a numerical value, we will have to use the __conversion functions__ that we discussed in our talks about data types. You can then use `int()` and `float()`, for example, to convert strings representing numbers into actual numbers you can operate on.

__Be careful!__ Trying to convert non-numerical characters to numbers will __crash__ your script!

<a id="parsing_input"></a>
### Parsing input

User input is not limited to single values. The users can also write out __lists__ of items! Python offers us __string functions__ that can __split__ and __strip__ input to remove unwanted characters and cut the string provided by the user into __tokens__ that are useful to us.

The process of "cutting up a string" is called __tokenization__.

To tokenize a string, you can use the `split()` function. `split()` accepts an optional parameter defining the __marker__ that will be used to split a bigger string into smaller portions. __If no marker is given, whitespace will be used.__

```python
string = "This sentence is composed of words separated by spaces."

#This prints out a LIST of tokens, each token being a word of the sentence.
print(string.split())

#This prints out a LIST of tokens given by using the 'i' characters as separators
print(string.split("i"))
```

Note that the separator used by `split()` is not kept in the tokens and is discarded such that splitting using `i` as a separator discards all the `i` characters from the string and separates it into segments based on there the discarded characters were located.

<a id="file_inout"></a>
## 2. File input and output

We can also __read__ files to inject data in your scripts. This can be especially useful to use Python to process large datasets.

<a id="file_read"></a>
### Reading files

Reading files is a process that can be split in three steps:

- __Open__ the file using `open()`;
- __Read__ the file using a loop;
- __Close__ the file when done using `close()`.

To open a file, we can use the `open()` function along with two parameters: a __filename__ or __path__ that is relative to the script executing `open()`, and a __mode__ which represents whether we want to read, write or append to the file.

```python
#Open a file in READ mode
my_file = open("file.txt", "r")
```

Once opened, the file can be read __line by line__ using a loop, as the opened file acts as a "collection of lines", each terminated with a __newline character__.

```python
for line in my_file:
	print(line)
```

In the above example, we are reading our file line by line using a `for` loop, and printing each line. Much like in the classic `for` loops we have seen before, the execution of the loop will self-terminate once no more lines are available.

Once that is done, we can simply use `my_file.close()` to "free" the file and exit cleanly.

Of course, our processing `for` loop can do much more than simply print the data. Using the `split()` function that we have seen before, we can tokenize the file's content and use that data in our script.

<hr>

#### Try it out!

Can you use Python to __count__ the number of words present in [this English scrabble dictionary file]()?

<hr>

<a id="file_write"></a>
### Writing to files

Writing to files is no different from reading: we will still need to __open__ the file before operating, and __close__ it at the end. The major changes will happen in between: instead of using the `r` mode (symbolizing "read"), we will use either `w` ("destructive write") or `a` ("append"), and instead of looping through our file's content, we will use an additional function, `write()`, to push data to the file.

```python
my_file = open("new_file.txt", "w")

my_file.write("Hi!")

my_file.close()
``` 

In this case, the contents of `new_file.txt` will be replaced by the string `"Hi!"`, any previous content is discarded silently.

To avoid discarding old information, you can use the `a` mode, which will __append__ content to the end of the current file's content. The syntax is the same, only the mode parameter of `open()` changes.

<hr>

#### Try it out!

Can you craft a script that isolates a subset of the dictionary file used previously and creates a new file containing only the words of a certain length?

Can this length be __user defined__ through the `input()` function?

<hr>