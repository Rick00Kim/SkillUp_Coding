from abc import ABC, abstractmethod


class AbstractAlgorithm(ABC):

    def __init__(self):
        super().__init__()

    def print_test_result(self, result):
        output_format = "\033[34m{}\033[00m" if result else "\033[01m\033[91m{}\033[00m"
        print('Test Result -> ' + output_format.format(result))

    def process(self, input, expected, debug=False):
        self.print_test_result(self.solution(input, debug=debug) == expected)

    @abstractmethod
    def solution(self, A, debug=False) -> str:
        pass

    @abstractmethod
    def execute(self):
        pass
