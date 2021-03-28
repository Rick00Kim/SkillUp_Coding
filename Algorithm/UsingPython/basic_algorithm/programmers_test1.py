from .abstract_algorithm import AbstractAlgorithm


class ProgrammersTest1(AbstractAlgorithm):

    def solution(self, A, debug):

        temp = 0

        for element in str(A):
            temp += int(element)

        print('Sum of Argument {} : {}'.format(A, temp))

        print(2 % 2)

        if A % temp == 0:
            return True
        else:
            return False

    def execute(self):
        self.process(10, True)
        self.process(12, True)
        self.process(13, False)
        self.process(11, False)
        self.process(2, False)
