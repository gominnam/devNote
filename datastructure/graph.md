
## Graph

- Graph는 노드(Node)와 그 노드를 연결하는 간선(Edge)으로 이루어진 비선형 자료구조입니다.
- **정점(Vertex)** 과 그 정점을 연결하는 **간선(Edge)** 으로 이루어져 있으며, 다양한 네트워크 모델을 표현할 때 많이 사용됩니다.
- 그래프는 크게 **무방향 그래프 (Undirected Graph)** 와 **방향 그래프 (Directed Graph)** 로 나뉩니다.

</br></br>

### Graph 종류

1. DFS (Depth First Search)
- 깊이 우선 탐색. 정점을 방문하고 그 정점과 연결된 자식 정점을 깊이 따라가며 탐색.

2. BFS (Breadth First Search)
- 너비 우선 탐색. 정점과 그 이웃 정점을 먼저 방문하고 그 후 이웃의 이웃을 방문하며 탐색.


### Graph Example code

```java
import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList;
    
    public Graph() {
        adjList = new HashMap<>();
    }
    
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new LinkedList<>());
    }

    // 간선 추가 (무방향 그래프)
    // 무방향은 양방향으로 이동을 할 수 있다.
    public void addEdge(int vertex1, int vertex2) {
        adjList.get(vertex1).add(vertex2);
        adjList.get(vertex2).add(vertex1);
    }

    // DFS (깊이 우선 탐색)
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(start, visited);
    }

    private void dfsRecursive(int vertex, Set<Integer> visited) {
        if (!visited.contains(vertex)) {
            visited.add(vertex);
            System.out.print(vertex + " ");
            for (int neighbor : adjList.get(vertex)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    // BFS (너비 우선 탐색)
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (int neighbor : adjList.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}

```

- DFS (깊이 우선 탐색)
: DFS는 깊이 있게 탐색을 진행하기 때문에 그래프에서 경로를 찾거나, 트리를 순회할 때 유리합니다.

- BFS (너비 우선 탐색)
: BFS는 너비를 우선으로 탐색하기 때문에 최단 경로를 찾거나, 최단 거리를 구할 때 유리합니다.


  