from .abstract_algorithm import AbstractAlgorithm


class Task02(AbstractAlgorithm):

    def solution(self, A, debug):
        print(A)
        mix_integer_list = [abs(A)] * (len(str(A)) + 1)

        # print('test String to {}'.format(str(A)[:1]))
        # print('test String from {}'.format(str(A)[1:]))
        
        for i in range(len(mix_integer_list)):
            temp_str = str(mix_integer_list[i])
            if i == 0:
                mix_integer_list[i] = int('5' + temp_str)
            else:
                mix_integer_list[i] = int(temp_str[:i]+ '5' + temp_str[i:])
        if A < 0:
            for i in range(len(mix_integer_list)):
                mix_integer_list[i] = mix_integer_list[i] * -1
        print(mix_integer_list)
        return max(mix_integer_list)

    def execute(self):
        self.process(268, 5268)
        self.process(670, 6750)
        self.process(0, 50)
        self.process(-999, -5999)
