# Algorithm practice using Python

Implement Algorithm testing using Python

Python version : _3.8.2 64bit_

### 1. How to execute algorithm module

🕹 `Execute Command`

```console
python3 -m basic_algorithm
```

🕹 `Show menu`

```console
1 -> basic_algorithm.binary_gap
2 -> basic_algorithm.cyclic_rotation
3 -> basic_algorithm.odd_occurrrences
4 -> basic_algorithm.perm_missing_element
5 -> basic_algorithm.dijkstra
6 -> basic_algorithm.demo_task
7 -> basic_algorithm.greedy
8 -> basic_algorithm.task
Function ->
```

🕹 `Choose Function number`

You can choose function number

`How to Implement new algorithm?`

- Create new Python file with algorithm name
- Write class for new algorithm
  (You have to extends Abstract algorithm class)

⭐️ File name: {Algorhtm name}.py

⭐️ Write Class

```python
from .abstract_algorithm import AbstractAlgorithm


class {Algorithm name}(AbstractAlgorithm):
```

⭐️ Write Abstract method (It necessary)

```python
def solution(self, A, debug):

def execute(self):
```

### 2. Flow

All functions for algorithm extends [Abstract Algorithm class](./basic_algorithm/abstract_algorithm.py)

> #print_test_result
>
> > parameter 1 : bool (Test Result, success->True, failure->False)

> #process
>
> > call #print_test_result

<hr>
REFERENCE : <a href ="https://dojang.io/mod/page/view.php?id=2151">Coding Dojang</a>
