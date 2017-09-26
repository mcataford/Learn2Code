# Introduction to Python

## Getting started

#### Table of contents

1. Setting up your environment
2. What is Python and why does it need an interpreter?
3. What tools can I use to write code?
4. What is Github?
5. Review

## 1. Setting up your environment

Through this document, we'll go through the set up process for your study environment. To get started with Python, we'll need one thing: the __Python interpreter__. We'll define what it is in a minute, but while we do, you can download it [here](https://www.python.org/downloads/). Make sure to pick version __3.6.x__, on which this course is based.

If you have an Apple or Linux computer (or have already dabbled with Python), you may already have an interpreter installed. To check which version, if any, your computer is already running, open a __command prompt__ (under Windows)/__terminal__ (under OSX/Linux) window and type the following:

```
py --version
``` 

__Note__: the "nickname" `py` (more commonly called an __alias__) is mostly in use in Windows. Under OSX, you may want to use `python3` as an alias instead.

__Note__: multiple versions of Python may co-exist peacefully on a single system. Most Apple computers come with Python 2.7.x preinstalled, this does not affect your ability to install Python 3.6.x to follow this course.

The output of the `py --version` command should look something like this:

```
C:\Users\cmarc\Documents\git\Learning>py --version
Python 3.5.3rc1
```

__If the version is above 3.5.0, you shouldn't encounter any difficulties through the course!__ Ideally, you'd have 3.6.x to ensure that all the code and external libraries used in the examples, assignments and projects work as expected. However, 3.5.x should be fully compatible with the material, so if your output is like the one above, __no need to install the newest version of Python unless you really want to!__

Once the interpreter is set up, you should be able to run the command above and display your interpreter's version.

### Optional tools

As we produce code, we might want to use [Github](), a free __version-control system__ available online. While it features a web interface that can do the job just right, you can also choose to install its underlying software, [Git](), to manage your code.

Since using Git is entirely optional, an additional document on it is available [here]().

## 2. What is Python and why does it need an interpreter?

__Python__ is a programming language amongst a multitude of programming languages. Much like other programming languages, Python allows you to harness the power of your computer to complete tasks that wold be tedious (or impossible) to complete by hand. It is renowned as being designed for simplicity and ease-of-use, but that doesn't mean that learning it doesn't require some honest work and practice.

### Compiled or interpreted

Python is said to be a __interpreted language__. Programming languages are split in two groups: __compiled__ and __interpreted__. 

[Compiled languages](https://en.wikipedia.org/wiki/Compiled_language) (such as Java, C/C++ and BASIC) are written, then "translated" in one go into a machine-friendly form, which can then be executed. The compilation process takes care of some computations (essentially anything that doesn't change during execution) and the rest is taken care of dynamically when the program runs. The __compiler__ takes the program and processes it entirely so that the finished product has knowledge of the entirety of the code that it contains.

[Interpreted languages](https://en.wikipedia.org/wiki/Interpreted_language), on the other end, are not prepared through compilation. An __interpreter__ will read them line by line, executing statements as it goes. This means that there is never full knowledge of the code contained in your program, and segments that are never passed over by the interpreter are, for all intents and purposes, nonexistant. "Out of sight, out of mind."

The difference between compiled and interpreted isn't always clear-cut, and one isn't better than the other. You can generally accomplish the same things in any language, but some might require more work than others as functions that are built-in vary between languages.

Python's interpreted nature is the reason why we installed the __Python interpreter__. This piece of software will take the Python code we'll throw at it and execute it line by line, giving us results or notifying us of mistakes we've made. 

### The python Interpreter

### What is Python used for?

## 3. What tools can I use to write code?

The task of writing code has very few requirements. While elaborate tools make life easier by taking care of tedious/repetitious routines for us, all you really need is a __plain-text editor__ such as Window's Notepad, OSX's TextEdit.

The Python Interpreter comes bundled with [IDLE](https://docs.python.org/3/library/idle.html), its own development environment. IDLE allows you to create, edit and run Python code all under the same tool. You can also explore more elaborate tools such as [PyCharm], [Eclipse] and [Visual Studio Code], which do everything IDLE can do with some added sugar. 

In the end, as long as your chosen editor can produce plain-text (as opposed to rich text, which contains formatting), you are good to go!

## 4. What is GitHub?

[Github]() is a __version-control platform__ used to keep track of software development. Much like track changes on GoogleDocs, version-control allows you to track changes and add contextual comments to your code so that you can review it at a later date. It allows you to __collaborate__.

As your write code, you may create software you are proud of or that could be useful to others. GitHub's social nature allows you to not only track the development of your masterpieces, but also share them for the world to see!

In the context of our lectures, we'll use it to facilitate assignments and projects troubleshooting by the instructor as well as cooperation between students.

## 5. Review

Here are a few questions to make sure you understood what was discussed in this section:

1. `py --version` (and its equivalents) checks if there are updates available for your Python interpreter. (True/False)
2. The biggest difference between compiled and interpreted languages is that interpreted languages are executed line-by-line whereas compiled languages are prepared/preprocessed before being executed. (True/False)
3. Github is a platform that helps you sell code online. (True/False)
4. You can only use editors that allow rich text to edit code. (True/False)
5. What are two areas in which Python is a major player?