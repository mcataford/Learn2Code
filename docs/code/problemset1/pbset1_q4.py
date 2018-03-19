"""
Write a function that prints the following shape:

    ++++++++++
    +        +
    +        +
    +        +
    ++++++++++
"""

def print_shape():
  """
  Note that we use the duplication operator * on strings to simplify the statements.
  """
  print("+" * 10)
  print("+" + " " * 8 + "+")
  print("+" + " " * 8 + "+")
  print("+" + " " * 8 + "+")
  print("+" * 10)

print_shape()