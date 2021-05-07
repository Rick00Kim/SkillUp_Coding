"""
LINK : https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
"""
from .abstract_algorithm import AbstractAlgorithm


class BinaryGap(AbstractAlgorithm):

    def solution(self, A, debug):
        print('BinaryGap')
        max_gap = len(max(bin(A)[2:].strip('0').strip('1').split('1')))

        print(max_gap)

        str_binary = '{0:b}'.format(A)
        print(str_binary)

        str_binary = str_binary.strip('0')
        print(str_binary)
        str_binary = str_binary.strip('1')
        print(str_binary)
        str_binary = str_binary.split('1')
        print(str_binary)

        result = len(max(str_binary))
        print(result)

        return result

    def execute(self):
        self.process(1041, 5)
