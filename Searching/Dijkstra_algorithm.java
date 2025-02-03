import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra_algorithm {
    // Вспомогательный класс для работы с парой "вершина - вес"
    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    // Метод для нахождения кратчайших путей
    public static int[] dijkstra(int[][] graph, int start) {
        int n = graph.length; // Количество вершин
        int[] distances = new int[n]; // Массив расстояний
        boolean[] visited = new boolean[n]; // Массив посещенных вершин

        // Заполняем массив расстояний "бесконечностью"
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0; // Расстояние до самой себя = 0

        // Используем приоритетную очередь для обработки вершин
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currentVertex = currentNode.vertex;

            // Если вершина уже посещена, пропускаем ее
            if (visited[currentVertex]) continue;

            visited[currentVertex] = true; // Помечаем вершину как посещенную

            // Обходим соседние вершины
            for (int i = 0; i < n; i++) {
                if (graph[currentVertex][i] != 0 && !visited[i]) { // Если есть связь и вершина не посещена
                    int newDist = distances[currentVertex] + graph[currentVertex][i];

                    // Если найден более короткий путь
                    if (newDist < distances[i]) {
                        distances[i] = newDist; // Обновляем расстояние
                        pq.add(new Node(i, newDist)); // Добавляем в очередь
                    }
                }
            }
        }

        return distances; // Возвращаем массив кратчайших расстояний
    }

    // Пример использования алгоритма
    public static void main(String[] args) {
        // Задаем граф в виде матрицы смежности
        // 0 обозначает отсутствие ребра
        int[][] graph = {
                {0, 4, 7, 1, 10, 6},
                {4, 0, 0, 0, 0, 1},
                {7, 0, 0, 9, 0, 0},
                {1, 0, 9, 0, 5, 0},
                {10, 0, 0, 5, 0, 4},
                {6, 1, 0, 0, 4, 0}
        };

        int startVertex = 0; // Начальная вершина
        int[] shortestDistances = dijkstra(graph, startVertex);

        System.out.println("Кратчайшие расстояния от вершины " + startVertex + ":");
        for (int i = 0; i < shortestDistances.length; i++) {
            System.out.println("До вершины " + i + " = " + shortestDistances[i]);
        }
    }
}