"""
Can you modify the function in _4_ to allow the caller to give as input a parameter `width`? You can leave the height of your shape constant such that the shape is a rectangle of variable width.
"""


def print_shape(width):
  """
  Note that we use the duplication operator * on strings to simplify the statements.

  We integrate the width parameter with the duplication operator to make the strings wider as needed.
  """
  print("+" * width)
  print("+" + " " * (width - 2) + "+")
  print("+" + " " * (width - 2) + "+")
  print("+" + " " * (width - 2) + "+")
  print("+" * width)

#To test, we use the value 5. Note that a negative value will break the function.
print_shape(5)