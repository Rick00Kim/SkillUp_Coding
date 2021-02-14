"""
LINK : https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
"""
from .abstract_codility import AbstractCodility


class CyclicRotation(AbstractCodility):

    def solution(self, A, K, R):

        print(A[K-1:])
        print(A[:K-1])

        A = A[K-1:] + A[:K-1]

        print("Test Result : {0}".format(A == R))

    def execute(self):
        self.solution([3, 8, 9, 7, 6], 3, [9, 7, 6, 3, 8])
