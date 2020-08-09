from parking_area.database.connector import MysqlConnector


class DatabaseUtility:
    """Database Utility

    The executor of SQL statement (CRUD)
    """

    def __init__(self):
        self._connect = MysqlConnector().get_mysql_connection()

    def execute_insert_statement(self):
        print(self._connect)
