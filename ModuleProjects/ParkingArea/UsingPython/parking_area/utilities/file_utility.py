import os
import csv
from pathlib import Path


def check_directory(target_path) -> bool:
    if os.path.isfile(target_path):
        return False
    else:
        if os.path.exists(target_path):
            return True
        else:
            print('Directory is not exist, create target directory...')
            os.mkdir(Path(target_path))
            return True


def create_csv_file(file_path: str, element_list: list):
    target_path = Path(file_path + '/test.csv')
    if check_directory(target_path.parent):
        file = open(target_path, 'w')
        for element in element_list:
            wr = csv.writer(file)
            wr.writerow(element)
        file.close()
        return True
    else:
        return False
