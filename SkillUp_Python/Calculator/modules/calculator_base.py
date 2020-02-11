class BaseCalculator:
    """
    Base Class for Calculator
    
    """

    def __init__(self, base_integer, target_integer, arithmetic_char):
        _validate_args(base_integer, target_integer, arithmetic_char)
        self.base_integer = int(base_integer)
        self.target_integer = int(target_integer)
        self.arithmetic_char = arithmetic_char

    def calculate(self):
        pass


def _validate_args(base_integer, target_integer, arithmetic_char):
    try:
        int(base_integer)
    except Exception as e:
        print("UnExpected Type : Base_integer", e)
    try:
        int(target_integer)
    except Exception as e:
        print("UnExpected Type : Target_integer", e)
    try:
        arithmetic_char
    except Exception as e:
        print("UnExpected Type : Arithmetic_char", e)
