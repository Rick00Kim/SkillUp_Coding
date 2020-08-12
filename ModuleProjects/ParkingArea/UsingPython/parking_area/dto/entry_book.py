class EntryBook:

    def __init__(self, vehicle_number, client_number, lot_number,
                 car_size, arrival_time, departure_time, hours_of_use,
                 cost_of_use, end_business_flg):
        self._vehicle_number = vehicle_number
        self._client_number = client_number
        self._lot_number = lot_number
        self._car_size = car_size
        self._arrival_time = arrival_time
        self._departure_time = departure_time
        self._hours_of_use = hours_of_use
        self._cost_of_use = cost_of_use
        self._end_business_flg = end_business_flg

    def get_key_tuple(self):
        return self._vehicle_number, self._client_number

    def get_record_tuple(self):
        return (self._vehicle_number,
                self._client_number,
                self._lot_number,
                self._car_size,
                self._arrival_time,
                self._departure_time,
                self._hours_of_use,
                self._cost_of_use,
                self._end_business_flg)
