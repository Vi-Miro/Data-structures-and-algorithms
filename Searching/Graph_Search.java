import java.util.*;

public class Graph_Search {
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph_Search() {
        adjacencyList = new HashMap<>();
    }
    // Добавляем ребро в граф
    public void addEdge(int source, int destination) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // Если граф неориентированный
    }
    // Метод для запуска поиска в глубину
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);
    }
    // Вспомогательный метод для DFS
    private void dfsHelper(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " "); // Обработали узел
        for (int neighbor : adjacencyList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }
    // Метод для запуска поиска в ширину
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " "); // Обработали узел
            for (int neighbor : adjacencyList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph_Search graph = new Graph_Search();
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 7);
        graph.addEdge(4, 3);
        graph.addEdge(4, 8);
        System.out.println("DFS: ");
        graph.dfs(1); // Начинаем с узла 1
        System.out.println("\nBFS: ");
        graph.bfs(1); // Начинаем с узла 1
    }
}
