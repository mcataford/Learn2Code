# Introduction to Web development

## Introduction to CSS

#### Table of contents

1. [Cascaded Stylesheets](#css)
- [Embedding style in pages](#embed)
- [Rule structure](#rulestructure)
- [Basic text styles](#textstyling)
- [More cascading](#morecascading)
- [Using the `<style>` tag and CSS selectors](#styletag)
- [Isolating style from structure](#stylestructure)

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

Within the `<style>` tags, CSS rules are organized a bit differently than in the `style` attribute; rules will be gathered into blocks assembled under a __selector__ that targets one or more structural elements.

```css
selector {
	property: value;
}
```

The `selector` can be an `id` or `class` (or more, as we'll see later), and the `property`/`value` couples are the same as they would be in the inline style.

#### The `id` attribute

The `id` attribute allows you to give a unique identifier to your structural elements so that you can refer to them in CSS. Note that once you give an `id` to an element, __you shouldn't give the same `id` value to another element in the same page__!

You can add the `id` attribute to an element by adding `id="my_id"` to its tag:

```html
<p id="first_paragraph">My text.</p>
```

Once added to an element, the `id` value can be used as a selector by __prepending a hashtag to it__. If we wanted to change the colour of the `<p>` tag we just defined, we would write:

```html
<style>
#first_paragraph {
	color: blue;
}
</style>
```

#### The `class` attribute

The `class` attribute works the same way the `id` does, but isn't unique. It allows you to define style for a range of elements related to each other somehow. You can attach a class (or multiple) to an element by filling the `class` attribute. Once defined, you can refer to it in CSS by __prepending a period to the `class` value__.

```html
<p class="important">This is an important paragraph.</p>

<style>
	.important {
		font-weight: bold;
	}
</style>
```

#### Using a tag name as selector

You can also select all the tags of a specific type by using the tag name as a selector. For example, you could use `p` as a selector to select and apply style to all `<p>` tags, regardless of the `id` or `class` values attached to them.

#### Parent/children

One last basic feature of selectors that is tremendously helpful is the ability to target tags by specifying their parent. Let's consider the example markup below:

```html
<p>My text is <strong>important</strong></p>
<strong>This one is a bit less important.</strong>
```

How could we target the `<strong>` tag that is __inside__ of the `<p>` tag without targetting the one that is also outside?

Based on our previous discussion of `id` and `class` attributes, it's evident that we could add an id or a class to the tag(s) we want to target. It is however good practice to keep markup as simple as possible: if we can avoid adding attributes and rules, we should. This leads to more concise code that is easier to read and troubleshoot.

To reduce the number of `id` and `class` attributes floating around, we can refer to the tags themselves by defining not only the tag we want to apply the rules on, but also its parent(s):

```
p strong {
	color: red;
}
```

In the case above, `color: red;` only applies to `<strong>` tags that are within a `<p>` tag. You can add as many ancestors as you want to target elements more precisely (eg. `p em strong` would target `<strong>` tags that are contained in an `<em>`, itself contained in a `<p>`).

<a id="stylestructure"></a>
### Isolating style and structure

When we discussed the `style` attribute and the `<style>` tag, we mentioned that the main motivation to remove stylistic elements from the tags themselves is to keep our code clean and minimal. Our objective in doing this is also to isolate __style__ from __structure__ so that we can use the same stylistic rules across multiple pages.

Sharing stylesheets will make it possible to effortlessly expand our websites to multiple pages while keeping a common stylistic thread (and without having to duplicate our CSS markup from page to page).

Anything that is put inside of `<style>` tags can be directly moved to a `.css` file, which we can then link to our page. To make that linkage possible, we will use the `<link>` tag. Since it's meant to be viewed by our browser but not by our visitors, this tag belongs to the `<head>`.

The `<link>` tag possesses two essential attributes: `href` and `rel`. 

`href` works exactly the same way it did with the `<a>` tag or with the `<img/>` tag's `src` attribute: it accepts a __relative path__ or __URL__.

`rel` defines what is the __relationship__ between the tag's linked resource and the page. When linking to stylesheets, we'll give `rel` the value of `stylesheet`.

```html
<link href="path/to/stylesheet.css" rel="stylesheet"/>
```

The `<link>` tag should replace all `<style>` tags in your pages; this way, all style is easy to share and distribute. Moreover, separating style from structure allows you to edit style without touching the structure at all, therefore reducing the scope of what you work on.

### Review

- You can add __style__ to your tags by using __inline style__ (through the `style` attribute) or __style blocks__ (through the `<style>` tag).
- Style is conveyed by using __CSS rules__ that have the format `property: value;`.
- Each property has a set of valid values; invalid values are ignored by browsers.
- If you use inline style, your rules are directly attached to the structural elements.
- If you use `<style>` tags, you need to use __selectors__.
- The selectors are used to form __style blocks__:
```css
selector {
	property: value;
}
```
- Selectors can be `id` or `class` attributes, or the tag name itself.
- To use `id` values as selectors, prepend a hashtag in front of it (`#my_id`).
- To use `class` values as selectors, prepend a period in front of it (`.my_class`).
- To use tag names, simply use the tag name (`p` to select all `<p>` tags).
- You can select elements that possess a certain parentage by listing elements one after the other (`p strong` would target all `<strong>` tags inside of `<p>` tags).
- You can move the contents of any `<style>` tag into `.css` files and link them using `<link>` tag.