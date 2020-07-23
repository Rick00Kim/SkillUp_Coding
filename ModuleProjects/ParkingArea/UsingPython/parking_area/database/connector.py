import mysql.connector
from mysql.connector import errorcode

config = {
    'user': 'parkingArea',
    'password': 'parkingArea1!',
    'host': 'localhost',
    'database': 'parkingArea'
}

try:
    connection = mysql.connector.connect(**config)
except mysql.connector.Error as err:
    if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
        print("Something is wrong with your user name or password", err)
    elif err.errno == errorcode.ER_BAD_DB_ERROR:
        print("Database does not exist", err)
    else:
        print(err)
else:
    connection.close()
    print("MySQL connection is closed")
