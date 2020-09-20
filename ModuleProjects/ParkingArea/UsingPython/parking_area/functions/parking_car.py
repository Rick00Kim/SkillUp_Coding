from parking_area.functions.base_function import BaseFunction
from parking_area.constants.parking_area_constants import ParkingAreaConstants
from parking_area.constants.parking_area_enums import ParkingAreaEnums


class ParkingCar(BaseFunction):
    """Parking Area [Park new car to free area]

    """

    # Input field
    vehicle_number: str
    car_size: ParkingAreaEnums.CarSize = None

    def input_func(self):
        self.vehicle_number = input("Vehicle number : ")
        input_car_size = input("Car size : ")
        for element in ParkingAreaEnums.CarSize:
            if element.value == input_car_size:
                self.car_size = element
                break

        if self.car_size is None:
            return ParkingAreaEnums.ResultStatusEnums.FAILURE

        return ParkingAreaEnums.ResultStatusEnums.SUCCESS

    def validate_func(self):

        ParkingAreaConstants.CURRENT_LOT_INFORMATION.get_key_tuple()

    def process_func(self):
        pass
