from .abstract_algorithm import AbstractAlgorithm


class Task01(AbstractAlgorithm):

    def solution(self, A, debug):
        enable_print = A % 10
        # print('enable_print is {}'.format(enable_print))
        while A > 0:
            if enable_print == 0 and A % 10 != 0:
                enable_print = 1
            elif enable_print == 1:
                print(A % 10, end="")
            A = A // 10
            # print('  A is {}'.format(A))

    def execute(self):
        self.process(54321, 12345)
        self.process(10011, 11001)
        self.process(1, 1)
