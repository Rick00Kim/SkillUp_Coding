from datetime import datetime
from parking_area.functions.base_function import BaseFunction
from parking_area.constants.parking_area_enums import ParkingAreaEnums
from parking_area.constants.parking_area_constants import ParkingAreaConstants


def show_kinds_info_menu():
    print("================================")
    for key, value in ParkingAreaConstants.kinds_income_info_dict.items():
        print("{0} : {1}".format(key, value))
    print("================================")


class CreateIncomeInformation(BaseFunction):
    """Parking Area [Create income information]

    """

    # Input field
    income_kinds: str
    from_date: datetime
    to_date: datetime
    function_name = "Create income information"

    def input_func(self):
        show_kinds_info_menu()
        self.income_kinds = input('INCOME KINDS : ')

        return ParkingAreaEnums.ResultStatusEnums.SUCCESS

    def validate_func(self):
        return ParkingAreaEnums.ResultStatusEnums.SUCCESS

    def process_func(self):
        return ParkingAreaEnums.ResultStatusEnums.SUCCESS
