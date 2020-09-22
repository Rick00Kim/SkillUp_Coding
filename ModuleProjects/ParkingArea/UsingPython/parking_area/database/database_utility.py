from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker


class DatabaseUtility:
    __engine = create_engine('mysql+pymysql://parkingArea:parkingArea1!@localhost:3306/parkingArea?charset=utf8',
                             echo=True)

    Session = sessionmaker(bind=__engine)

    session = Session()
