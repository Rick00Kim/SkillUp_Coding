import sqlalchemy
from sqlalchemy.exc import IntegrityError
from parking_area.database.database_utility import DatabaseUtility
from parking_area.dto.entry_book import EntryBook
from parking_area.utilities.log_utility import output_error_log


class EntryBookRepository:

    def __init__(self):
        self.database_utility = DatabaseUtility()

    def select_by_primary_key(self, key_tuple: tuple) -> EntryBook:
        """Select entry book by primary key

        :param key_tuple:
        :return: Entry book
        """
        return self.database_utility.session.query(EntryBook) \
            .filter_by(vehicle_number=key_tuple[0],
                       client_number=key_tuple[1],
                       lot_number=key_tuple[2]).first()

    def insert_one_entity(self, target_entity: EntryBook):
        """Insert entry book

        :param target_entity:
        :return: None
        """
        try:
            self.database_utility.session.add(target_entity)
            self.database_utility.session.commit()
        except IntegrityError as error:
            output_error_log(error)
            self.database_utility.session.rollback()

    def count_exist_empty_area(self, condition_tuple: tuple) -> int:
        """Count empty area

        :param condition_tuple:
        :return: count
        """
        query_result = self.database_utility.session.query("RESULT") \
            .from_statement(
            sqlalchemy.text("SELECT COUNT(LOT_NUMBER) AS RESULT FROM ENTRY_BOOK "
                            "WHERE LOT_NUMBER=:lot_number "
                            "AND CAR_SIZE=:car_size "
                            "AND ARRIVAL_TIME BETWEEN :time_from AND :time_to "
                            "AND DEPARTURE_TIME IS NULL")) \
            .params(lot_number=condition_tuple[0],
                    car_size=condition_tuple[1],
                    time_from=condition_tuple[2],
                    time_to=condition_tuple[3]) \
            .first()

        return query_result[0]

    def update_for_exit_car(self,
                            key_tuple: tuple,
                            set_value_tuple: tuple):
        """Update Entry book for exiting car

        :param key_tuple:
        :param set_value_tuple:
        :return: None
        """
        try:
            self.database_utility.session.query(EntryBook) \
                .filter_by(vehicle_number=key_tuple[0],
                           client_number=key_tuple[1],
                           lot_number=key_tuple[2]) \
                .update({EntryBook.departure_time: set_value_tuple[0],
                         EntryBook.hours_of_use: set_value_tuple[1],
                         EntryBook.cost_of_use: set_value_tuple[2]})
            self.database_utility.session.commit()
        except IntegrityError as error:
            output_error_log(error)
            self.database_utility.session.rollback()

    def select_for_income_file(self,
                               condition_tuple: tuple):
        """Select entry book for output file

        :param condition_tuple:
        :return: list entry book
        """
        return self.database_utility.session.query(EntryBook) \
            .from_statement(
            sqlalchemy.text("SELECT * FROM ENTRY_BOOK "
                            "WHERE LOT_NUMBER=:lot_number "
                            "AND ARRIVAL_TIME BETWEEN :time_from AND :time_to "
                            "AND END_BUSINESS_FLG=:business_flg")) \
            .params(lot_number=condition_tuple[0],
                    time_from=condition_tuple[1],
                    time_to=condition_tuple[2],
                    business_flg=condition_tuple[3]) \
            .all()

    def update_for_end_business(self,
                                key_tuple: tuple):
        """Update entry book of end business

        :param key_tuple:
        :return: None
        """
        try:
            self.database_utility.session.query(EntryBook) \
                .filter_by(vehicle_number=key_tuple[0],
                           client_number=key_tuple[1],
                           lot_number=key_tuple[2]) \
                .update({EntryBook.end_business_flg: '1'})
            self.database_utility.session.commit()
        except IntegrityError as error:
            output_error_log(error)
            self.database_utility.session.rollback()
