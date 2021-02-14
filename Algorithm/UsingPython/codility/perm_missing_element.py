from .abstract_codility import AbstractCodility


class PermMissingElem(AbstractCodility):

    def solution(self, A, R):
        A.sort()
        for i in range(len(A)):
            if i+1 != A[i]:
                result = i+1
                break

        print("Test Result : {0}".format(result == R))

    def execute(self):
        self.solution([2, 3, 1, 5], 4)
