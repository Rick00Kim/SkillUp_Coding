from parking_area.functions.parking_car import ParkingCar
from parking_area.functions.view_usage_state import ViewUsageState


def execute_parking_area():
    print("Parking area start")

    executor = ParkingCar()
    executor.execute()
    print(executor)

    executor1 = ViewUsageState()
    executor1.execute()
    print(executor1)


if __name__ == '__main__':
    execute_parking_area()
