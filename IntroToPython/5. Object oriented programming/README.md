# Introduction to Python programming

## Object oriented programming

What we have done so far can be qualified as __procedural programming__: we have produced functions, loops and conditional statements that execute more or less linearly and that are essentially long sequences of statements executed in a certain order.

In this section, we introduce __object oriented programming__, which is a paradigm based around the tailoring of __classes__ (or __objects__) which can implement our very own data structures and that lead us to another way to see code. Objects will allow us to create data structures and systems that are __adaptable__, __extensible__ and __easier to manage__. Moreover, objects give us the tools needed to build code that can be shared and reused, code that is __modular__.

### Table of contents

1. [Objects](#obj)
- [Creating objects](#obj_init)
- [Storing data in objects](#obj_storingdata)
- [Object functions](#obj_functions)
- [Design example: myVector](#obj_designexample)
2. [External modules](#modules)
- [The `math` module](#modules_math)

<a id="obj"></a>
## 1. Objects

Objects are __data structures__ that allow us to __store data__ and __define operations__ the same way __lists__ and __dictionaries__ store data and have some functions attached to them.

They will also be used to create __modules__ that can be attached to different programs, boosting the reusability of our code.

<a id="obj_init"></a>
### Creating objects

In Python, we can define a basic object by using the `class` keyword:

```python
class myObject():
	#Object definition
```

Of course, our object isn't functional before we include a __constructor__ in its definition. Much like `list()`, `dict()` and `tuple()`, which we discussed previously, our objects' constructors are __functions that set up our objects and prepares it for usage__.

An object's constructor is called `__init__()` and has at least one parameter: `self`. Our complete basic (empty) object definition then is:

```python
class myObject():
	def __init__(self):
		#Code to be execute when the object is created.
		print("An object has been created!")
```

Once our object has a definition containing a constructor, we can __instantiate__ it. The act of instantiating an object takes the "blueprint" that the class definition above represents and creating a working copy of it. Just like the function definition, an object's code isn't considered by the interpreter until the object is actually used.

You can instantiate an object by calling its constructor:

```python
#calling the constructor is done similarly as in the list example.
myObj = myObject()
```

Upon running the statement above, the code contained in our constructor is executed, and our object is ready for use.

<a id="obj_storingdata"></a>
### Storing data in objects

Part of preparing an object for use is to set up its __instance variables__. Instance variables will define what "fields" exist in the object and can be filled by whoever uses the data.

You can define any number of such fields inside the constructor by using the __self__ keyword:

```python
class myObject():
	def __init__(self):
		#Code to be execute when the object is created.
		self.my_data = 1
```

<hr>

#### The `self` keyword

The `self` keyword is omnipresent in objects. It refers to "the current instance of the object", which only makes sense once an object is instantiated.

Since the definition of an object only is a blueprint, you can have multiple __instances__ of an object in the same program; consider objects like "custom variable types." As such, the `self` keyword will allow you to refer to the variable you are currently "in".

Consider the following setup:

```python
A = myObject()
B = myObject()
```

Whenever a function of `myObject` is used on `A`, any `self` keyword refers to the context of `A`, which contains all the data stored in `A`. The same applies to `B`. The two "selves" are entirely separate.

<hr>

Using the `self` keyword, we can then define a field __inside of the object__. We can define as many of those as we need; such fields are just like normal variables (but exist only within the object).

Moreover, since `__init__` is a function, we can add __input parameters__ to it so that the information stored in our object's fields is user-defined:

```python
class myObject():
	def __init__(self, my_input):
		#Code to be execute when the object is created.
		self.my_data = my_input
```

In this case, the data stored in `self.my_data` is set to be whatever the user provides as a parameter to the constructor of our object:

```python
myObj = myObject(15) #This will store the value '15' in the object's field 'my_data'
```

Note that we never include `self` outside the object's definition: this keyword doesn't make sense outside of an object's context. As such, it is considered to be a "shadow parameter" of all functions that belong to an object.

<a id="obj_functions"></a>
### Object functions

Objects become a lot more useful when we add __instance functions__ to them to make them more than simple passive data containers. We can define functions that will apply on our object by using the same scheme as before:

```python
class myObject():
	def __init__(self, my_input):
		#Code to be execute when the object is created.
		self.my_data = my_input

	def introduce_yourself(self):
		print("Hello, I am an object!")
```

Once a function exists in our object, we can call it the same way we used the list's functions:

```python
myObj = myObject(15)	#Creates an object and stored "15" in it.
myObj.introduce_yourself()	#Prints the message.
```

These functions need to feature the `self` keyword as first parameter, which allows them to access any of the object's fields. As such, we could modify our `introduce_yourself` function to print our field' content:

```python
class myObject():
	def __init__(self, my_input):
		#Code to be execute when the object is created.
		self.my_data = my_input

	def introduce_yourself(self):
		print("Hello, I contain the value " + self.my_data)
```

Using the new version of `introduce_yourself` would print the string "Hello, I contain the value 15", since we gave 15 to the constructor earlier.

You can design functions that manipulate data contained in your objects to create complex data structures. As an example, let's design an object that represents a vector.

<hr>

<a id="obj_designexample"></a>
#### Design example: a simple vector

In our discussion of __tuples__, we have implemented small functions that represent operations on vectors. Now that we can make our own variable types using objects, we can design a proper __vector__ class.

Our vector should have the following specifications:

- It should be a 3d vector, its constructor should accept 3 values representing (x, y, z) coordinates;
- It should contain a function that outputs it as a tuple;
- It should contain a version of the __dot product__ we previously implemented.

First, let's set up our basic structure: a class definition and a constructor with 3 parameters:

```python
class myVector():
	def __init__(self, x, y, z):
		#Constructor function
```

Since the values `x`, `y` and `z` are data that we want to __store__ in our object, we can use the `self` keyword as we did before to create some fields:

```python
class myVector():
	def __init__(self, x, y, z):
		self.x = x
		self.y = y
		self.z = z
```

Now that fields are set up, our object can __store coordinates__! Note that at this point, we can instantiate and access data directly:

```python
vec = myVector(1,2,3)

print(vec.x) #Prints the value of the 'x' field.
```

Let's add in our first function, which returns the vector __as a tuple__. Since our function only __returns__ value, it will only feature the obligatory `self` parameter:

```python
class myVector():
	def __init__(self, x, y, z):
		self.x = x
		self.y = y
		self.z = z
	
	def to_tuple(self):
		vec_as_tuple = (self.x, self.y, self.z)
		return vec_as_tuple
```

We can use the tuple convention, `(value, value, value)` to create our 3D tuple, and the `return` keyword to ensure that the data is given back to whoever uses the function. We can use it by simply calling the function on a `myVector` object and storing or using the resulting data:

```python
coordinates = vec.to_tuple()

print(coordinates) #Prints the tuple returned by the function to_tuple
```

Finally, our scalar product function. Scalar product is defined as the sum of products of all the corresponding elements in a vector. This means that if we have vectors (a1,a2,a3) and (b1,b2,b3), the resulting vector product would be a1*b1 + a2*b2 + a3*b3.

It's then evident that the result of this operation is a simply number, and that we must accept another `myVector` as parameter:

```python
class myVector():
	def __init__(self, x, y, z):
		self.x = x
		self.y = y
		self.z = z
	
	def to_tuple(self):
		vec_as_tuple = (self.x, self.y, self.z)
		return vec_as_tuple
	
	def dot_product(self, other_vector):
		dot = self.x * other_vector.x + self.y * other_vector.y + self.z * other_vector.z
		return dot
```

Again, we can use our function on any `myVector` object:

```python
vec1 = myVector(1,2,3)
vec2 = myVector(4,5,6)

dot_prod = vec1.dot_product(vec2)
print(dot_prod)	#Prints the result of the operation
```

Our final vector model is then ready to be used in our programs:

```python
class myVector():
	def __init__(self, x, y, z):
		self.x = x
		self.y = y
		self.z = z
	
	def to_tuple(self):
		vec_as_tuple = (self.x, self.y, self.z)
		return vec_as_tuple
	
	def dot_product(self, other_vector):
		dot = self.x * other_vector.x + self.y * other_vector.y + self.z * other_vector.z
		return dot
```

At any time, if we use the `myVector` constructor, we can create `myVector` objects and use them without having to define more functions. Moreover, as we'll see in the next section, we can now __share__ our `myVector` module between files so that once it's defined once, we can use it everywhere.

<a id="modules"></a>
## 2. External modules

Objects we designed are only truly useful when we reuse them. On a broader scale, Python already defines a lot of objects and functions, which would be useful to us; access to these would have us avoid reinventing the wheel.

As our code becomes __modular__, we gain the ability to __split it up in different parts__. To join parts together, we can use the `import` keyword.

The `import` keyword will allow us to attach a certain file or set of functions (called __library__) to our script, making it possible to use the code they contain directly.

For example, consider the [`myVector` object](#obj_designexample) that we designed earlier. Once it is stored in its own file, we can use the keyword `import` to include the object definition it contains in any script:

```python
#We import the file myvector.py
import myvector

#We access the myVector() constructor located in the myvector file.
vec = myvector.myVector()
```

As long as the `myvector.py` file is in the same directory as the file we import it in, this will allow us to use the `myVector` class as if it was defined in our file.

To simplify the usage of the classes we import further, we can use the syntax `from file import element`:

```python
from myvector import myVector

vec = myVector()
```

In this second example, we no longer need to specify in which file we get the function we are calling.

<a id="modules_math"></a>
### The `math` module

The first built-in Python module we can look at it the `math` module. The `math` module implements mathematical functions that go beyond the simple arithmetic we have learned about when we talked about numerical operations.

We can use the `math` module once we import it:

```python
import math

#the math module is now available.
```

Note that since `math` is a built-in module, it will be available for import no matter where our script is.

The `math` module's content is fairly extensive and can be found [here](https://docs.python.org/3/library/math.html). Since we use the `import module` syntax, we can use any of `math`'s functions by typing `math.function()`. For example:

```python
import math

fact = math.factorial(5) #Returns 5!
print(fact) #120

pow = math.pow(2,3) #returns 2 to the power of 3
print(pow) #8

sqrt = math.sqrt(16) #returns the square root of 16
print(sqrt) #4
```

It is recommended that you use these functions instead of implementing your own: this will not only save time, but in some cases, the implementations built into the `math` library are more efficient and precise that the ones you could produce.