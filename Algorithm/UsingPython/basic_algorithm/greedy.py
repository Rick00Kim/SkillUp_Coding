from .abstract_algorithm import AbstractAlgorithm


class GreedyAlgorithm(AbstractAlgorithm):

    # Unit list of changed cash
    # Dictionary
    changed_unit_list = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
    count_coin_list = [0] * len(changed_unit_list)

    def solution(self, total, given):

        # Not enough given cash
        if total > given:
            print('Given cash is {0}\nPlz give cash more than total({1})'.format(
                given, total))
            return
        else:
            # Calculate total changed
            total_changed = given - total
            print('Total Changed : {0}'.format(total_changed))
            for i in range(len(self.changed_unit_list)):
                self.count_coin_list[i] = total_changed // self.changed_unit_list[i]
                total_changed %= self.changed_unit_list[i]

        for i in range(len(self.changed_unit_list)):
            print(
                '{0} \t-> {1}'.format(self.changed_unit_list[i], self.count_coin_list[i]))

    def execute(self):
        self.solution(8900, 7000)
        self.solution(3790, 10000)
        self.solution(73820, 90000)
        # Expected change -> 35000 (10000 * 3, 5000 * 1)
        self.solution(15000, 50000)
