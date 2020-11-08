import configparser

config = configparser.RawConfigParser()


class IncomePathProperties:
    def __init__(self):
        config.read('properties/filePath.properties')
        self.income_path_dict = dict(config.items('DIRECTORY_SECTION'))

    def get_daily_path(self):
        return self.income_path_dict['income_daily_dir_path']

    def get_custom_path(self):
        return self.income_path_dict['income_custom_dir_path']
