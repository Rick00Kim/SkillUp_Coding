import sqlalchemy
from sqlalchemy.exc import IntegrityError
from parking_area.database.database_utility import DatabaseUtility
from parking_area.dto.entry_book import EntryBook
from parking_area.database.condition.check_empty_condition import CountExistEmptyAreaCondition


class EntryBookRepository:

    def __init__(self):
        self.database_utility = DatabaseUtility()

    def count_by_primary_key(self,
                             target_vehicle_number,
                             target_client_number,
                             target_lot_number) -> int:
        return self.database_utility.session.query("RESULT"). \
            from_statement(
            sqlalchemy.text("SELECT COUNT(VEHICLE_NUMBER) AS RESULT FROM ENTRY_BOOK "
                            "WHERE VEHICLE_NUMBER=:vehicle_number "
                            "AND CLIENT_NUMBER=:client_number "
                            "AND LOT_NUMBER=:lot_number")). \
            param(vehicle_number=target_vehicle_number,
                  client_number=target_client_number,
                  lot_number=target_lot_number). \
            first()[0]

    def insert_one_entity(self, target_entity: EntryBook):
        try:
            self.database_utility.session.add(target_entity)
            self.database_utility.session.commit()
        except IntegrityError as error:
            self.database_utility.session.rollback()

    def count_exist_empty_area(self, condition: CountExistEmptyAreaCondition) -> int:
        query_result = self.database_utility.session.query("RESULT"). \
            from_statement(
            sqlalchemy.text("SELECT COUNT(LOT_NUMBER) AS RESULT FROM ENTRY_BOOK "
                            "WHERE LOT_NUMBER=:lot_number "
                            "AND CAR_SIZE=:car_size "
                            "AND ARRIVAL_TIME BETWEEN :time_from AND :time_to "
                            "AND DEPARTURE_TIME IS NULL")). \
            params(lot_number=condition.lot_number,
                   car_size=condition.car_size,
                   time_from=condition.time_from,
                   time_to=condition.time_to) \
            .first()

        return query_result[0]

    def select_entry_book_for_business(self,
                                       lot_number, time_from, time_to, end_business_flg) -> tuple:
        return self.database_utility.session.query(EntryBook). \
            from_statement(
            sqlalchemy.text("SELECT * FROM ENTRY_BOOK "
                            "WHERE LOT_NUMBER=:lot_number "
                            "AND ARRIVAL_TIME BETWEEN :time_from AND :time_to "
                            "AND BUSINESS_FLG=:end_business_flg")). \
            params(lot_number=lot_number, time_from=time_from, time_to=time_to, end_business_flg=end_business_flg). \
            all()
