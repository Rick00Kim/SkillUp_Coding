from parking_area.dto.lot_information import LotInformation


class ParkingAreaConstants:
    """Parking Area [Constants Parking Area]

    """
    CURRENT_LOT_INFORMATION: LotInformation = None

    car_size_dict = {'0': 'Small', '1': 'Medium', '2': 'Heavy'}

    kinds_income_info_dict = {'1': 'For day', '2': 'Custom day'}

    directory_dict = {'daily_folder': '/kururuProjects/ParkingArea/file/output/daily',
                      'custom_folder': '/kururuProjects/ParkingArea/file/output/custom'}
