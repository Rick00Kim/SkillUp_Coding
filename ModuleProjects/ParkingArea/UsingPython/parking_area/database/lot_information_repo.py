from parking_area.database.database_utility import DatabaseUtility
from parking_area.dto.lot_information import LotInformation


class LotInformationRepository:

    def __init__(self):
        self.database_utility = DatabaseUtility()

    def select_one_by_lot_name(self, input_lot_name):
        return self.database_utility.session.query(LotInformation).filter_by(
            lot_name=input_lot_name).first()
