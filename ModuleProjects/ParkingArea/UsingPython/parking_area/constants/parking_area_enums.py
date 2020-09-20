import enum


class ParkingAreaEnums:
    """Parking Area [Enums for Parking Area]

    """

    class ResultStatusEnums(enum.Enum):
        # Enums about function Result
        SUCCESS = "Success"
        FAILURE = "Failure"

    class DeleteEnums(enum.Enum):
        # Enums about Delete Flag
        DELETED = "Deleted"
        NOT_DELETED = "Not Deleted"

    class CarSize(enum.Enum):
        # Enums about Car size
        SMALL = "1"
        MEDIUM = "2"
        HEAVY = "3"
