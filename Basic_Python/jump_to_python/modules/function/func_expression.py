from .func_base import FunctionBase


class FunctionExpression(FunctionBase):
    """
    Problem of Expression
    """

    def average_score(self):
        print(self.get_function_information())
        student_scores = {"Rick": {"KOR": 80, "ENG": 75, "MATH": 55}
            , "Wisley": {"KOR": 45, "ENG": 20, "MATH": 100}}

        for key, value in student_scores.items():
            avg = (sum(value.values()) / len(value.values()))
            print("""
            Name -> %s
                KOR : %d
                ENG : %d
                MATH: %d
            Average -> %d
            """ % (key, value.get("KOR"), value.get("ENG"), value.get("MATH"), avg))

    def odd_number(self):
        print(self.get_function_information())
        target_integer = int(input("Input Integer -> "))
        if target_integer % 2 is 0:
            print("Your Input Integer is {}".format("Even Number"))
        else:
            print("Your Input Integer is {}".format("Odd Number"))

    def personal_id_1(self):
        print(self.get_function_information())
        mf_dict = {"MALE": [1, 3], "FEMALE": [2, 4]}
        target_personal_id = "881120-1068234"
        target_index = int(target_personal_id[target_personal_id.find('-') + 1])
        for key, value in mf_dict.items():
            if target_index in value:
                print("Result : {}".format(key))
                return

        raise Exception(
            "Unexpected, Personal ID : {}, Target Index : {}".format(target_personal_id, target_index))

    def personal_id_2(self):
        print(self.get_function_information())

    def replace_string(self):
        print(self.get_function_information())
        target = "a:b:c:d"
        print("Before : {}".format(target))
        print("After  : {}".format(target.replace(':', '#')))

    def sort_list(self):
        print(self.get_function_information())
        target_list = [1, 3, 5, 4, 2]
        print("Before : {}".format(target_list))
        target_list.sort(reverse=True)
        print("After  : {}".format(target_list))

    def list_prob(self):
        print(self.get_function_information())
        target_list = ['Life', 'is', 'too', 'short']
        print(' '.join(target_list))

    def tuple_prob(self):
        print(self.get_function_information())
        target_tuple = (1, 2, 3)
        print("Before : {}".format(target_tuple))
        target_tuple = target_tuple + (4,)
        print("After  : {}".format(target_tuple))

    def dictionary_1(self):
        print(self.get_function_information())
        target_dict = {'A': 90, 'B': 80, 'C': 70}
        print(target_dict.pop('B'))

    def list_duplicate(self):
        print(self.get_function_information())
        target_list = [1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5]
        print(set(target_list))
