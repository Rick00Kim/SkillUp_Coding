from .abstract_algorithm import AbstractAlgorithm


class ProgrammersTest2(AbstractAlgorithm):

    def solution(self, A, debug):
        arrs = A['arrs']
        moves = A['moves']
        answer = 0
        bucket = []

        # list_ex = []
        # list_ex.append(2)
        # list_ex.append(1)
        # list_ex.append(5)
        # list_ex.append(4)

        # print(list_ex)
        # list_ex.pop()
        # print(list_ex)

        for arr in arrs:
            print(arr)

        for move in moves:

            for arr in arrs:
                if arr[move - 1] == 0:
                    continue
                else:
                    # bucket.append(arr[move - 1])
                    # arr[move - 1] = 0

                    # bucket.pop()
                    # break

                    if len(bucket) == 0:
                        bucket.append(arr[move - 1])
                        arr[move - 1] = 0
                    else:
                        compare = bucket.pop()
                        if compare == arr[move - 1]:
                            answer += 1
                        else:
                            bucket.append(compare)
                            bucket.append(arr[move - 1])
                        arr[move - 1] = 0
                    break

        for arr in arrs:
            print(arr)

        print(bucket)

        print(answer)

    def execute(self):
        self.process({'arrs': [[0, 0, 0, 0, 0], [0, 0, 1, 0, 3], [0, 2, 5, 0, 1], [
                     4, 2, 4, 4, 2], [3, 5, 1, 3, 1]], 'moves': [1, 5, 3, 5, 1, 2, 1, 4]}, 4)
