from abc import ABC, abstractmethod


class AbstractCodility(ABC):

    def __init__(self):
        super().__init__()

    @abstractmethod
    def solution(self, A):
        pass

    @abstractmethod
    def execute(self):
        print('Start in Abstract class\nPlz call by extended class.')
