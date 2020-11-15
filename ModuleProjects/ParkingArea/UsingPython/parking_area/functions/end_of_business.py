from parking_area.functions.base_function import BaseFunction
from parking_area.database.entry_book_repo import EntryBookRepository
from parking_area.constants.parking_area_enums import ParkingAreaEnums
from parking_area.constants.parking_area_constants import ParkingAreaConstants
from parking_area.utilities.time_utility import get_start_on_today, get_end_on_today
from parking_area.utilities.log_utility import output_warn_log


class EndOfBusiness(BaseFunction):
    """Parking Area [End of Business]

    """

    function_name = "End of Business"

    def input_func(self):
        return ParkingAreaEnums.ResultStatusEnums.SUCCESS

    def validate_func(self):
        output_list = EntryBookRepository().select_for_income_file(
            (ParkingAreaConstants.CURRENT_LOT_INFORMATION.lot_number,
             get_start_on_today(),
             get_end_on_today(),
             '0')
        )

        if output_list:
            for warn_target in output_list:
                output_warn_log("Vehicle Number[%s] is not ended. please check" % warn_target.vehicle_number)
            return ParkingAreaEnums.ResultStatusEnums.FAILURE

        return ParkingAreaEnums.ResultStatusEnums.SUCCESS

    def process_func(self):
        return ParkingAreaEnums.ResultStatusEnums.SUCCESS
