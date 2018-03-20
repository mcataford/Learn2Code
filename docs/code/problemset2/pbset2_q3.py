"""
If your solution in 2. used composite expressions as conditions, can you
rework if such that only simple expressions are used?
"""

def convert_grades(grade):

  #Ref: https://www.mcgill.ca/study/2015-2016/university_regulations_and_resources/undergraduate/gi_grading_and_grade_point_averages/

  if grade < 50:
    return "F"
  elif grade < 55:
    return "D"
  elif grade < 60:
    return "C"
  elif grade < 65:
    return "C+"
  elif grade < 70:
    return "B-"
  elif grade < 75:
    return "B"
  elif grade < 80:
    return "B+"
  elif grade < 85:
    return "A-"
  else:
    return "A"

student_grade = input("Enter a numerical grade to convert to letters:")

converted_grade = convert_grades(float(student_grade))

print("Your grade of " + str(student_grade) + "% is equivalent to " + converted_grade + ".")