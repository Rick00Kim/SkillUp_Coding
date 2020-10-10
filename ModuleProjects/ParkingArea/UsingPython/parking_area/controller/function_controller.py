from parking_area.functions.parking_car import ParkingCar
from parking_area.functions.exiting_car import ExitingCar
from parking_area.functions.view_usage_state import ViewUsageState
from parking_area.functions.create_income_information import CreateIncomeInformation
from parking_area.functions.end_of_business import EndOfBusiness


class FunctionController:

    def __init__(self):
        self.all_function_dict = {"function_1": [1, ParkingCar()],
                                  "function_2": [2, ExitingCar()],
                                  "function_3": [3, ViewUsageState()],
                                  "function_4": [4, CreateIncomeInformation()],
                                  "function_5": [5, EndOfBusiness()]
                                  }

    def execute_function(self, input_func_number):
        print("EXECUTE function")
        for key, value in self.all_function_dict.items():
            if value[0] is input_func_n13umber:
                value[1].execute()
                return True
        return False

    def show_menu(self):
        print("================================")
        for key, value in self.all_function_dict.items():
            print("{0} : {1}".format(value[0], value[1].function_name))
        print("================================")
