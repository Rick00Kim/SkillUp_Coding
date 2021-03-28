from .abstract_algorithm import AbstractAlgorithm


class Task04(AbstractAlgorithm):

    def solution(self, N, debug):
        if len(N) > 1000000000:
            return -1

        slice_count = 0
        for i in range(len(N)):
            for j in range(i, len(N)):
                # print('Go Index {} {}'.format(i,j), end=' ')
                if i == j:
                    slice_list = [N[i], N[j]]
                else:
                    slice_list = N[i:j+1]
                if len(slice_list) > 1 and sum(slice_list) == 0:
                    slice_count += 1
                    # print('COUNT ADD')
                    if slice_count > 1000000:
                        return -1
                # print()

        print(slice_count)
        return slice_count

    def execute(self):
        self.process([2, -2, 3, 0, 4, -7], 4)
        # self.process(1, 1)
