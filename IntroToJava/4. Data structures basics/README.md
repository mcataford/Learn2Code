# Introduction to Java programming

## Data structures

In programming, __data structures__ refer to ways of organizing data or collections of related data in a way that is easy to process and to use by both programs and their developers. Now that we have a working understanding of how we can alter the flow of your programs and how variables work, we will focus on how we can use Java's built-in data structures and elaborate our own so that we can not only adapt our code to the problems we are tackling, but also the way in which we store data.

The main object of this lesson is the most basic data structure offered by Java: the __array__.

### Table of contents

1. [Array basics](#arrays)
- [Definition](#definition)
- [Declaration and initialization](#declareinit)
- [Using arrays](#usingarrays)
- [Iterating over arrays](#iterate)
2. [Multidimensional arrays](#multidimensional)
3. [ArrayLists](#arraylists)
- [Improvements on the classic array](#al_improvements)
- [General design](#al_design)
- [Methods](#al_methods)

<a id="arrays"></a>
## 1. Array basics

<a id="definition"></a>
### Definition

__Arrays__ are __fixed-length__ list-like structures that will allow us to store data __of the same type__. Their inability to shrink or grow comes from the way they are represented in memory: when an array is created, a __contiguous chunk__ of memory is allocated and its __address__ is kept in the array variable -- since there is no way to guarantee that memory is available beyond the allocated chunk, the only way to grow an array will be to allocate another chunk bigger than the first one and copy everything over. In that same train of thought, memory allocation needs to be __predictable__: the amount of space to allocate needs to be known before the array is created. For this reason, data contained in an array must be of a single type; the system simply looks for N blocks large enough to fit an `int` (if the array is an array of `int` values) and reserves it. Trying to store data that doesn't fit snugly in the allocated blocks (such as `double`, which is larger) would either leave free space in between blocks or would cause certain blocks to overlap on others.

Ultimately, arrays are designed to be extremely regular structures so that Java can handle them as fast and as directly as possible.

<a id="declareinit"></a>
### Declaration and initialization

Declaring arrays will follow the same general model as the declaration of variables:

```java
type name = value;
```

We will modify the way the `type` is represented, however, to convey that we are not merely creating a single `int`, but a collection of `int` values. All __array__ types will feature the distinctive set of square brackets following the type of data stored in them. As such, we can tweak our general model to look like:

```java
type[] name = value;
```

The type of an `int` array would then be `int[]` and the type of a `String` array would be `String[]`, for example. Note that arrays are the only context in which you will see the use of square brackets `[]`.

The next modification we need to make is the `value`. The initial value of an array also needs to convey the duplicity of data. As such, we define two ways in which arrays can be initialized before usage:

- We can initialize __empty arrays__ by choosing a size `size` and writing:

```java
type[] name = new type[size];
```

In this case, the array will be initialized with default empty values; an array of `int` would be filled with zeroes, an array of `boolean`, which `false`, and so forth.

- We can initialize arrays pre-filled with data by using an __array literal__ that would define other values than the default zeroes:

```java
type[] name = {element1, element2, element3 ...};
```

In this scenario, `element1`, `element2`, `element3` and so forth must be values of the appropriate type separated by commas.

Notice that __only the empty array scenario explicitly specifies the array length__! In the case where we initialize our array using a literal, the length is implied by the number of items we use.

Some concrete examples of array creation:

```java
//Creating an empty array of integers
int[] my_numbers = new int[5]; //This contains 5 slots for integer values.

//Creating a pre-filled array of doubles
double[] my_fractions = {1.1, 0, 5, 10.2, 100.2345};

//Declaring an array WITHOUT INITIALIZING IT
String[] my_words;

//Initializing the array we just declared
my_words = new String[5]; //It is now ready to use, but contains no data!
```

<a id="usingarrays"></a>
### Using arrays

Now that we can create empty or populated arrays, we need a way to __access__ and __mutate__ the values stored in them. This is done using the __square bracket notation__ and __indices__.

Arrays are __indexed__ using a __0-based system__. This means that the first element of the array has "array address" 0 and the last one, "array address" `length - 1`. Using those indices, we can reference any of the slots that __exist__ in the array.

The __square bracket notation__ simply refers to the following syntax: `array[index]`. To access array elements, we will append the index surrounded by square brackets to the variable containing the array. __This will serve both as a read and a write accessor.__

```java
//Creating an empty array of integers.
int[] my_numbers = new int[5];

//Storing a value in the first slot.
my_numbers[0] = 1911;

//Accessing the value we just stored.
System.out.println(my_numbers[0]);
```

Note that in the case where we store data inside of the array, we treat `my_number[0]` as a plain variable and use the assignment operator as we would for a regular integer variable. The same happens when we access elements in the array: `my_numbers[0]` is a simple variable pointing at the 0th element of the array `my_numbers`.

You can of course __overwrite__ elements of the array as needed, the old values will be replaced just as if you reused a variable after declaring it.

<hr>

__Be careful!__

Using indices open the door to using __invalid indices__. Consider the following array of 5 elements:

```java
int[] my_numbers = {1, 2, 3, 4, 5};
```

What happens if we try to access `my_numbers[5]`? Since `5` is larger than `length - 1`, we are __out of bounds__ and will trigger an exception letting us know that we have access memory outside of the chunk reserved for the array.
<hr>

Using this system, we can now store __similar data together__! For example, looking back at our Fahrenheit to Celsius conversion tool, an array would be a convenient way to hold a set of temperatures to convert!

<hr>

#### Try it out!

Consider the following array:

```java
double[] my_grades = {10.8, 80.4, 99.9, 50.7, 45, 34.67};
```

How would you make use the __square bracket notation__ to calculate and print out the average of this list? You can assume that all the values have the same weight.

Can you __create and populate__ an array of the cumulative sum of the values? The cumulative sum is defined as the sum of all values starting from the left up to the index you are looking at.

In the next subsection, we will see how we can automate the tedious process of __walking through__ our array to process values repeatedly.

<hr>

<a id="iterate"></a>
### Iterating over arrays

In the last subsection, we said that we can use a numerical position, the __index__, to access specific elements in our arrays. You may also have noticed that __indices are sequential__. Of course, we could type index values by hand, but it's much more useful to make good use of a __repeating control flow element__ to handle the indices.

In the previous lessons, we wrote loops such as this one:

```java
for(int counter = 0 ; counter < 5 ; counter = counter + 1) {
	//Code.
}
```

In this loop, `counter` takes all the values in the set `[0,1,2,3,4]`. We can take advantage of this and combine it with arrays to have loops "walk through" our collections of data!

By using the loop's counter as an index value instead, we can sequentially access each element of the array:

```java
int[] my_numbers = {1,2,3,4,5,6,7,8,9,10};
for(int index = 0 ; index < 10 ; index = index + 1) {
	System.out.println(my_numbers[index]);
}
```

In this case, `my_numbers[index]` will be given the value of each array element over the full lifetime of the loop. Since `index` will change at each iteration, the value of `my_numbers[index]` will change too.

An issue mentioned earlier but not addressed is how we can handle __arbitrary arrays__ for which we can't explicitly write the length. Arrays have a `length` property that can be accessed by typing `my_array.length` and that is always equal to an integer that represents the capacity of the array. We can substitute this form in our condition (previously `index < 10`) to obtain a safer loop that cannot go out of bounds no matter how the array is changed:

```java
int[] my_numbers = {1,2,3,4,5,6,7,8,9,10};
for(int index = 0 ; index < my_numbers.length ; index = index + 1) {
	System.out.println(my_numbers[index]);
}
```

Note that this can be done using `while` loops as well:

```java
int[] my_numbers = {1,2,3,4,5,6,7,8,9,10};
int index = 0;

while(index < my_numbers.length) {
	System.out.println(my_numbers[index]);

	index = index + 1;
}
```

<hr>

#### Try it out!

- Modify the __grade average__ exercise from the earlier __Try it out!__ segment to make use of a loop such that you do not have to manually access the array. You should control the array using a loop and not put __integer literals__ (eg. `my_grades[1]`) directly in the array.

- Create an empty integer array and populate it using a `for` loop. You can insert the numbers you want in there, as long as your loop is involved in accessing the array. Use a `while` loop to access each of the element you inserted in the array in the first part of the exercise and print them out.

<hr>

<a id="multidimensional"></a>
## 2. Multidimensional arrays

Using the principles discussed in [the previous section](#arrays), we can produce array structures adapted to data that is __multidimensional__. To do this, we will create an __array of arrays__ of a certain type:

```
type[][] name = new type[size1][size2];
```

In this scenario, `name` would be a 2D array of `type` with `size1` rows and `size2` columns.

We can also produce a pre-filled multidimensional array using the same syntax we used for the simple dimension case:

```java
int[][] my_matrix = {{1,2,3}, {4,5,6}, {7, 8, 9}};
```

Accessing multidimension arrays is also following the same index-scheme we have studied earlier in this document. Having multiple indices will however require us to use __nested loops__:

```java
for(int row = 0 ; row < my_matrix.length ; row = row + 1) {
	for(int column = 0 ; column < my_matrix[0].length ; column = column + 1) {
		System.out.println(my_matrix[row][column]);
	}
}
```

Notice that we use the notation `my_matrix[row][column]` to access the array. We specify the indices in the order we declared them such that the first index chooses the correct array in the array of arrays, and the second, the element in the chosen array.

Also note that we used `my_matrix[0].length` to define the maximum index of the inner array. Since the size of all data pieces inside of an array need to be the same, the size of all arrays inside of an array of arrays is also bound by that rule. As such, we can just pick the length of the smaller "inner array" and consider this to be applicable to each subarray.

<hr>

#### Try it out!

To try out multidimensional arrays, consider the following structure:

```java
int[][] my_matrix = {
	{1,2,3},
	{4,5,6},
	{7,8,9}
};
```

First, without using loops, how would you __print out__ the diagonal that starts from the top left? Do it in three separate statements.

Can you do it with a loop? Think of which indices the cells you are targetting have.

Can you craft a __nested loop__ that will replace any __even value__ by 0?

Finally, try printing out all the values contained in your matrix. You can do so on one line, or on three different lines.

<hr>

<a id="arraylists"></a>
## 3. ArrayLists

<hr>

#### Attention

This section deals with __objects__. If you haven't read the section on [objects and classes](), you should peek ahead to be able to fully enjoy this part.

<hr>

__Arraylists__ build on top of the general idea of an array, which is just a linear list of elements indexed by position. Just like the array described [earlier](#arrays), __arraylists__ will only store elements that are __similar in type__, and the same principle of addressing will apply (i.e. the first element will have index `0`, and the last, index `length - 1`).

The big difference comes with the content: while our arrays could contain anything, our __arraylists__ will contain __objects__. Not to worry: __object wrappers__ exist for all primitive types allowing you to produce objects that represent primitives.

For example, consider the `Integer` class. `Integer` is the wrapper class for `int` primitives and implements the same kind of operations regular `int` variables have. If you attempt to store a primitive in an ArrayList, the conversion to the wrapper is done automatically, allowing you to use the ArrayList in any context where you would use an array instead.

<a id="al_improvements"></a>
### Improvements on the classic array

The ArrayList's big advantage over the classic array is its __extensibility__. Remember that when we defined our array structure, we said that it was __static in length__ because of the way memory was allocated. When the array is first initialized, a __contiguous block of memory__ was reserved for it so that all elements could be stored together in a sequential fashion.

The ArrayList will still handle your data using an array, but will abstract away the task of __resizing__ your array such that it has seemingly infinite capacity (as long as your device's memory allows storage, of course).

Being an object itself, the ArrayList will also require its own __methods__ since the square bracket notation we have seen earlier only applies to arrays.

<a id="al_methods"></a>
### Methods

The ArrayList offers you a handful of [methods](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html) by which you can manipulate its contents. The most useful of them are the following:

|Method|Effect|Usage|
|---|---|---|
|`ArrayList()`|Creates a new ArrayList, initially empty.|`ArrayList<type> myList = new ArrayList();`|
|`add(object)`|Appends an item to the list; the item is added at the end.|`myList.add("Marc");|
|`add(int, object)`|Inserts an item in the list at the specified index.|`myList.add(0, "Marc");`|
|`clear()`|Removes all the elements from the list.|`myList.clear();`|
|`get(int)`|Gets a specific item given an index, similar to `arr[index]`.|`myList.get(0);`|
|`size()`|Calculates the size of the list.|`myList.size();`|
|`remove(int)`|Removes the item at the given index.|`myList.remove(0);`|
|`remove(object)`|Removes the first occurrence of the given element.|`myList.remove("Marc");`|
|`contains(object)`|Determines whether the list contains an element matching the given element.|`myList.contains("Marc");`|

Using these methods, we can replicate anything we have been doing with normal arrays, but without the size limitation we have experienced earlier.

