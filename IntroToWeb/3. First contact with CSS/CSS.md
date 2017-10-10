# Introduction to Web development

## First contact with CSS

#### Table of contents

1. [Cascaded Stylesheets](#css)
- [Embedding style in pages](#embed)
- [Rule structure](#rulestructure)
- [Basic text styles](#textstyling)
- [More cascading](#morecascading)
- [Using the `<style>` tag](#styletag)

<a id="css"></a>
## 1. Cascaded Stylesheets

Before we start talking how we can add style to our web pages, we need to understand a bit about how our browsers use stylistic information to make the web engaging and aesthetically pleasing. It all starts by understanding what __Cascaded stylesheets__ are.

__Cascaded stylesheets__, which compress into the often used acronym __CSS__, are repositories for the markup that defines how our __structural elements__, defined by __HTML__, appear in our browsers. Much like HTML, CSS isn't programming: it is a static markup language that is interpreted as __style rules__ that are attached to elements.

Web pages can depend on many CSS files simultaneously, and a single structural element can receive its characteristics from many rules concurrently. CSS is a __cascade__ where rules are applied in layers according to a certain priority hierarchy.

<a id="embed"></a>
### Embedding style in pages

Before we see how CSS rules can be listed in external files, we will first see how we can embed them directly in our web pages. We can do so in two ways: using the `style` attribute, or the `<style>` tag.

By applying the `style` attribute on any tag, we can attach rules to that element. The rules we attach to elements this way are said to be __inline styles__ and override any other rule.

The `<style>` tag, on the other hand, allows us write our CSS as we would in a CSS file: as one block where rules are defined sequentially. When a `<style>` block exists in a page, the rules it contains are applied as soon as the browser reads that part of the page's code. This means that it is preferrable to put `<style>` tags in the `<head>` portion of our page, as it is the portion that is read first. 

Until we talk about how we can target elements of a page, we will use the __inline styles__ method.

<a id="rulestructure"></a>
### Rule structure

Rules have a very simple structure that applies no matter where the rule is stored:

```css
css-property: value;
```

Rules are composed of two elements:
- A __property__ that is the aspect that we are styling;
- A __value__ that defines how the __property__ is affected.

Each property has a set of valid values, and any __invalid values__ will be ignored by the browser. Moreover, as we'll see later, not all properties are supported by all browsers! For this reason, we will focus on generally supported properties and will make sure to make note of which ones lack support.

Also note the syntactic sugar: a __colon__ is always present between a property and its value, and each rule is ended by a __semicolon__. Forgetting any of these may cause the browser to ignroe the faulty rule __and the ones that follow__.

<a id="textstyling"></a>
### Basic text styles

Now that we know about the `style` attribute, we can dabble with basic CSS rules and experiment. A good entry point is, just like with structural tags, text content.

Here are some basic properties we will play with:

|Properties|Meaning|Example values|
|---|---|---|
|`color`|Changes the color of text.|[Hex colours](), [some colour nouns](), etc.|
|`font-size`|Changes the size of the text.|A measure in pixels (`px`), in `em`/`rem`, etc.|
|`line-height`|Changes the spacing between lines.||
|`font-weight`|Changes how bold the font is.|`normal`, `bold`, etc.|

You can attach any of these properties (and any other) on a structural tag using the `style` attribute:

```html
<p>The sky is <em style="color: blue;">blue</em>, the grass is <strong style="color: green;">green</strong></p>
```
Which is interpreted by the browser as:
<p>The sky is <em style="color: blue;">blue</em>, the grass is <strong style="color: green;">green</strong></p>

#### Try it out

Create a small page in which you have multiple copies of the same paragraph tag (and its content) and apply varying values of any of the properties above. Some properties, like `font-size`, accept numerical values; try tweaking them to gauge the effect of change on those properties.

<a id="morecascading"></a>
### More cascading

The notion of a stylistic cascade mentioned earlier also has a very important implication: __style applied to a parent is also applied to any and all of its children__.

This means that we can attach a rule to a tag to automatically attach it to all the tags that are placed inside of it without having to write it again. This also complicates knowing where style comes from as pages get more and more complex.

If we take back the last snippet, we could make the whole text, inner tags included, bigger by playing with `font-size` if we apply it on the `<p>` tag:

```html
<p style="font-size: 18px;">The sky is <em style="color: blue;">blue</em>, the grass is <strong style="color: green;">green</strong></p>
```
Which is interpreted by the browser as:
<p style="font-size: 18px;">The sky is <em style="color: blue;">blue</em>, the grass is <strong style="color: green;">green</strong></p>

This is a useful feature of CSS: if we have general stylistic elements that we would like to apply on a whole page, we could simply target the `<body>` tag, which has every other tag as a descendent. This is especially useful to set a default text size for an entire page.

#### Try it out

Build a small HTML snippet composed of a paragraph or two which themselves contain other tags that will bold or italicize some parts of their content. Apply a certain rule to the _parent_ tag, and apply a different version of that same rule (same property, different value) to the _children_ tags. Which version wins?

<a id="styletag"></a>
### Using the `<style>` tag

Now that we have a general understanding of how the `style` attribute can be used to include style directly in our tags, it's time to see how we can use the `<style>` tag instead to produce cleaner HTML files.

As we said earlier, the `<style>` tag should be included in our pages' `<head>` so that it is seen by the browser as soon as possible. Within the `<style>` tag, we will list our rules so that they can be applied the same way they were in our __inline style__.

Before we can do that, however, we need a way to target elements. When we included inline style in the tags, the style was directly on the element on which it applied. When we use the `<style>` tag, our rules will be _separated_ from the tags, requiring us to specify where those rules should go.

To link structural and stylistic elements, we will use the `id` and `class` attributes. Those attributes will allow us to give unique or collective names to our tags so that our CSS markup can target them and apply our style directives at the right place.