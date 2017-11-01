# Introduction to Python programming

# Data structures - Practice problems

Read the material associated with these problems [here]().

## 1. Lists

- __(True/False)__ Lists are extensible and can only contain data of the same type.
- __(True/False)__ List indices start at 0 and end at `len(my_list)` for a given list `my_list`.
- __(True/False)__ You can only create lists through the constructor `list()`.
- __(Short answer)__ What happens when an __invalid__ index is used to access a list element?
- __(Short answer)__ Can you explain what happens when `insert()` is used to add an element inside the list?
- __(Programming)__ Put together a small function that will create a __copy__ of a list and return it. Make sure that your function works properly with any list (of any length).
- __(Programming)__ Given the list below, put together a script that will compute the [standard deviation](http://www.mathsisfun.com/data/standard-deviation.html) of the list elements. You should make sure that you can print all the results as they are calculated, but also return them and store them in a list. (You can use the `average` function we have designed in class to speed up your work.)

```python
numbers = [13,16,94,16,76,732,120,45,75,12]
```
- __(Programming)__ Given two lists, can you design a function that returns a `boolean` that tells you whether the lists are similar or not? Note that you shouldn't use `==` to compare the lists, but rather consider each element in the lists. (Hint: you will need to walk through the lists in some way to compare elements)
- __(Programming)__ Taking example from the previous exercise and assuming that two lists are of the same length, design a function that will compute the number of __differences__ between two lists. That number should be returned.