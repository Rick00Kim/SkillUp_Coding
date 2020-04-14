class FunctionBase:
    def __init__(self, category, sub_menu):
        self.category = category
        self.sub_menu = sub_menu

    def get_function_information(self):
        return "{} in {}".format(self.sub_menu, self.category)
