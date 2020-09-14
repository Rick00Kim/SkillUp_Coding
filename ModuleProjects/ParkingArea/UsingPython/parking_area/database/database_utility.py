from parking_area.database.connector import MysqlConnector


class DatabaseUtility:
    """Parking Area [Database Utility]
    The executor of SQL statement (CRUD)
    """

    def __init__(self):
        self._connect = MysqlConnector().get_mysql_connection()

    def execute_select_statement(self):
        print(self._connect)

    def execute_insert_statement(self):
        print(self._connect)

    def execute_update_statement(self):
        print(self._connect)

    def execute_delete_statement(self):
        print(self._connect)
