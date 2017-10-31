# Introduction to Python programming

## Data structures basics

In programming, __data structures__ refer to ways of organizing data or collections of related data in a way that is easy to process and to use by both scripts and their developers. Now that we have a working understanding of how we can alter the flow of your programs and how variables work, we will focus on how we can use Python's built-in data structures and elaborate our own so that we can not only adapt our code to the problems we are tackling, but also the way in which we store data.

Python provides us with three basic collections: the __list__, the __tuple__ and the __dictionary__.

### Table of contents

1. [Lists](#lists)
- [Definition](#lists_def)
- [Creating lists](#lists_create)
- [Manipulating lists](#lists_manip)
- [Iterating over lists](#lists_iter)
2. [Tuples](#tuples)
3. [Dictionaries](#dicts)
 

<a id="lists"></a>
## 1. Lists

<a id="lists_def"></a>
### Definition

__Lists__ are, just as their name entails, linear collections of elements. They are __extensible__ (eg. they grow or shrink depending on how many elements they contain) and can contain __any type of data__, even if it is __diverse__.

Since lists are __collections__ of data, we will be able to use them anywhere where we mention a collection is appropriate, such as in the `for` loops discussed in the previous lesson.

<a id="lists_create"></a>
### Creating lists

List creation can be done two ways: you can create __empty lists__ or __populated lists__.

__Empty lists__ are created either using the `list()` __constructor__ (a function that creates a complex data structure for you) or using the `[]` (two square brackets with no contents) shorthand. Since they are variables, we can use the same model we've used before with variables:

```python
my_list = list()

# or

my_list = []
```

Both cases will result in the creation of an __empty list__ ready for use.

You can also create a __populated__ list by using the square brackets and a comma separated list of values:

```python
#Create a populated list.
my_numbers = [1,2,3,4,5,6]
```

Note that data in the list can be diverse, so this is also valid:

```python
my_values = [1, 2.0, "Marc"]
```

<hr>

__Be careful!__

Putting diverse data in lists can be tricky because it will make automated processing more complex: if you cannot expect a certain type of data to be applicable to all list elements, you have to look each time before processing or applying operations.

<hr>

<a id="lists_manip"></a>
### Manipulating lists

Lists use a __0-based indexing system__ to keep track of the location of elements. The first element of the list is given index 0, and the last, `length - 1`. To access elements of a pre-populated list, you can use the following notation:

```python
#Our list
my_numbers = [1,2,3,4,5]

#Accessing the first element
print(my_numbers[0])
```

The __square bracket notation__ will allow us to provide an index to the list and get an element back. This relationship works for accessing, but also for modifying:

```python
#The value of the first element is now changed to 1000.
my_numbers[0] = 1000
```

Note that when using this notation, the assembly of the variable name and the index (`my_numbers[0]`) is treated as a variable and can be used as such. For example:

```python
print("The first value in my list is " + str(my_numbers[0]))
```

The notation above is perfectly valid; note that we had to use `str()` because the value of `my_numbers[0]` is an integer.

<hr>

__Be careful!__

The square bracket notation __is only valid for indices that exist!__ Attempting to use it with an invalid index will raise an exception and halt your script's execution.

<hr>

To manipulate our lists further, we are given a series of __functions__ that will take care of __inserting__, __appending__ and __removing__ elements:

|Function|Effect|
|---|---|
|`append(a)`|Adds `a` at the end of the list.|
|`insert(a,b)`|Inserts `b` at index `a`, pushing all the elements forward|
|`remove(a)`|Removes the first value that is equal to `a` in the list.|
|`pop(a)`|Removes and returns the element at index `a`. If `a` isn't provided, the last element is operated on.|

Using these functions you can go beyond the simple editing of existing lists and actually build or destroy new collections. For any of these functions, the syntax is the same:

```python
#Let my_list be a collection of integers
my_list = [1,2,3,4,5,6]

#append(a) will add to the end of the list
my_list.append(7)
#The list is now [1,2,3,4,5,6,7]

#insert(a,b) will insert value b at index a
my_list.insert(1,900)
#The list is now [1,900,2,3,4,5,6,7]

#remove(a) will remove the first instance of a in your list
my_list.remove(900)
#The list is now [1,2,3,4,5,6,7]

#pop(a) will remove the element at index a
my_list.pop(4)
#The list is now [1,2,3,4,6,7] and 5 is returned

#pop() will also just remove the last item if no index a is given
my_list.pop()
#The list is now [1,2,3,4,6]
```

In addition to these functions, we have mentioned that we could use `len()` on `String` and other collection-type structures; lists are no exception. `len(my_list)` will return an integer representing the amount of items in the list at the moment of execution.

Since lists grow and shrink as you add and remove content, there will be no "gaps" available. This also implies that you cannot create an empty list of a certain size. Space is dynamically allocated to (and freed from) your list as needed.

<hr>

#### Try it out!

Create a __populated list__ of integers in the __interpreter's console__. Using the __square bracket notation__ and the __functions__ above, can you:

- Extract an element from the middle of your list and store it in a variable?
- Insert the extracted element at the beginning of your list?
- Remove the largest value from your list without having to use its index?

<hr>

<a id="lists_iter"></a>
### Iterating over lists

Earlier, we mentioned that we could use __loops__ in conjunction with lists the same way we used loops and Strings. There are two ways by which we can explore lists with loops: using __indices__ and using __elements themselves__:

```python
#Let there be a list of values
my_list = ["Hello", "World", "Github", "Python", "Code"]
```

Using `for` loop, we can walk through our list one element at a time:

```python
for element in my_list:
	print(element)
```

In this case, we can interpret the loop as _for each element in the list my_list, execute the code below_. This is mainly useful if __index or position don't matter__.

We can also write loops based on __indices__ using `range()`:

```python
for index in range(len(my_list)):
	print(my_list[index])
```

In this case, we first get the length of the list, `len(my_list)`, and we use it as a maximum for a number range by writing `range(len(my_list))`. We can then have our loop assign each value in sequence to `index`, and use this variable as an index to access the list through `my_list[index]`.

The same index-based scheme can be done through a `while` loop:

```python
index = 0

while index < len(my_list):
	print(my_list[index])
	index = index + 1
```

This loop would accomplish the same thing as the last `for` loop.

Looping or iterating through lists is a great way to apply a specific process on a wide range of data without duplicating code. We can now apply complex operations to collections of data.

<hr>

#### Try it out!

Given the list of integers below, could you write a __function__ that will calculate the average of the values it contain?

```python
my_numbers = [1, 100, 2, 56, 93, 132]
```

Make sure that you __iterate__ through the list. You should start by identifying which parts of the process is _repeated_ and can be encapsulated in a loop.

<hr>

<a id="tuples"></a>
## 2. Tuples

The __tuple__ is very similar to the __list__ structure. the main difference between the two is that while the list can be __modified__ (either through insertion, removal or updating of elements), the tuple is __immutable__. The tuple structure is then useful for small sequences of data that aren't meant to change: coordinates, vectors or other couplings of data that are read-only.

The other difference is the usage of the __parentheses__ instead of the  __square-brackets__:

```python
#This declared a list of three elements
my_list = [1,2,3]
#This declares a tuple of three elements
my_tuple = (1,2,3)
```

The tuple can be __accessed__ the same way as the list, using __indices__ and the __square bracket notation__:

```python
my_tuple = (1,2,3)

print(my_tuple[0]) #prints 1
print(my_tuple[1]) #prints 2
print(my_tuple[2]) #prints 3
```

Tuples can be converted to lists and vice versa using the __constructor__ we mentioned earlier:

```python
my_tuple = (1,2,3)

#Convert to list
my_list = list(my_tuple)

#Back to a tuple
my_tuple2 = tuple(my_list)
```

Note that the tuple doesn't support any functions like the list's `append` and `remove` since it's immutable! 

<a id="dictionaries"></a>
## 3. Dictionaries

Our third basic data structure is the __dictionary__. In Python, a __dictionary__ is equivalent to a [hash table](https://en.wikipedia.org/wiki/Hash_table); unlike a list, which uses __indices__ to tag data, dictionaries will use __keys__. Dictionary keys can be any type of data! Moreover, while lists are __sortable__ and __linear__, dictionaries are more like a __bag__ of data in which each piece of data has a tag attached to it representing its key.

Within a dictionary, keys must be unique: reusing a key causes a __collision__ and erases the previous data to replace it with the new.

<a id="dicts_create"></a>
### Creating dictionaries

Dictionaries follow the same kind of convention as the lists we've seen before: they can be created __empty__ or __populated__:

```python
#Creating an empty dictionary using empty braces:
my_dict = {}

#Creating an empty dictionary using a constructor:
my_dict2 = dict()

#Creating a populated dictionary:
my_dict3 = {"key": "value", "key2": "value2"}
```

Note that when creating populated dictionaries, we use lists of __comma-separated key/value pairs__. Each pair has the format `key: value`, where `key` is a unique identifier of any type. If keys are repeated, the last value associated with the key will be kept and the others will be discarded.

Just as in lists, content can be heterogeneous: keys can vary in type and so can values, which allows a dictionary like the one below to be perfectly syntactically correct:

```python
my_dict = {True: 1, "key2": 2, 3: "three"}
```

Just as with the lists, however, there are advantages to regularly: a regular set of keys or values makes processing easier, especially if loops are involved.

<a id="dict_access"></a>
### Accessing and using dictionaries

Once a dictionary is created, the __square bracket notation__ can be used with any valid key to either access, modify or insert a key/value pair. For instance, consider the following dictionary:

```python
my_dict = {"key1": 1, "key2": 2, "key3": 3}
```

Then we can access any of the elements using their keys:

```python
#Print the element associated with "key2"
print(my_dict["key2"])
```

Using an invalid key, that is a key that doesn't exist in the dictionary, will result in a `KeyError` exception which is equivalent to the `IndexError` exception we witnessed when using invalid indices in lists. Of course, the `KeyError` only appears when trying to __access__ an invalid key: using any key with the assignment operator `=` will insert the key in the dictionary if it doesn't exist:

```python
#Insert a key/value pair in the dictionary
my_dict["key4"] = 4
```

<a id="dict_functions"></a>
### Dictionary functions

Being a collection, `len()` can be used on a dictionary to get the number of key/value pairs it contains. The following functions can also be useful:

|Function|Effect|
|---|---|
|`get(key)`|`get()` will fetch the data located associated with `key`, but will not cause a `KeyError` if the key doesn't exist.|
|`keys()`|Returns a list of all the keys contained in the dictionary.|
|`values()`|Returns a list of all the values contained in the dictionary.|
|`has_key(key)`|Returns a boolean representing whether a given `key` exists in the dictionary.|
|`update(dict)`|Merges the current dictionary with given dictionary `dict`.|
|`items()`|Returns a list of __tuples__ representing all the key/value pairs in the dictionary.|

<a id="dict_loops"></a>
### Using dictionaries and loops

As you may have guessed from the presence of the `keys()`, `values()` and `items()` functions, which return lists we can iterate over. Other than using the lists of keys, values or tuples with loops, you can use `for` loops directly to cycle through all available keys:

```python
my_dict = {"key1": 1, "key2": 2, "key3": 3}


for key in my_dict:
	#Prints all the keys alongside their associated value
	print("Key: " + key + " Value: " + my_dict[key])
```

Variants of this could replace the collection by `my_dict.keys()` to loop through the list of keys returns by `keys()`, `my_dict.values()` to process the values and `my_dict.items()` to go through all the pairs.

