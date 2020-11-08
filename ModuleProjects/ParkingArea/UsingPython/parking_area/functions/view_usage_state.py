from parking_area.functions.base_function import BaseFunction
from parking_area.constants.parking_area_enums import ParkingAreaEnums
from parking_area.database.entry_book_repo import EntryBookRepository
from parking_area.constants.parking_area_constants import ParkingAreaConstants
from parking_area.utilities.time_utility import get_start_on_today, get_end_on_today


class ViewUsageState(BaseFunction):
    """Parking Area [View usage state]

    """

    function_name = "View usage state"
    target_view_dict = {}

    def input_func(self):
        self.target_view_dict = {
            '0': (ParkingAreaConstants.CURRENT_LOT_INFORMATION.acceptable_small, 0),
            '1': (ParkingAreaConstants.CURRENT_LOT_INFORMATION.acceptable_medium, 0),
            '2': (ParkingAreaConstants.CURRENT_LOT_INFORMATION.acceptable_heavy, 0)
        }

        for key, value in self.target_view_dict.items():
            print(key)
            temp = list(value)
            temp[1] = EntryBookRepository().count_exist_empty_area(
                (ParkingAreaConstants.CURRENT_LOT_INFORMATION.lot_number,
                 key,
                 get_start_on_today(),
                 get_end_on_today())
            )
            self.target_view_dict[key] = tuple(temp)
        return ParkingAreaEnums.ResultStatusEnums.SUCCESS

    def validate_func(self):
        return ParkingAreaEnums.ResultStatusEnums.SUCCESS

    def process_func(self):
        print("LOT Name : {0}".format(ParkingAreaConstants.CURRENT_LOT_INFORMATION.lot_name))
        for key, value in self.target_view_dict.items():
            print("%8s\t -> Max: %2d, Current: %2d" % (
                ParkingAreaConstants.car_size_dict[key],
                value[0],
                value[1]))
        return ParkingAreaEnums.ResultStatusEnums.SUCCESS
