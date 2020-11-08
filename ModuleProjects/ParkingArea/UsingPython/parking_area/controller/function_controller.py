from parking_area.functions.parking_car import ParkingCar
from parking_area.functions.exiting_car import ExitingCar
from parking_area.functions.view_usage_state import ViewUsageState
from parking_area.functions.create_income_information import CreateIncomeInformation
from parking_area.functions.end_of_business import EndOfBusiness
from parking_area.functions.exit_program import ExitProgram


class FunctionController:

    def __init__(self):
        self.all_function_dict = {
            1: ParkingCar(),
            2: ExitingCar(),
            3: ViewUsageState(),
            4: CreateIncomeInformation(),
            5: EndOfBusiness(),
            6: ExitProgram()
        }

    def execute_function(self, input_func_number):
        if input_func_number == 6:
            print(self.all_function_dict[input_func_number].function_name)
            return True
        else:
            if input_func_number in self.all_function_dict.keys():
                print(input_func_number)
                self.all_function_dict[input_func_number].execute()
                return False
            else:
                print("Invalid Select")
                return False

    def show_menu(self):
        print("================================")
        for key, value in self.all_function_dict.items():
            print("{0} : {1}".format(key, value.function_name))
        print("================================")
