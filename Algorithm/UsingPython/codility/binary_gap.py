"""
LINK : https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
"""
from .abstract_codility import AbstractCodility


class BinaryGap(AbstractCodility):

    def solution(self, n, r):
        print('BinaryGap')
        max_gap = len(max(bin(n)[2:].strip('0').strip('1').split('1')))

        print(max_gap)

        str_binary = '{0:b}'.format(n)
        print(str_binary)

        str_binary = str_binary.strip('0')
        print(str_binary)
        str_binary = str_binary.strip('1')
        print(str_binary)
        str_binary = str_binary.split('1')
        print(str_binary)

        result = len(max(str_binary))
        print(result)

        print("Test Result : {0}".format(result == r))

    def execute(self):
        self.solution(1041, 5)
