import os
import csv
from pathlib import Path
from parking_area.constants.parking_area_constants import ParkingAreaConstants


def check_directory(target_path) -> bool:
    if os.path.isfile(target_path):
        return False
    else:
        if os.path.exists(target_path):
            return True
        else:
            print('Directory is not exist, create target directory...')
            os.mkdir(Path(target_path))
            return True


def create_csv_file(file_path: str, element_list: list):
    target_path = Path(file_path)
    if check_directory(target_path.parent):
        file = open(target_path, 'w')
        wr = csv.writer(file)
        for element in element_list:
            wr.writerow([ParkingAreaConstants.CURRENT_LOT_INFORMATION.lot_number,
                         ParkingAreaConstants.CURRENT_LOT_INFORMATION.lot_name,
                         element.vehicle_number,
                         element.client_number,
                         element.car_size,
                         element.arrival_time,
                         element.departure_time,
                         element.hours_of_use,
                         element.cost_of_use])
        file.close()
        return True
    else:
        return False
