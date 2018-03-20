"""
 Using the same idea as the one exposed in the snippet above, 
 build a function that sums up all the even numbers between two 
 values `a` and `b` where `a <= b`.
"""

def sum_of_evens(a,b):
  """
  Sums the even numbers in the given [a,b] range.
  """

  #Scenario 1: the lower bound is higher than the higher bound, we end the function.
  if a > b:
    return 0
  #Scenario 2: the current lower bound is even, we add it and recurse.
  elif a % 2 == 0:
    return a + sum_of_evens(a+1,b)
  #Scenario 3: the current lower bound is odd, only recurse and skip the current 'a'
  else:
    return sum_of_evens(a+1,b)

#Test for the interval [0,20]
print(sum_of_evens(0,20))