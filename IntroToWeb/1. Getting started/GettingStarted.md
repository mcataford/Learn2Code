# Introduction to Web Development

## Getting started

#### Table of contents

1. Setting up your environment
2. The web: from the farm to your plate
3. Review

## 1. Setting up your environment

Web development doesn't require much tooling. At the very least, you'll need a __plain text editor__ such as Windows's Notepad or OSX's TextEdit. There are many tools you can use to get things done, some of which are [Brackets](), [Visual Studio Code](), [Atom](), [Notepad++]() and [SublimeText](). Choose the one you are most comfortable with, as it will only serve to facilitate writing code and won't affect the actual outcome of your efforts.

For the purposes of the class, we'll also use an online tool called [CodePen](). CodePen allows us to see our webpage grow as we write code, and easily share the results, complete or partial.

The main tool that we'll use is [Github](). While Github is a tool use more commonly to track software development projects, it offers __free hosting__ for sites such as the ones we'll produce. This way, you can have your very own corner of the Internet! More details on how this is setup can be found [here]().

## 2. The web: from the farm to your plate

### The general structure of the web

Before we get started learning how to put websites together and building a new online empire, we need to understand how it all works. We use the web every day, but rarely do we stop and think "How is this all made possible?"

Let's imagine the web as, well, a large _web_. Its intertwined tendrils link together __end systems__ (computers, servers, connected devices) so that they can send messages to each other. Before we proceed further, let's define two "classes" of __end systems__: consumers and producers.

__Producers__ are machines that _serve_ content more often than not (i.e. servers). They are the machines on which web pages and apps live. __Consumers__ are devices such as computers, phones, tablets and smart fridges that _request_ content more often than not.

With that in mind, the web is made of consumers, producers and links between them.

### Google, are you there?

What happens when you open up your browser and go on `https://www.google.com'? A lot.

Check out [this amazing walkthrough](https://github.com/alex/what-happens-when) for intense details, or read the quick summary below.

First, your __browser__ puts together a request. This request contains information such as what device you are using and what page you want. Given that you are connected to the Internet, this request is sent through the network.

Before reaching its destination, it may well pass a dozen machines: routers, switches and servers. Your request eventually reaches the server on which the website you want _lives_. That server receives your request and fetches the content you need.

From there, everything you need to display the page is sent back the same way your request came in. The response is plain text and represents the layout and content of the page.

When it is received by your browser, this reply is parsed and reformatted into a proper web page, and the raw code that defines the way the page is organized is _rendered_ into the visual representation of the web you usually see and love.


## 3. Review