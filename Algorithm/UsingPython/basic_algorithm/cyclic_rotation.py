"""
LINK : https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
"""
from .abstract_algorithm import AbstractAlgorithm


class CyclicRotation(AbstractAlgorithm):

    def solution(self, A, debug):

        E = A[0]
        K = A[1]

        print(E[K-1:])
        print(E[:K-1])

        return E[K-1:] + E[:K-1]

    def execute(self):
        self.process(([3, 8, 9, 7, 6], 3), [9, 7, 6, 3, 8])
