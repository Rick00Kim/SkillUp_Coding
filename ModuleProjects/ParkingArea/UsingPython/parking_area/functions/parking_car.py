from parking_area.dto.entry_book import EntryBook
from parking_area.functions.base_function import BaseFunction
from parking_area.constants.parking_area_constants import ParkingAreaConstants
from parking_area.constants.parking_area_enums import ParkingAreaEnums
from parking_area.database.entry_book_repo import EntryBookRepository
from parking_area.database.condition.check_empty_condition import CountExistEmptyAreaCondition
from parking_area.utilities.time_utility import get_start_on_today, get_end_on_today, get_now_datetime


class ParkingCar(BaseFunction):
    """Parking Area [Park new car to free area]

    """

    # Input field
    vehicle_number: str
    car_size: str
    function_name = "Parking Car"

    def input_func(self):
        # Get input variables
        self.vehicle_number = input("Vehicle number : ")
        input_car_size = input("Car size : ")

        # Check input variables(Return Failure if variables is null)
        # VEHICLE NUMBER
        if not self.vehicle_number or not self.vehicle_number.strip():
            print("INPUT Vehicle number is NULL")
            return ParkingAreaEnums.ResultStatusEnums.FAILURE
        # CAR SIZE
        if not input_car_size or not input_car_size.strip():
            print("INPUT Car size is Null")
            return ParkingAreaEnums.ResultStatusEnums.FAILURE
        else:
            if input_car_size not in ParkingAreaConstants.car_size_dict.keys():
                print("Car Size is invalid")
                return ParkingAreaEnums.ResultStatusEnums.FAILURE
            else:
                self.car_size = input_car_size
        # When all pass checking input variables, Return Success
        return ParkingAreaEnums.ResultStatusEnums.SUCCESS

    def validate_func(self):
        # Check Available parking area
        using_count = EntryBookRepository().count_exist_empty_area(
            CountExistEmptyAreaCondition(
                ParkingAreaConstants.CURRENT_LOT_INFORMATION.lot_number,
                self.car_size,
                get_start_on_today(),
                get_end_on_today()
            )
        )
        # Check available park area
        if self.car_size is '0':
            if using_count >= ParkingAreaConstants.CURRENT_LOT_INFORMATION.acceptable_small:
                return ParkingAreaEnums.ResultStatusEnums.FAILURE
        elif self.car_size is '1':
            if using_count >= ParkingAreaConstants.CURRENT_LOT_INFORMATION.acceptable_medium:
                return ParkingAreaEnums.ResultStatusEnums.FAILURE
        elif self.car_size is '2':
            if using_count >= ParkingAreaConstants.CURRENT_LOT_INFORMATION.acceptable_heavy:
                return ParkingAreaEnums.ResultStatusEnums.FAILURE
        # When all pass validate, Return Success
        return ParkingAreaEnums.ResultStatusEnums.SUCCESS

    def process_func(self):
        # Insert new Entry book
        EntryBookRepository().insert_one_entity(
            EntryBook(
                self.vehicle_number,
                'Non-Member',
                ParkingAreaConstants.CURRENT_LOT_INFORMATION.lot_number,
                self.car_size,
                get_now_datetime(),
                None,
                None,
                None,
                '0'
            )
        )
        return ParkingAreaEnums.ResultStatusEnums.SUCCESS
