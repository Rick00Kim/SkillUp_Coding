from abc import ABC, abstractmethod

from parking_area.constants.parking_area_constants import ParkingAreaConstants
from parking_area.constants.parking_area_enums import ParkingAreaEnums
from parking_area.database.lot_information_repo import LotInformationRepository


class BaseFunction(ABC):
    """Parking Area [Abstract Class for Parking Area Functions]

    """

    function_map = {}
    function_name: str = "BaseFunction"

    def execute(self):
        # Check Current Lot information
        if ParkingAreaConstants.CURRENT_LOT_INFORMATION is None:
            lot_information = LotInformationRepository().select_one_by_lot_name(input("What is your Lot Name : "))
            if lot_information is None:
                print("Lot Information is not exist")
                return
            else:
                ParkingAreaConstants.CURRENT_LOT_INFORMATION = lot_information

        # Call input method for Function
        if self.input_func() is not ParkingAreaEnums.ResultStatusEnums.SUCCESS:
            return

        # Call validate method for Function
        if self.validate_func() is not ParkingAreaEnums.ResultStatusEnums.SUCCESS:
            return

        # Call process method for Function
        if self.process_func() is not ParkingAreaEnums.ResultStatusEnums.SUCCESS:
            return

        # Call finally method after process
        self.finally_func()

    @abstractmethod
    def input_func(self) -> ParkingAreaEnums.ResultStatusEnums:
        pass

    @abstractmethod
    def validate_func(self) -> ParkingAreaEnums.ResultStatusEnums:
        pass

    @abstractmethod
    def process_func(self) -> ParkingAreaEnums.ResultStatusEnums:
        pass

    def finally_func(self):
        self.function_map.clear()
