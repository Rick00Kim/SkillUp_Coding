from .abstract_algorithm import AbstractAlgorithm


class Dijkstra(AbstractAlgorithm):

    def solution(self, A, debug):

        INF = int(1e9)

        n, m = map(int, input().split())

        graph = [[] for i in range(n + 1)]
        print(graph)

        visited = [False] * (n + 1)
        print(visited)

    def execute(self):
        self.solution(None, None)
