from abc import ABC, abstractmethod

from parking_area.constants.parking_area_constants import ParkingAreaConstants
from parking_area.constants.parking_area_enums import ParkingAreaEnums


class BaseFunction(ABC):
    """
    Abstract Class for Parking Area Functions
    """

    function_map = {}

    def execute(self):
        # Check Current Lot information
        if ParkingAreaConstants.CURRENT_LOT_INFORMATION is None:
            print('')

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
