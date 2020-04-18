from operator import eq
from .function import FunctionExpression, FunctionSimpleStatements, FunctionCompoundStatements


class ProblemFactory:
    """
    Problem Factory
    """

    def __init__(self, category, sub_menu):
        self.category = category
        self.sub_menu = sub_menu

    def execute(self):
        if eq(self.category, "Expression"):
            target_class = FunctionExpression(self.category, self.sub_menu)
            if eq(self.sub_menu, "Average Score"):
                target_class.average_score()
                return
            elif eq(self.sub_menu, "Odd Number"):
                target_class.odd_number()
                return
            elif eq(self.sub_menu, "Personal ID_1"):
                target_class.personal_id_1()
                return
            elif eq(self.sub_menu, "Personal ID_2"):
                target_class.personal_id_2()
                return
            elif eq(self.sub_menu, "Replace String"):
                target_class.replace_string()
                return
            elif eq(self.sub_menu, "Sort List"):
                target_class.sort_list()
                return
            elif eq(self.sub_menu, "List"):
                target_class.list_prob()
                return
            elif eq(self.sub_menu, "Tuple"):
                target_class.tuple_prob()
                return
            elif eq(self.sub_menu, "Dictionary1"):
                target_class.dictionary_1()
                return
            elif eq(self.sub_menu, "ListDuplicate"):
                target_class.list_duplicate()
                return
            else:
                raise Exception('UnExpected menu, Category : {}, SubMenu : {}'.format(self.category, self.sub_menu))

        elif eq(self.category, "Simple statements"):
            target_class = FunctionSimpleStatements(self.category, self.sub_menu)
            if eq(self.sub_menu, "Multiples"):
                target_class.multiples()
                return
            elif eq(self.sub_menu, "Stars 1"):
                target_class.star_1()
                return
            elif eq(self.sub_menu, "for 1"):
                target_class.for_1()
                return
            elif eq(self.sub_menu, "Average"):
                target_class.average()
                return
            elif eq(self.sub_menu, "List Comprehension"):
                target_class.list_comprehension()
                return
            else:
                raise Exception('UnExpected menu, Category : {}, SubMenu : {}'.format(self.category, self.sub_menu))

        else:
            raise Exception('Unexpected Category')
