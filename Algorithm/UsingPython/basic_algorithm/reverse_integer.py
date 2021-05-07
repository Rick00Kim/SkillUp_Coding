from .abstract_algorithm import AbstractAlgorithm


class ReverseInteger(AbstractAlgorithm):

    def solution(self, n, debug):

        rev = 0

        while(n > 0):
            a = n % 10
            rev = int(rev * 10 + a)
            n = int(n / 10)

        print(rev)
        return rev

    def execute(self):
        self.process(123, 321)
        self.process(12345, 54321)
        self.process(456, 654)
