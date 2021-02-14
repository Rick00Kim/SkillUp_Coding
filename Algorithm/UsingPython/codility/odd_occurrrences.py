from .abstract_codility import AbstractCodility


class OddOccurrences(AbstractCodility):
    def solution(self, A, R):
        element_set = set()

        print(A)

        for e in A:
            if e in element_set:
                element_set.discard(e)
            else:
                element_set.add(e)
            print('Element : {0} -> Set : {1}'.format(e, element_set))

        print("Test Result : {0}".format(list(element_set)[0] == R))

    def execute(self):
        self.solution([9, 3, 2, 3, 9, 7, 2], 7)
