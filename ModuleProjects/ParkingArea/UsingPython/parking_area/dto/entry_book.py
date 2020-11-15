from sqlalchemy import Column, Integer, String, DateTime
from parking_area.dto.abstract_database_dto import DatabaseDto


class EntryBook(DatabaseDto):
    """Parking Area [Entity of ENTRY_BOOK]

    """
    __tablename__ = 'ENTRY_BOOK'
    vehicle_number = Column('VEHICLE_NUMBER', String, primary_key=True)
    client_number = Column('CLIENT_NUMBER', String, primary_key=True)
    lot_number = Column('LOT_NUMBER', Integer, primary_key=True)
    car_size = Column('CAR_SIZE', String)
    arrival_time = Column('ARRIVAL_TIME', DateTime)
    departure_time = Column('DEPARTURE_TIME', DateTime)
    hours_of_use = Column('HOURS_OF_USE', Integer)
    cost_of_use = Column('COST_OF_USE', Integer)
    end_business_flg = Column('END_BUSINESS_FLG', String)

    def __init__(self,
                 vehicle_number,
                 client_number,
                 lot_number,
                 car_size,
                 arrival_time,
                 departure_time,
                 hours_of_use,
                 cost_of_use,
                 end_business_flg):
        self.vehicle_number = vehicle_number
        self.client_number = client_number
        self.lot_number = lot_number
        self.car_size = car_size
        self.arrival_time = arrival_time
        self.departure_time = departure_time
        self.hours_of_use = hours_of_use
        self.cost_of_use = cost_of_use
        self.end_business_flg = end_business_flg

    def __repr__(self):
        return "<ENTRY_BOOK(vehicle_number='%s', client_number='%s', lot_number='%d', car_size='%s', " \
               "arrival_time='%s', departure_time='%s', hours_of_use='%s', cost_of_use='%s', end_business_flg='%s')>" % (
                   self.vehicle_number, self.client_number, self.lot_number, self.car_size, self.arrival_time,
                   self.departure_time, self.hours_of_use, self.cost_of_use, self.end_business_flg)
