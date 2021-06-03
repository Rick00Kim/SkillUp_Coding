from .func_base import FunctionBase


class FunctionSimpleStatements(FunctionBase):
    """
    Problem of Simple Statements
    """

    def multiples(self):
        print(self.get_function_information())
        start_idx = 1
        multiples_set = ()

        while start_idx <= 1000:
            if start_idx % 3 is 0:
                multiples_set = multiples_set + (start_idx,)

            start_idx = start_idx + 1

        print(sum(multiples_set))

    def star_1(self):
        print(self.get_function_information())
        target_cnt = int(input("Input Target Integer -> "))
        idx = 1
        while idx <= target_cnt:
            i = 0
            while i < idx:
                print("*", end="")
                i = i + 1

            idx = idx + 1
            print()

    def for_1(self):
        print(self.get_function_information())
        for i in range(1, 101):
            print(i)

    def average(self):
        print(self.get_function_information())
        target_list = [70, 60, 55, 75, 95, 90, 80, 80, 85, 100]
        list_sum = 0
        for element in target_list:
            list_sum += element

        print("Average : {}".format(list_sum / len(target_list)))
