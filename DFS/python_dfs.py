from collections import defaultdict
class Graph():
    def __init__(self):
        self.graph = defaultdict(list)
    def add_edge(self, u, v):
        self.graph[u].append(v)
        self.graph[v].append(u)
    def remove_edge(self, u, v):
        self.graph[u].remove(v)
        self.graph[v].remove(u)
    def get_adjacent_vertices(self, u):
        return self.graph[u]
    def get_number_of_vertices(self):
        return int(len(self.graph))

class DFS():
    def __init__(self, graph):
        self.graph = graph
        visited_array = [False] * self.graph.get_number_of_vertices()
        self.dfs_util(visited_array, 0)
        self.check_if_disconnected(visited_array)
    def dfs_util(self, visited, v):
        visited[v] = True
        print("Now visiting node: %d" % v)
        for i in self.graph.get_adjacent_vertices(v):
            if visited[i] == False:
                self.dfs_util(visited, i)
    def check_if_disconnected(self, visited):
        while self.graph.get_number_of_vertices() != visited.count(True):
            unvisted_vertex = visited.index(False)
            self.dfs_util(visited, unvisted_vertex)

if __name__ == '__main__':
    graph = Graph()
    graph.add_edge(0,1)
    graph.add_edge(1,2)
    graph.add_edge(2,3)
    graph.add_edge(0,3)
    graph.add_edge(4,5)

    dfs = DFS(graph)


