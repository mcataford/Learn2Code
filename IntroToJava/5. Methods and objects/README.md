# Introduction to Java programming

## Methods and objects

In this section, we revisit __methods__ and __classes__ to manufacture our own. We will see how this can allow us to create our own data structures and modules that we can then reuse and share.

#### Table of contents

1. [Methods, revisited](#methods)
- [The `main` method](#main)
- [The general method model](#general_model)
2. [Object-oriented programming](#objects)
- [Defining classes](#basic_classes)
- [Defining objects](#basic_objects)
- [Making active objects](#active_objects)


<a id="methods"></a>
## 1. Methods, revisited

So far, we have been using the `main` method to contain all of our code. This model prevents us to truly __modularize__ our code and make sure that as much of our code is __reusable__. With the knowledge that we now have, we can revisit methods and see how we can __make our own__.

<a id="main"></a>
### The `main` method

The `main` method should be well-memorized by now and looks like this:

```java
public static void main(String[] args) {
	//Code
}
```

The line defining our method is called a __method definition__. This definition sets up a few properties of the method such as its __visibility__, the kind of data it __returns__ and what it takes as __input__.

Let's define the keywords used in the `main` method:

|Keyword|Meaning|Alternatives|
|---|---|---|
|`public`|`public` means that this method is usable by any code that would __import__ this class. It defines visibility.|`private`, `protected`|
|`static`|The `static` keyword defines whether the method is executed by itself or __on an object__. We will learn more about this later.||
|`void`|The type of data returned by the method; `void` marks that nothing is returned.|`double`, `int`, `String` [...]|

We can use these keywords and their variants to generate our own methods using a similar model.

<a id="general_model"></a>
### The general method model

From the `main` method's header, we can generate a more general model that we can use to write our own methods:

```java
<visibility> <staticness> <returntype> <name>(<comma separated input>) {
	//Code.
}
```

In a normal context, `<staticness>` is always replaced by the keyword `static`, but in the realm of __objects__, as we'll see next, this keyword is simply removed as methods __belong__ to objects and are no longer freestanding.

For simplicity, we will also define all our methods as having `public` visibility. In a broader context, this visibility modifier will allow us to make methods that are "for internal use only" and others that can be used by external programs.

This leads us to the updated model:

```java
public static <returntype> <name>(<comma separated input>) {
	//Code.
}
```

We can then fill the remaining placeholders to produce our own methods. For example, let's put together a method that prints a simple message, takes no input, and returns nothing:

```java
public static void printSomething() {
	System.out.println("Hi!");
}
```

In this context, our method returns nothing (hence the `void` return type) and takes no input, hence the empty parentheses. We can use it anywhere in our other methods or in our `main` method by using `printSomething();`  as a statement.

We can also include __input__ by specifying a list of comma-separated type/name pairs that will represent input parameters:

```java
public static void printSomething(String message) {
	System.out.println(message);
}
```

Again, this method can be used by using `printSomething("Hello!");` as a statement.

Once defined, a method can be used anywhere in your code, as long as it is in the same file. A little later, we will see that we can __include__ other classes (or __objects__) in our code to use methods defined elsewhere.

<hr>

#### Try it out!

Try putting together a method that will implement the __average__ computation. You should take in as input an __array__ of values of an appropriate type and output a single value representing the average of the array's values. Feel free to add other inputs as needed.

<hr>

<a id="objects"></a>
## 2. Object-oriented programming

Now that we know how to define __methods__, we can go further and talk about defining our own __classes__. In Java, __classes__ can be used as __objects__, which are essentially __custom-made data structures__.

By making our own classes, we can also produce __modules__ that we can __share__ and __reuse__ across projects. Moreover, we will be able to __split__ our code into parts to have more organized projects.

<a id="basic_classes"></a>
### Defining classes

__Classes__ are just like methods in the sense that they have a __definition__ and contain code. The definition of classes only contains one keyword: a visibility modifier. This visibility modifier behaves exactly like the methods' and can be varied the same way.

Classes stored in different files but in the same folder can __interact__ with each other: since they are in the same directory, you can simply use the model `<classname>.<method>` to access methods located in a neighbouring class.

This is valid for methods that have the `static` keyword in their definition.

Remember that you can define classes using the model:

```java
<visibility> class <name> {
	//Methods.
}
```

<a id="basic_objects"></a>
### Defining objects

When using classes as __objects__, we will use them as __blueprints__ for data-types. Instead of containing a `main` method, our object classes will contain methods that __belong__ to our object, much like `String`'s `length()` method.

Let's define a simple class:

```java
public class MyObject{

}
```

As it stands, our `MyObject` class contains nothing. We can however use it as a data-type and create a `MyObject` variable using a __constructor__:

```java
MyObject my_variable = new MyObject();
```

The __constructor__ is a method that will __initialize__ our object and "build" a variable using the class's blueprint. Since our class has no constructor, a default constructor that has no actions attached to it is executed; we can however replace this default constructor by defining our own.

The constructor is a special method that is always set to `public` visibility, and that doesn't have a return type. Moreover, as we'll see with other object-related methods, it does not feature the `static` keyword.

For any object, the constructor takes the form:

```java
public <object name>() {
	//Code to be executed when creating the object.
}
```

Using this model, we can update our `MyObject` class:

```java
public class MyObject{
	public MyObject() {
		System.out.println("Hello! I am a new object!");
	}
}
```

From this point on, using the `MyObject()` constructor will use our constructor instead of the default one, and our print statement will be executed.

Our objects will contain two types of elements: __instance methods__ and __instance variables__. The first is the collection of __non-static__ (not featuring the `static` keyword) methods that belong to our object, and the latter is __fields__ that can contain data within the object.

You can create instance variables by adding a variable declaration __along with a visibility keyword__ outside of any methods but inside a class:

```java
public class MyObject{

	public String my_variable = "Hi";

	public MyObject() {
		System.out.println("Hello! I am a new object!");
	}
}
```

This variable is accessible anywhere in your object and its methods by the way of the `this` keyword, which refers to instance variables and methods. Once we have those fields, we can have our constructor set them up using input from the program in which the object is used:

```java
public class MyObject{

	public String my_variable;

	public MyObject(String input_text) {
		this.my_variable = input_text;
	}
}
```

At this point, we can supply a `String` to our constructor, which will then be __saved__ in the instance variable `my_variable`. As long as the variable doesn't go out of scope, this data will remain saved in there. These instance variables are also called __properties__ of our object.

At this point, our object can be used as a passive data structure: anything public can be accessed using the `<object variable>.<property>` model, this means that all the fields can be edited and accessed freely as long as they are set to `public`.

<hr>

#### Try it out

Let's put together an object representing a __Student__ and use another file to __instantiate__ and use it. You should be able to feed data to your object through its constructor, and get its data back using the `<object variable>.<property>` notation. Pick at least three (3) relevant properties for your `Student` object instance variables.

<hr>

<a id="active_objects"></a>
### Making active objects

We can make our objects more __active__ than passive by adding __instance methods__ to them. An instance method simply is a method that can be used __on__ an object and that is defined as part of its class. Our __constructor__ is a specific example of instance methods.

A more general model for instance methods follows the one we defined earlier for general methods but takes away the `static` keyword. This is because our instance methods no longer stand on their own; instead, they will be associated with a specific object variable.

The general instance method model is then:

```java
<visibility> <returntype> <name>(<comma-separated list of input>) {
	//Code.
}
```

For example, we could make a method that simple introduces our `MyObject` class designed earlier:

```java
public class MyObject{

	public String my_variable = "Hi";

	public MyObject(String input_text) {
		this.my_variable = input_text;
	}

	public void sayHi() {
		System.out.println("Hello!");
	}
}
```

Once defined, any __public__ instance method can be used on any objects of the `MyObject` type by writing `<object variable>.<instance method>`. More specifically, we can use our `MyObject` method:

```java
MyObject my_object = new MyObject("Text stored inside of my object");
my_object.sayHi(); //This uses the instance method and prints "Hello"
```

Just like any other method (such as our constructor), these methods can take in input and modify instance variables using the `this` keyword. For example, adding a method that prints out the `my_variable` property and another that modifies it would be written out as:

```java
public class MyObject{

	public String my_variable = "Hi";

	public MyObject(String input_text) {
		this.my_variable = input_text;
	}

	public void sayHi() {
		System.out.println("Hello!");
	}

	public void changeInstanceVar(String new_value) {
		this.my_variable = new_value;
	}

	public String getInstanceVar() {
		return this.my_variable;
	}
}
```

In this case, calling `my_object.changeInstanceVar("Hello, world!");` would __store__ the phrase "Hello, World!" in the instance variable, and `my_object.getInstanceVar();` would __return__ it.