# Introduction to Web development

## Basic navigation elements with CSS

In this tutorial, we get to apply elements we discussed previously to put together basic navigation elements. Before going through this document, make sure that you have a fair understanding of [the introduction to CSS and the segment about `flex`](https://github.com/mcataford/Learning/blob/master/IntroToWeb/3.%20First%20contact%20with%20CSS/CSS.md#layouts). The best way to use this document is to go along using a tool such as [CodePen](http://codepen.io) to build the components discussed as we go; this will allow you to see the effect of each change directly.

### Table of contents

1. [Menu basics](#menus)
- [General structure](#menu_struct)
- [Adding style](#menu_style)
- [Dropdown menus](#menu_dd)

<a id="menus"></a>
## 1. Menu basics

In most if not all cases, navigation on the web takes the form of a menu. Whether it is a vertical or horizontal menu, a menu contained in other elements or a menu floating above the page, the structure of menus is usually roughly the same.

<a id="menu_struct"></a>
### General structure

Because of semantics, we will always encapsulate our navigation elements in `<nav>` tags. This will ensure that our page carries meaning and that navigation can be found easily.

The other main structural element of our menu is a list. Lists are, by design, well-suited for menus since they already include ordering and alignment of items. With CSS, we will be able to tweak the `<ul>` or `<ol>` tag to look more like a menu and less like a bullet-point enumeration.

Let's set up a basic menu structure using `<nav>` and `<ul>`:

```html
<nav>
	<ul>
		<li>Item 1</li>
		<li>Item 2</li>
		<li>Item 3</li>
	</ul>
</nav>
```

The use of `<ul>` or `<ol>` won't matter since we do not plan on using the list item's marker, which you may remember as the only difference between the two types of list.

Since navigation is meant to carry our visitors from page to page, we will also need __linkage__, which can be achieved through `<a>` tags. You may remember that lists are semantically only supposed to contain list element `<li>` tags. As such, we will add our anchor tags __inside__ of the list items:

```html
<nav id="menu">
	<ul>
		<li><a href="#">Item 1</a></li>
		<li><a href="#">Item 2</a></li>
		<li><a href="#">Item 3</a></li>
	</ul>
</nav>
```

Note that `#` is used as a placeholder link target; this will cause our links to be recognized as links by the browser, but not lead us anywhere.

Because it will make __selecting__ elements better in CSS, we also gave the `<nav>` tag an `id` attribute.

<a id="menu_style"></a>
### Menu style

In this demonstration, we will primarily look at __horizontal menus__. However, everything we will do in terms of CSS can also be applied to a __vertical menu__ to change its look and feel.

First, we need to make our list _horizontal_. In lists, `<li>` are defined as block elements by default; this means that they occupy the full width of their parent. We can allow them to occupy the same line by making them __inline elements__. This can be done using the `display` property:

```css
#menu > ul > li {
	display: inline-block;
}
```

_Note: We use `>` in the selector to define that the left tag is the direct parent of the right tag. Go back to the CSS introduction to review this if needed._

We should also remove the __list item markers__. While they don't appear in this specific rendering, it's only because each bullet is hidden under the item on its left. We can remove the bullets through a property applied on the `<ul>` tag: `list-style`. By setting it to `none`, we remove any "list style", which includes bullets.

```css
#menu ul {
	list-style: none;
}
```

Next, we should transform the list items/links into proper buttons. First, we should expand the `<a>` tags beyond the mere text they contain. Based on our previous discussion of [spacing](), we know that `padding` will add space __inside__ elements; we can then inflate our anchor tags so that they occupy more space:

```css
#menu li > a {
	padding: 1em;
}
```

Having larger `<a>` tags will make it much easier to click a specific menu element. Moreover, it will allow us to work on some visual effects.

Note that we selected `#menu li > a`; we want to apply this style rule on all links that are inside of list item tags, but only if they are part of a menu. This sort of precision is necessary to ensure that the style will not be used somewhere else by accident.

We can make good use of some properties such as the `border`, `font-weight` and `margin` to make our buttons a tad more palatable:

```css
#menu li > a {
	padding: 1em;

	border: 3px solid black;
	font-weight: bold;
	margin: 0.5em;
}
```

To refine further, we can eliminate the default "blue link" style attached to `<a>` tags by modifying `color` and `text-decoration`:

```css
#menu li > a {
	padding: 1em;

	border: 3px solid black;
	font-weight: bold;
	margin: 0.5em;

	text-decoration: none;
	color: black;
	
	display: block;
}
```

Our menu now looks a lot more like a menu you'd see online. Without the telltale "link colour," it's however a bit hard to determine whenever we are on a clickable element. We can solve this problem using the `:hover` selector.

The `:hover` selector can, as we mentioned before, define rules that only apply __when the element is hovered by the cursor__. We can then put together a ruleset like this to produce a visual feedback to the user hovering our menu:

```css
#menu li > a:hover {
	background-color: black;
	color: white;
}
```

In this case, the item being hovered will have an inverted colour scheme.

At this point, our basic navigation can be made functional and can easily be integrated on a website; we might want to add some frills to it by aligning it differently on the page using `flex`. By using `flex`, we can align our menu items (contained in `<ul>`) to the left, the right, or the center of the `<nav>` that contains them. This can even create room for a logo to be added at the opposite end.

In this specific case, we would make use of `justify-content` and `align-items` to put items are opposite end of their container (using `space-between` for `justify-content`) and to vertically align them at the center (`align-items: center;`).

At this point, we have a minimalist menu that we can adapt easily for our websites. An assembled version of the menu can be found [here](https://codepen.io/marccataford/pen/WZBvvb).

<a id="menus_dd"></a>
### Dropdown menus

__Dropdown menus__ build on top our our menu structure to add "submenus" that can be accessed when the user hovers over certain menu elements. To start working on our dropdown menu, we will first replicate our menu structure __within__ one of the main menu items:

```html
<nav id="menu">
	<ul>
		<li><a href="#">Item 1</a>
			<ul class="dropdown">
				<li><a href="#">Submenu item 1</a></li>
				<li><a href="#">Submenu item 2</a></li>
				<li><a href="#">Submenu item 3</a></li>
			</ul>
		</li>
		<li><a href="#">Item 2</a></li>
		<li><a href="#">Item 3</a></li>
	</ul>
</nav>
```

Notice that we created a `dropdown` class to identify our submenus: we do this because the dropdown will require specific style that doesn't apply to the rest of the menu. We could also use the parent-child notation (chaining selectors and using `>` such as in `#menu > ul > li > ul`) to avoid having to create a class, but that depends on your preference.

Once we have our structure, we need to set a few things up style-wise:

- First, we need to make sure that our dropdown menu is hidden until hovered; we can use the `:hover` selector to achieve that. Remember that `:hover` will trigger the attached rules only if the element is hovered. We can create two rule sets: one that applies when the root item (in this case, the `<li>` that contains the dropdown) is hovered, and one that applies when it isn't. For now, we'll just hide the submenu when not hovered.

```css
#menu li:hover .dropdown {
	display: block;
}

#menu li dropdown {
	display: none;
}
```

- Second, we need to address __positioning__. By default, the submenu will be inserted as an inline item, which prevents it from aligning properly under the first menu item. We can solve this by using the `position` property, which defines what type of positioning system is used. The `absolute` value will tell our item to position itself relativey to the position of its ancestor, so the position of our submenu no longer depends on the position of the link that is inside of the main menu item:

```css
#menu li:hover .dropdown {
	display: block;
}

#menu li dropdown {
	display: none;
	position: absolute;
}
```

- Third, we can start styling our submenu by removing some extraneous margins and spacing, such as the margin around the `<li>` tags that is relevant when the menu is horizontal, but not as much when it is vertical. We can then simply set the `margin` property to 0 on the submenu's `<li>` tags.

```css
.dropdown > li {
	margin: 0;
}
```

These small modifications should now generate a functional and easily modifiable dropdown menu! The assembled example, building on top of what was done with the simple menu, can be found [here](https://codepen.io/marccataford/pen/yzmVpY).