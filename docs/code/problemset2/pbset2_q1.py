"""
Revisit the temperature conversion problem of the last problem
set and implement __input validation__ for each of your conversion 
functions. If the value given to your function is below the minimum 
acceptable value, you should return the lowest converted value 
possible, and if the value is above the maximum acceptable value, 
you should return the highest converted value possible. Think of what 
the bounds of your input should be.
"""

def c_to_f(celsius):
  """
  Our general strategy is to have an intermediate variable 'to_convert' which we will
  adjust depending on the result of our validation test.

  If the given celsius value is out of bounds, we will adjust 'to_convert', otherwise, we leave it
  as is. In any case, we convert 'to_convert'.
  """
  to_convert = celsius

  if celsius < -273.15:
    to_convert = -273.15
  
  return to_convert * 9/5 + 32

def f_to_c(fahrenheit):
  """
  See the c_to_f() comment.
  """
  to_convert = fahrenheit

  if fahrenheit < -459.67:
    to_convert = -459.67

  return (to_convert - 32) * (5/9)

test0 = -500
test1 = -273.15
test2 = 100

test3 = -459.67
test4 = 212

print(str(test0) + " degrees Celsius is equivalent to " + str(c_to_f(test0)) + " degrees Fahrenheit.")
print(str(test1) + " degrees Celsius is equivalent to " + str(c_to_f(test1)) + " degrees Fahrenheit.")
print(str(test2) + " degrees Celsius is equivalent to " + str(c_to_f(test2)) + " degrees Fahrenheit.")

print(str(test3) + " degrees Fahrenheit is equivalent to " + str(f_to_c(test3)) + " degrees Celsius.")
print(str(test4) + " degrees Fahrenheit is equivalent to " + str(f_to_c(test4)) + " degrees Calsius.")

