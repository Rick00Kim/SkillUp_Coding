from datetime import datetime


class CountExistEmptyAreaCondition:
    """ Condition Count exit empty area

    """
    lot_number: str
    car_size: str
    time_from: datetime
    time_to: datetime

    def __init__(self, lot_number, car_size, time_from, time_to):
        self.lot_number = lot_number
        self.car_size = car_size
        self.time_from = time_from
        self.time_to = time_to
