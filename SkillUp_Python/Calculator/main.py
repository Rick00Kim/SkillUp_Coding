# Python Project Calculator
# 1. Input Compare Based variable(x) and Compare target variable(y).
# 2. Print Arithmetic Function names, Select Function.
# 3. Print Result Arithmetic by x, y

# Import Modules
from modules import Calculator


def print_arithmetic():
    print("=============================")
    print("Addition ->       [Sum, +, 1]")
    print("Subtraction ->    [Sub, -, 2]")
    print("Multiplication -> [Mul, *, 3]")
    print("Division ->       [Div, /, 4]")
    print("=============================")


# Get User Input
x = input("Input Compare Based Integer  -> ")
y = input("Input Compare Target Integer -> ")

# Print Available Arithmetic Functions
print_arithmetic()

func_input = input("Input Function name -> ")

s = Calculator(x, y, func_input)

# Get User Function Character
print(s.calculate())
