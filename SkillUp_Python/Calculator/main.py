# Python Project Calculator
# 1. Input Compare Based variable(x) and Compare target variable(y).
# 2. Print Arithmetic Function names, Select Function.
# 3. Print Result Arithmetic by x, y

# Import Modules
from Calculator.modules import BaseCalculator


def print_arithmetic():
    print("===================================")
    print("Addition ->       [Sum,   + ,0]")
    print("Subtraction ->    [Sub,   -, 1]")
    print("Multiplication -> [Multi, *, 2]")
    print("Division ->       [Div,   /, 3]")
    print("===================================")


# Get User Input
x = input("Input Compare Based Integer -> ")
y = input("Input Compare Target Integer -> ")

# Print Available Arithmetic Functions
print_arithmetic()



s = BaseCalculator(x, y, 's')

print(type(s.base_integer))
print(type(s.target_integer))
print(type(s.arithmetic_char))

# Get User Function Character
