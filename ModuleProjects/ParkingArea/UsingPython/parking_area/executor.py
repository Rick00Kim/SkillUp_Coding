from parking_area.controller.function_controller import FunctionController


def execute_parking_area():
    print("Parking area start")
    is_stop = False
    function_controller = FunctionController()

    while True:
        function_controller.show_menu()
        is_stop = function_controller.execute_function(int(input("Function Number : ")))
        if is_stop is True:
            break


if __name__ == '__main__':
    execute_parking_area()
