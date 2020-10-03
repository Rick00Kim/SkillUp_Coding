from parking_area.database.database_utility import DatabaseUtility
from parking_area.dto.entry_book import EntryBook


class EntryBookRepository:

    def __init__(self):
        self.database_utility = DatabaseUtility()

    def count_exist_empty_area(self):
        self.database_utility.session.query(EntryBook)

    def select_entry_book_for_business(self):
        self.database_utility.session.query(EntryBook)
