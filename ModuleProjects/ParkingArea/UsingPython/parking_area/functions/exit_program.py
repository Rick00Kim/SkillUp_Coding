from parking_area.functions.base_function import BaseFunction


class ExitProgram(BaseFunction):
    """Parking Area [Exit Program]

    """

    function_name = "Exit Program"

    def input_func(self):
        pass

    def validate_func(self):
        pass

    def process_func(self):
        print("Program exiting...")
