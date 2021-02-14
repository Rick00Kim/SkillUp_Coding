from .binary_gap import BinaryGap
from .cyclic_rotation import CyclicRotation
from .odd_occurrrences import OddOccurrences
from .perm_missing_element import PermMissingElem


def execute_function():

    func_dict = {'1': BinaryGap(),
                 '2': CyclicRotation(),
                 '3': OddOccurrences(),
                 '4': PermMissingElem()}

    for i, f in func_dict.items():
        print('{0} -> {1}'.format(i, f.__module__))

    user_in = str(input('Function -> '))

    if user_in in func_dict.keys():
        func_dict[user_in].execute()
    else:
        print('Not available...')


if __name__ == "__main__":
    execute_function()
