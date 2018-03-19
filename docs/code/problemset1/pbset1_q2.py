"""
In the script of Question 1, add a function that does the opposite conversion. Verify that any Celsius value can be converted to Fahrenheit and then back to Celsius without significant loss of precision.
"""

def f_to_c(fahrenheit):
  #Ref: https://www.mathsisfun.com/temperature-conversion.html
  return (fahrenheit - 32) * (5/9)

"""
Test values: 0, 25 and 100, corresponding to freezing, room temperature and boiling.
"""

test1 = 32
test2 = 77
test3 = 212

"""
We use concatenation to output the results nicely. Note that we use str() to convert the numerical results to strings before concatenating.
"""

print(str(test1) + " degrees Fahrenheit is equal to " + str(f_to_c(test1)) + " degrees Celsius.")
print(str(test2) + " degrees Fahrenheit is equal to " + str(f_to_c(test2)) + " degrees Celsius.")
print(str(test3) + " degrees Fahrenheit is equal to " + str(f_to_c(test3)) + " degrees Celsius.")