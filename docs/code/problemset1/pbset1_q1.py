"""
Write a Celsius-to-Fahrenheit conversion script. Your final solution should implement the conversion as a function which takes in a temperature in Celsius degrees and outputs a temperature in Fahrenheit degrees. You script should make use of your function and demonstrate the conversion with at least three values. Make sure that your script outputs the results as part of a sentence in which numbers are embedded
"""

def c_to_f(celsius):
  #Ref: https://www.mathsisfun.com/temperature-conversion.html
  return celsius * (9/5) + 32

"""
Test values: 0, 25 and 100, corresponding to freezing, room temperature and boiling.
"""

test1 = 0
test2 = 25
test3 = 100

"""
We use concatenation to output the results nicely. Note that we use str() to convert the numerical results to strings before concatenating.
"""

print(str(test1) + " degrees Celsius is equal to " + str(c_to_f(test1)) + " degrees Fahrenheit.")
print(str(test2) + " degrees Celsius is equal to " + str(c_to_f(test2)) + " degrees Fahrenheit.")
print(str(test3) + " degrees Celsius is equal to " + str(c_to_f(test3)) + " degrees Fahrenheit.")
