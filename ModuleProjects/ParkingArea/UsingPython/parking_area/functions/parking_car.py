from parking_area.functions.base_function import BaseFunction
from parking_area.constants.parking_area_constants import ParkingAreaConstants


class ParkingCar(BaseFunction):
    """

    """

    def input_func(self):
        ParkingAreaConstants.CURRENT_LOT_INFORMATION = "dd"

    def validate_func(self):
        pass

    def process_func(self):
        pass
