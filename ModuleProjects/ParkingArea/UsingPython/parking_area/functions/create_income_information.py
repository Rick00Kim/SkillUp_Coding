from datetime import datetime
from parking_area.utilities.file_utility import create_csv_file
from parking_area.utilities.time_utility import parse_to_datetime, get_start_on_today, get_end_on_today
from parking_area.functions.base_function import BaseFunction
from parking_area.database.entry_book_repo import EntryBookRepository
from parking_area.constants.parking_area_enums import ParkingAreaEnums
from parking_area.constants.parking_area_constants import ParkingAreaConstants


def show_kinds_income_menu():
    """Show all kinds of income

    :return:
    """
    print("================================")
    for key, value in ParkingAreaConstants.kinds_income_info_dict.items():
        print("{0} : {1}".format(key, value))
    print("================================")


def get_file_path(prefix: str, date_format: str) -> str:
    """Get file path

    :param prefix:
    :param date_format:
    :return:
    """
    return prefix + '_' + datetime.strftime(datetime.now(), date_format)


class CreateIncomeInformation(BaseFunction):
    """Parking Area [Create income information]"""

    # Input field
    income_kinds: str
    from_date: datetime
    to_date: datetime
    function_name = "Create income information"

    def input_func(self):
        # Show income menu
        show_kinds_income_menu()
        self.income_kinds = input('INCOME KINDS : ')
        if self.income_kinds not in ParkingAreaConstants.kinds_income_info_dict.keys():
            print("INCOME KINDS is invalid")
            return ParkingAreaEnums.ResultStatusEnums.FAILURE
        else:
            if self.income_kinds == '2':
                self.from_date = parse_to_datetime(input('FROM DATE : '))
                self.to_date = parse_to_datetime(input('TO DATE : '))
            else:
                self.from_date = get_start_on_today()
                self.to_date = get_end_on_today()
        return ParkingAreaEnums.ResultStatusEnums.SUCCESS

    def validate_func(self):
        return ParkingAreaEnums.ResultStatusEnums.SUCCESS

    def process_func(self):
        # Get list Entry book for income file
        output_list = EntryBookRepository().select_for_income_file(
            (ParkingAreaConstants.CURRENT_LOT_INFORMATION.lot_number,
             self.from_date,
             self.to_date,
             '0')
        )
        if self.income_kinds == '1':
            target_file_path = ParkingAreaConstants.directory_dict['daily_folder'] \
                               + '/' + get_file_path('daily', '%Y%m%d') + '.csv'
            if create_csv_file(target_file_path, output_list):
                # Update Entry book
                for target_update in output_list:
                    EntryBookRepository().update_for_end_business(
                        (target_update.vehicle_number,
                         target_update.client_number,
                         target_update.lot_number))
                return ParkingAreaEnums.ResultStatusEnums.SUCCESS
        else:
            target_file_path = ParkingAreaConstants.directory_dict['custom_folder'] \
                               + '/' + get_file_path('custom', '%Y%m%d%H%M%S') + '.csv'
            if create_csv_file(target_file_path, output_list):
                # Update Entry book
                for target_update in output_list:
                    EntryBookRepository().update_for_end_business(
                        (target_update.vehicle_number,
                         target_update.client_number,
                         target_update.lot_number))
                return ParkingAreaEnums.ResultStatusEnums.SUCCESS

        return ParkingAreaEnums.ResultStatusEnums.FAILURE
