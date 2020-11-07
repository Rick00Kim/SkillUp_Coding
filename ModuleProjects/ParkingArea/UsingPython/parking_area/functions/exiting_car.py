from parking_area.functions.base_function import BaseFunction
from parking_area.constants.parking_area_enums import ParkingAreaEnums
from parking_area.database.entry_book_repo import EntryBookRepository
from parking_area.constants.parking_area_constants import ParkingAreaConstants


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
        exist_count = EntryBookRepository().count_by_primary_key(
            self.vehicle_number,
            'Non-Member',
            ParkingAreaConstants.CURRENT_LOT_INFORMATION.lot_number
        )
        if exist_count is 0:
            return ParkingAreaEnums.ResultStatusEnums.FAILURE
        # When all pass validate, Return Success
        return ParkingAreaEnums.ResultStatusEnums.SUCCESS

    def process_func(self):
        # process exiting car
        print()
