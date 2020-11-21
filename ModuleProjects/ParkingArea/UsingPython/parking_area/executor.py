from parking_area.controller.function_controller import FunctionController
from parking_area.utilities.log_utility import *


def execute_parking_area():
    print("Parking area start")
    is_stop = False
    function_controller = FunctionController()

    # Execute main logic until exit program
    while True:
        function_controller.show_menu()
        try:
            is_stop = function_controller.execute_function(int(input("Function Number : ")))
        except ValueError as e:
            output_error_log('INPUT is not INTEGER')
            output_error_log(e)
        if is_stop is True:
            break


if __name__ == '__main__':
    execute_parking_area()
