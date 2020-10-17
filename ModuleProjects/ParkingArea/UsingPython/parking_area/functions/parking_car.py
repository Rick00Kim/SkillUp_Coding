from parking_area.functions.base_function import BaseFunction
from parking_area.constants.parking_area_constants import ParkingAreaConstants
from parking_area.constants.parking_area_enums import ParkingAreaEnums


class ParkingCar(BaseFunction):
    """Parking Area [Park new car to free area]

    """

    # Input field
    vehicle_number: str
    car_size: str
    function_name = "Parking Car"

    def input_func(self):
        self.vehicle_number = input("Vehicle number : ")
        input_car_size = input("Car size : ")
        if self.vehicle_number or not self.vehicle_number.strip():
            print("INPUT Vehicle number is NULL")
            return ParkingAreaEnums.ResultStatusEnums.FAILURE

        if not input_car_size or not input_car_size.strip():
            print("INPUT Car size is Null")
            return ParkingAreaEnums.ResultStatusEnums.FAILURE
        else:
            if input_car_size not in ParkingAreaConstants.car_size_dict.keys():
                print("Car Size is invalid")
                return ParkingAreaEnums.ResultStatusEnums.FAILURE
            else:
                self.car_size = input_car_size

        return ParkingAreaEnums.ResultStatusEnums.SUCCESS

    def validate_func(self):

        pass

    def process_func(self):
        pass
