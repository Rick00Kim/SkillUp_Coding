from .abstract_algorithm import AbstractAlgorithm


class TaskAlgorithm(AbstractAlgorithm):

    def solution(self, A, debug):

        set_duplicated = list(set(A))
        A.sort()

        if len(A) == 1:
            return -1

        counted_dict = {}

        for e in set_duplicated:
            counted_dict[e] = A.count(e)

        max_element = max(counted_dict.values())
        max_duplicate = 0

        for k, v in counted_dict.items():

            if v == max_element:
                max_duplicate += 1
                result = k

            if max_duplicate > 1:
                return -1

        return result

    def execute(self):
        self.process([1], -1)
        self.process([1], -1)
        self.process([3], -1)
        self.process([5], -1)
        self.process([1, 2, 3, 4, 5], -1)
        self.process([1, 2, 3, 2, 3], -1)
        self.process([1, 2, 2, 2, 3], 2)
        self.process([3, 1, 2, 4, 4], 4)
        self.process([1, 2, 1, 2, 1], 1)
