from parking_area.functions.base_function import BaseFunction
from parking_area.constants.parking_area_constants import ParkingAreaConstants
from parking_area.constants.parking_area_enums import ParkingAreaEnums
from parking_area.database.database_utility import DatabaseUtility
from parking_area.dto.entry_book import EntryBook
from datetime import datetime, timedelta


class ParkingCar(BaseFunction):
    """Parking Area [Park new car to free area]

    """

    # Input field
    vehicle_number: str
    car_size: str

    def input_func(self):
        self.vehicle_number = input("Vehicle number : ")
        input_car_size = input("Car size : ")
        if not input_car_size or not input_car_size.strip():
            print("INPUT Car size is Null")
        else:
            if self.car_size not in ParkingAreaConstants.car_size_dict:
                print("Car Size is invalid")
                return ParkingAreaEnums.ResultStatusEnums.FAILURE
            else:
                self.car_size = input_car_size

        return ParkingAreaEnums.ResultStatusEnums.SUCCESS

    def validate_func(self):
        DatabaseUtility().session.query(EntryBook).filter(
            lot_number=ParkingAreaConstants.CURRENT_LOT_INFORMATION.lot_number,
            car_size=self.car_size
            # TODO Between Date in Where Clause
        )

    def process_func(self):
        pass
