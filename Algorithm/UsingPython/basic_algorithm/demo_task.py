import random
from .abstract_algorithm import AbstractAlgorithm


class DemoTask(AbstractAlgorithm):

    def solution(self, A, debug):
        result = len(A) + 1

        A = list(set(A))
        A.sort()

        if debug:
            print('A Array status {0}'.format(A))

        init_integer = 0

        if len(A) == 1:
            result = 1 if A[0] < 0 else A[0] + 1
        else:
            for i in A:
                if i < 0:
                    result = 1
                elif i == 0:
                    result = 0
                else:
                    init_integer += 1
                    if init_integer != i:
                        result = init_integer
                        break

        return result

    def execute(self):
        self.process([1, ], 2)
        self.process([-2, ], 1)
        self.process([0, ], 1)
        self.process([1, 3, 6, 4, 1, 2], 5)
        self.process([1, 2, 3], 4)
        self.process([-1, -3], 1)
        self.process([-1, -2, 2, 5, 1, 3, 6], 4)
        failed_1_array = list(range(0, 101)) + list(range(102, 201))
        random.shuffle(failed_1_array)
        self.process(failed_1_array, 101, debug=False)
