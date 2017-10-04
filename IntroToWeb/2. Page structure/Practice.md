# Introduction to Web development

## Basic page structure - Practice sheet

With a grasp of structural elements that you can use to build the backbone of web pages, you can already start experimenting. In the next few sections, we'll be adding style and interactivity to our pages to make them more appealing, but for now, consolidate what you know of HTML tags by trying the following:

### Intentional failure

We discussed how structurally-sound pages make the browser's job easier. If your pages are malformed (i.e. contain misplaced or missing tags), your browser will try to fix it however it can. In some cases, this isn't visible in the final render of the page, but in some others, it's pretty gnarly.

In this section, we will make intentionally broken pages to see what happens when structural elements are misplaced. To get started, __set up a basic page structure using `<html>`, `<head>`, `<body>`__. To be able to see the results of our experimentation, insert a few `<hx></hx>` headings as well as a `<p>` tag or two. This way, we'll be able to see what happens both visually in addition to being able to use the __code inspector__ to see what's under the hood.

- We discussed that the `<head>` tag should only contain elements that aren't meant to be visually represented on the page. What happens if you insert `<hx></hx>`, `<p>` or other content tags in the `<head>` of your page?
- Try removing the closing tag of any of your content tags. What happens if you have a structure like this and try to remove the closing tag for the first heading?
```html
<html>
	<head></head>
	<body>
		<h1>My title</h1>
		<p>My wall of text</p>
		<h1>Second title</h1>
		<p>Other text</p>
	</body>
</html>
```
- Typos happen often, what would happen if you used two opening tags instead of one opening and one closing (on any tag)?
-	The `<title>` tag is meant to be unseen by the user since it sets the title of your page as displayed by your browser's tabs. What happens if this tag isn't in the `<head>`? Can it still do its job?

### Basic content organization

To better understand how our content tags work, let's experiment with them a bit:

- Create a new page containing at least two headings, five paragraphs and two images. You can visit [this _Lorem Ipsum_ generator for filler text](http://lipsum.com/) and [Google](https://www.google.com) for images. 
- From what we know of __URLs__ and __relative paths__, can you make it so one of the two images in the page you just created uses a __local resource, accessed via relative path__ and the other, an __external resource, accessed via URL__?
- We know that we can __nest__ tags such that they are placed within each other. WHat happens if you position an image tag within a heading? Within a paragraph?
- Try nested paragraph tags, What does the code inspector show when you look at how your page was rendered?

### Tables

When we discussed tables, we said that they are composed of three tags: `<table>`, `<tr>`, `<td>` and `<th>`. For the purposes of the next few manipulations, build a 3x3 table. Keep in mind that `<table>` is the __outer container__ for your table structure, `<tr>` represent __rows__ and `<th>` and `<td>` represent __cells__ that are part of a row.

- What happens if one of your rows has more cells than the others? Less than the others?
- Try putting table cells (`<td>` or `<th>`) outside of a row. What does your browser do then?
- We mentioned the `colspan` attribute and its ability to make cells "wider" by having them occupy more than one cell's width. Without removing any cells, what happens if you use `colspan` to make one of the cells wider?
- Still using colspan, can you adjust your table so that the second row only has one cell? Can you confirm that this larger cell occupies the width of the table?
- What happens if you insert any other tag (i.e. not a table-related tag) inside of a `<table>` tag?

### Lists

We defined lists has being split in two types: __ordered__ and __unordered__. Remember that the `<ul>` tag will produce an __unordered__ list while the `<ol>` will produce an ordered one. In both cases, `<li>` should be the only tag in your list block and defines list items.

For the purposes of this experimentation, build a list containing a handful of items (at least 5). The list can be unordered or ordered, as this only changes the list item marker used.