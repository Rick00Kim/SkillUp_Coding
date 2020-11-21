from parking_area.dto.lot_information import LotInformation


class ParkingAreaConstants:
    """Parking Area [Constants Parking Area]"""

    # Current lot information
    CURRENT_LOT_INFORMATION: LotInformation = None

    # Dictionary of CAR_SIZE
    car_size_dict = {'0': 'Small', '1': 'Medium', '2': 'Heavy'}

    # Dictionary of KINDS_INCOME_INFORMATION
    kinds_income_info_dict = {'1': 'For day', '2': 'Custom day'}

    # Dictionary of Directory path
    directory_dict = {'daily_folder': '/kururuProjects/ParkingArea/file/output/daily',
                      'custom_folder': '/kururuProjects/ParkingArea/file/output/custom'}
