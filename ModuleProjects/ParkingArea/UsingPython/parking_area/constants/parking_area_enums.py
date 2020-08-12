import enum


class ParkingAreaEnums:
    """
    Enums for Parking Area
    """

    class ResultStatusEnums(enum.Enum):
        # Enums about function Result
        SUCCESS = "Success"
        FAILURE = "Failure"

    class DeleteEnums(enum.Enum):
        # Enums about function Result
        DELETED = "Deleted"
        NOT_DELETED = "Not Deleted"
