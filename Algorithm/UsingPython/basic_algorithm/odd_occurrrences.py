from .abstract_algorithm import AbstractAlgorithm


class OddOccurrences(AbstractAlgorithm):
    def solution(self, A, debug):
        element_set = set()
        print(A)
        for e in A:
            if e in element_set:
                element_set.discard(e)
            else:
                element_set.add(e)
            print('Element : {0} -> Set : {1}'.format(e, element_set))

        return list(element_set)[0]

    def execute(self):
        self.process([9, 3, 2, 3, 9, 7, 2], 7)
