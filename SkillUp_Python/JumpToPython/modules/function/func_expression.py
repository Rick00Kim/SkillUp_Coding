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

    def personal_id_1(self):
        print(self.get_function_information())

    def personal_id_2(self):
        print(self.get_function_information())

    def replace_string(self):
        print(self.get_function_information())

    def sort_list(self):
        print(self.get_function_information())

    def list_prob(self):
        print(self.get_function_information())

    def tuple_prob(self):
        print(self.get_function_information())

    def dictionary_1(self):
        print(self.get_function_information())

    def dictionary_2(self):
        print(self.get_function_information())

    def list_duplicate(self):
        print(self.get_function_information())
