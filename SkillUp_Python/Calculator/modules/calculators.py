from Calculator.modules.calculator_base import BaseCalculator


class Calculator(BaseCalculator):
    def calculate(self):
        if self.arithmetic_char == 'a':
            return self.base_integer + self.target_integer
        elif self.arithmetic_char == 's':
            return self.base_integer - self.target_integer
        elif self.arithmetic_char == 'm':
            return self.base_integer * self.target_integer
        elif self.arithmetic_char == 'd':
            return self.base_integer / self.target_integer
        else:
            raise Exception("Unexpected Arithmetic")
