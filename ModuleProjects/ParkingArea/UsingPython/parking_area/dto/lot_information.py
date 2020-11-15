from sqlalchemy import Column, Integer, String
from parking_area.dto.abstract_database_dto import DatabaseDto


class LotInformation(DatabaseDto):
    """Parking Area [Entity of LOT_INFORMATION]

    """
    __tablename__ = 'LOT_INFORMATION'
    lot_number = Column('LOT_NUMBER', Integer, primary_key=True)
    lot_name = Column('LOT_NAME', String, unique=True)
    acceptable_small = Column('ACCEPTABLE_SMALL', Integer)
    acceptable_medium = Column('ACCEPTABLE_MEDIUM', Integer)
    acceptable_heavy = Column('ACCEPTABLE_HEAVY', Integer)
    del_flg = Column('DEL_FLG', String)

    def __repr__(self):
        return "<LOT_INFORMATION(lot_number='%s', lot_name='%s', acceptable_small='%d', acceptable_medium='%d',acceptable_heavy='%d', del_flg='%s')>" % (
            self.lot_number, self.lot_name, self.acceptable_small, self.acceptable_medium, self.acceptable_heavy,
            self.del_flg)
