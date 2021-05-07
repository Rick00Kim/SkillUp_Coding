from .abstract_algorithm import AbstractAlgorithm


class PermMissingElem(AbstractAlgorithm):

    def solution(self, A, debug):
        A.sort()
        for i in range(len(A)):
            if i+1 != A[i]:
                result = i+1
                break

        return result

    def execute(self):
        self.process([2, 3, 1, 5], 4)
