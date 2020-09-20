import mysql.connector
from mysql.connector import errorcode

__config__ = {
    'host': 'localhost',
    'database': 'parkingArea',
    'user': 'parkingArea',
    'password': 'parkingArea1!',
    'port': '3306'
}


class DatabaseUtility:
    """Parking Area [Database Utility]
    The executor of SQL statement (CRUD)
    """

    def __init__(self):
        try:
            self._connect = mysql.connector.connect(**__config__)
        except mysql.connector.Error as err:
            if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
                print("Something is wrong with your user name or password", err)
            elif err.errno == errorcode.ER_BAD_DB_ERROR:
                print("Database does not exist", err)
            else:
                print(err)

    def execute_select_statement(self, statement, arg_tuple: tuple):

        cursor = self._connect.cursor()
        cursor.execute(statement, arg_tuple)
        return cursor.fetchall()

    def execute_insert_statement(self, statement, arg_tuple: tuple):
        cursor = self._connect.cursor()
        cursor.execute(statement, arg_tuple)
        print(self._connect)

    def execute_update_statement(self, statement, arg_tuple: tuple):
        cursor = self._connect.cursor()
        cursor.execute(statement, arg_tuple)
        print(self._connect)

    def execute_delete_statement(self, statement, arg_tuple: tuple):
        cursor = self._connect.cursor()
        cursor.execute(statement, arg_tuple)
        print(self._connect)
