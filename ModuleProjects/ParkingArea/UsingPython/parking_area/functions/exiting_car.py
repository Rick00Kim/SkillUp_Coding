from datetime import datetime

from parking_area.functions.base_function import BaseFunction
from parking_area.constants.parking_area_enums import ParkingAreaEnums
from parking_area.database.entry_book_repo import EntryBookRepository
from parking_area.constants.parking_area_constants import ParkingAreaConstants
from parking_area.utilities.time_utility import get_now_datetime


def calculate_hours_of_use(from_time: datetime, to_time: datetime) -> int:
    diff = to_time - from_time
    hours = diff.total_seconds() / 3600
    return int(hours)


def calculate_cost_of_use(target_hours: int) -> int:
    if target_hours != 0:
        return target_hours * 1000
    else:
        return 1000


class ExitingCar(BaseFunction):
    """Parking Area [Exit car from parking area]

    """
    vehicle_number: str
    function_name = "Exiting Car"

    def input_func(self):
        # Get input variables
        self.vehicle_number = input("Vehicle number : ")
        # Check input variable(Return Failure if variables is null)
        # VEHICLE NUMBER
        if not self.vehicle_number or not self.vehicle_number.strip():
            print("INPUT Vehicle number is NULL")
            return ParkingAreaEnums.ResultStatusEnums.FAILURE
        # When pass checking input variables, Return Success
        return ParkingAreaEnums.ResultStatusEnums.SUCCESS

    def validate_func(self):
        exist_entry_book = EntryBookRepository().select_by_primary_key(
            (self.vehicle_number,
             'Non-Member',
             ParkingAreaConstants.CURRENT_LOT_INFORMATION.lot_number,)
        )
        if not exist_entry_book:
            return ParkingAreaEnums.ResultStatusEnums.FAILURE
        # When all pass validate, Set into map and Return Success
        self.function_map['target_entry_book'] = exist_entry_book
        return ParkingAreaEnums.ResultStatusEnums.SUCCESS

    def process_func(self):
        # Process exiting car
        target_entry_book = self.function_map['target_entry_book']
        hour_of_use = calculate_hours_of_use(
            target_entry_book.arrival_time,
            get_now_datetime())
        # Update Entry book
        EntryBookRepository().update_for_exit_car(
            (self.vehicle_number,
             'Non-Member',
             ParkingAreaConstants.CURRENT_LOT_INFORMATION.lot_number,),
            (get_now_datetime(),
             hour_of_use,
             calculate_cost_of_use(hour_of_use),)
        )
