from datetime import datetime


def parse_to_datetime(date_str: str):
    if date_str or not date_str.strip():
        return None
    try:
        datetime.strptime(date_str, '%Y%m')
    except ValueError as e:
        try:
            print("Invalid date Format(yyyyMM) : {0}".format(e))
            datetime.strptime(date_str, '%Y%m%d')
        except ValueError as e:
            print("Invalid date Format(yyyyMMdd) : {0}".format(e))
            raise ValueError(e)
    if len(date_str) == 6:
        return datetime.strptime(date_str + "01", '%Y%m%d')
    else:
        return datetime.strptime(date_str, '%Y%m%d')


def get_now_datetime() -> datetime:
    return datetime.now()


def get_start_on_today() -> datetime:
    return datetime(datetime.today().year,
                    datetime.today().month,
                    datetime.today().day,
                    0, 0, 0)


def get_end_on_today() -> datetime:
    return datetime(datetime.today().year,
                    datetime.today().month,
                    datetime.today().day,
                    23, 59, 59)
