"""
Using a combination of conditional statements, write a function that __converts__ numerical
grades to letter grades. Your overall script should use __user input__ methods to ask the
user for a numerical grade to convert and should print out a sentence in which the original
entered grade and the converted garde are embedded.
"""

def convert_grades(grade):

  #Ref: https://www.mcgill.ca/study/2015-2016/university_regulations_and_resources/undergraduate/gi_grading_and_grade_point_averages/

  if grade < 50:
    return "F"
  elif grade >= 50 and grade < 55:
    return "D"
  elif grade >= 55 and grade < 60:
    return "C"
  elif grade >= 60 and grade < 65:
    return "C+"
  elif grade >= 65 and grade < 70:
    return "B-"
  elif grade >= 70 and grade < 75:
    return "B"
  elif grade >= 75 and grade < 80:
    return "B+"
  elif grade >= 80 and grade < 85:
    return "A-"
  elif grade >= 85:
    return "A"

student_grade = input("Enter a numerical grade to convert to letters:")

converted_grade = convert_grades(float(student_grade))

print("Your grade of " + str(student_grade) + "% is equivalent to " + converted_grade + ".")