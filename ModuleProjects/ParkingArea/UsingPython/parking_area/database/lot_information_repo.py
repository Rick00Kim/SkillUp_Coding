from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import Column, Integer, String
from sqlalchemy.orm import sessionmaker

engine = create_engine('mysql+pymysql://parkingArea:parkingArea1!@localhost:3306/parkingArea?charset=utf8', echo=True)

Base = declarative_base()


class UserInfo(Base):
    __tablename__ = 'USER_INFO'
    user_id = Column(Integer, primary_key=True)
    user_name = Column(String)
    user_age = Column(Integer)
    del_flg = Column(String)

    def __repr__(self):
        return "<UserInfo id=%d, name=%s, age=%d, delFlg=%s>" % (
            self.user_id, self.user_name, self.user_age, self.del_flg)


Session = sessionmaker(bind=engine)

session = Session()

user_info_1 = UserInfo(user_name='TEST_USER', user_age=15, del_flg='0')
session.add(user_info_1)
session.commit()

user_info_selected = session.query(UserInfo).filter_by(user_id=1).first()
print(user_info_selected)
