# Introduction to Python programming

# Control flow - Practice problems

Read the material associated with these problems [here]().

## 1. Conditional statements

- __(True/False)__ Both the `if` and `else` statements are mandatory in conditional structures.
- __(True/False)__ Boolean expressions can be chained into more complex conditions.
- __(True/False)__ The `xor` keyword can be used to test whether only one of two conditions is true.
- __(Short answer)__ Explain what happens when the following structure is read over by the interpreter. Make sure you understand which conditions are __evaluated__ depending on the value of the `value` variable.

```python
#Assume that `value` is a variable that is defined and has some numerical value.

if value <= 0:
	print("Lesser than or equal to zero.")
elif value <= 10:
	print("Positive, but lesser than 10.")
elif value >= 20:
	print("Greater than or equal to 20.")
else:
	print("Somewhere in between.")
```
- __(Short answer)__ Explain the role of parentheses in __chained conditions__.
- __(Programming)__ The "fizzbuzz" exercise is a common programming test used to test how well students know conditional statements. It asks the following: Write a program that contains a function that does the following: a) print "fizz" if the function's input is a factor of 3, b) print "buzz" if it is a factor of 5, print "fizzbuzz" if it is both a factor of 3 and 5. _Hint: remember than the `%` operator will calculate the __remainder__ of a division._
- __(Programming)__ Write a function that will __return__ a letter grade given a numerical grade. You can use [McGill's grading scale]() to decide which letter grade is given. You should make sure that your script uses your function and __prints__ its output.


