_available_char_arithmetic = {
    "SUM": ('1', '+'),
    "SUB": ('2', '-'),
    "MUL": ('3', '*'),
    "DIV": ('4', '/')
}


class Calculator:
    """
    Base Class for Calculator

    """

    def __init__(self, base_integer, target_integer, arithmetic_char):
        _validate_args(base_integer, target_integer, arithmetic_char)
        self.base_integer = int(base_integer)
        self.target_integer = int(target_integer)
        self.arithmetic_char = arithmetic_char

    def calculate(self):
        for key, value in _available_char_arithmetic.items():
            if str(self.arithmetic_char).upper() == key:
                result_func = value[1]
                break
            elif self.arithmetic_char in value:
                result_func = value[1]
                break

        if result_func is '+':
            return self.base_integer + self.target_integer
        elif result_func is '-':
            return self.base_integer - self.target_integer
        elif result_func is '*':
            return self.base_integer * self.target_integer
        elif result_func is '/':
            return self.base_integer / self.target_integer
        else:
            print("Unexpected Function" + result_func)


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
        result = False
        func_key_list = []
        func_num_list = []
        func_char_list = []
        for k in _available_char_arithmetic.keys():
            func_key_list.append(str(k))
            func_num_list.append(str(_available_char_arithmetic[k][0]))
            func_char_list.append(str(_available_char_arithmetic[k][1]))

        if str(arithmetic_char).upper() not in func_key_list:
            result = True
        if arithmetic_char not in func_num_list:
            result = True
        if arithmetic_char not in func_char_list:
            result = True

        if not result:
            raise Exception

    except Exception as e:
        print("UnExpected Type : Arithmetic_char", e)
