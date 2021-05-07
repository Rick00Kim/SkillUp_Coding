from .binary_gap import BinaryGap
from .cyclic_rotation import CyclicRotation
from .odd_occurrrences import OddOccurrences
from .perm_missing_element import PermMissingElem
from .dijkstra import Dijkstra
from .demo_task import DemoTask
from .greedy import GreedyAlgorithm
from .task import TaskAlgorithm
from .programmers_test1 import ProgrammersTest1
from .programmers_test2 import ProgrammersTest2
from .task_1 import Task01
from .task_2 import Task02
from .task_3 import Task03
from .task_4 import Task04
from .reverse_integer import ReverseInteger


def execute_function():

    func_dict = {
        '1': BinaryGap(),
        '2': CyclicRotation(),
        '3': OddOccurrences(),
        '4': PermMissingElem(),
        '5': Dijkstra(),
        '6': DemoTask(),
        '7': GreedyAlgorithm(),
        '8': TaskAlgorithm(),
        '9': ProgrammersTest1(),
        '10': ProgrammersTest2(),
        '11': Task01(),
        '12': Task02(),
        '13': Task03(),
        '14': Task04(),
        '15': ReverseInteger(),
    }

    for i, f in func_dict.items():
        print('{0} -> {1}'.format(i, f.__class__.__name__))

    user_in = str(input('Function -> '))

    if user_in in func_dict.keys():
        func_dict[user_in].execute()
    else:
        print('Not available...')


if __name__ == "__main__":
    execute_function()
