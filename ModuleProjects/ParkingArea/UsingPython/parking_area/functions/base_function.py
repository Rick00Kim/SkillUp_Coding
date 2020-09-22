from abc import ABC, abstractmethod

from parking_area.constants.parking_area_constants import ParkingAreaConstants
from parking_area.constants.parking_area_enums import ParkingAreaEnums
from parking_area.database.database_utility import DatabaseUtility
from parking_area.dto.lot_information import LotInformation


class BaseFunction(ABC):
    """Parking Area [Abstract Class for Parking Area Functions]

    """

    function_map = {}

    def execute(self):
        # Check Current Lot information
        if ParkingAreaConstants.CURRENT_LOT_INFORMATION is None:
            lot_information = DatabaseUtility().session.query(LotInformation).filter_by(
                lot_name=input("What is your Lot Name : ")).first()
            if lot_information is None:
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
