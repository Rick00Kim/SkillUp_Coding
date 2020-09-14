class LotInformation:
    """Parking Area [Entity of LOT_INFORMATION]

    """

    def __init__(self, lot_number, lot_name, acceptable_small,
                 acceptable_medium, acceptable_heavy, del_flg):
        self._lot_number = lot_number
        self._lot_name = lot_name
        self._acceptable_small = acceptable_small
        self._acceptable_medium = acceptable_medium
        self._acceptable_heavy = acceptable_heavy
        self._del_flg = del_flg

    def get_key_tuple(self):
        return self._lot_number

    def get_record_tuple(self):
        return (self._lot_number,
                self._lot_name,
                self._acceptable_small,
                self._acceptable_medium,
                self._acceptable_heavy,
                self._del_flg)
