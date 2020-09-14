import mysql.connector
from mysql.connector import errorcode

__config__ = {
    'host': 'localhost',
    'database': 'parkingArea',
    'user': 'parkingArea',
    'password': 'parkingArea1!',
    'port': '3306'
}


class MysqlConnector:
    """Parking Area [Class for MySQL Connection]

    """

    def __init__(self) -> None:
        self._config = __config__

    def get_mysql_connection(self):
        try:
            return mysql.connector.connect(**self._config)
        except mysql.connector.Error as err:
            if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
                print("Something is wrong with your user name or password", err)
            elif err.errno == errorcode.ER_BAD_DB_ERROR:
                print("Database does not exist", err)
            else:
                print(err)
