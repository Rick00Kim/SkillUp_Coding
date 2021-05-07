from .abstract_algorithm import AbstractAlgorithm


class Task03(AbstractAlgorithm):

    def solution(self, A, debug):
        
        for i in range(len(A)):
            for j in range(i, len(A)):
                print('Go Index {} {}'.format(i,j))

        print('Slice test 01 {}'.format(A[0:1]))
        print('Slice test 02 {}'.format(A[0:2]))
        print('Slice test 03 {}'.format(A[0:1]))
        print('Slice test 04 {}'.format(A[0:1]))

    def execute(self):
        self.process([2,-2,3,0,4,-7], 12345)
