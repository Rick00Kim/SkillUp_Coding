from datetime import datetime


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
