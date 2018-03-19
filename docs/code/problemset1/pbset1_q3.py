"""
Given a number such as `1.1234`, write a script implementing a function that extracts the fractional part of the number.
"""

def extract_fraction(number):
  """
  Note: Since conversion is approximate, you might notice that there is a slight imprecision in the final answer. This is normal and will be addressed later when we look at more advanced math functions available to us.
  """
  return number - int(number)

test0 = 1.1234
test1 = 542.123
test2 = 1

print("The fractional part of " + str(test0) + " is " + str(extract_fraction(test0)))
print("The fractional part of " + str(test1) + " is " + str(extract_fraction(test1)))
print("The fractional part of " + str(test2) + " is " + str(extract_fraction(test2)))