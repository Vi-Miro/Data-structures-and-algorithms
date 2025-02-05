import java.util.*;

public class PrimAlgorithm {
    // Класс, представляющий ребро графа
    static class Edge {
        int vertex; // Индекс вершины
        int weight; // Вес ребра

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    // Основной метод для выполнения алгоритма Прима
    public static void prim(int[][] graph) {
        int numberOfVertices = graph.length; // Определяем количество вершин в графе
        boolean[] inMST = new boolean[numberOfVertices]; // Массив для отслеживания вклю-чённых в остовное дерево вершин
        int[] key = new int[numberOfVertices]; // Массив для хранения минимальных весов рё-бер
        int[] parent = new int[numberOfVertices]; // Массив для хранения родительских вер-шин

        // Инициализация массивов значениями по умолчанию
        Arrays.fill(key, Integer.MAX_VALUE); // Устанавливаем все ключи в "бесконечность"
        Arrays.fill(parent, -1); // Устанавливаем значения родителей в -1 (неизвестно)
        key[0] = 0; // Начинаем с первой вершины (индекс 0)

        // Создаём приоритетную очередь для управления рёбрами
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        priorityQueue.add(new Edge(0, 0)); // Добавляем первую вершину в очередь

        // Основной цикл алгоритма
        while (!priorityQueue.isEmpty()) {
            int currentVertex = priorityQueue.poll().vertex; // Извлекаем вершину с минималь-ным весом

            inMST[currentVertex] = true; // Добавляем текущую вершину в остовное дерево

            // Обновляем веса соседних вершин
            for (int adjacentVertex = 0; adjacentVertex < numberOfVertices; adjacentVertex++) {
                // Проверяем наличие ребра и то, что вершина ещё не включена в остовное дере-во
                if (graph[currentVertex][adjacentVertex] != 0 && !inMST[adjacentVertex] && graph[currentVertex][adjacentVertex] < key[adjacentVertex]) {
                    key[adjacentVertex] = graph[currentVertex][adjacentVertex]; // Обновляем ми-нимальный вес
                    parent[adjacentVertex] = currentVertex; // Устанавливаем родителя для сосед-ней вершины
                    priorityQueue.add(new Edge(adjacentVertex, key[adjacentVertex])); // Добавляем обновлённую вершину в очередь
                }
            }
        }

        // Выводим результат: рёбра остовного дерева
        displayMST(parent, graph);
    }

    // Метод для отображения рёбер остовного дерева
    private static void displayMST(int[] parent, int[][] graph) {
        System.out.println("Рёбра минимального остовного дерева:");
        for (int i = 1; i < graph.length; i++) {
            System.out.println("Вершина " + parent[i] + " соединена с Вершиной " + i + ", вес: " + graph[i][parent[i]]);
        }
    }

    public static void main(String[] args) {
        // Пример графа в виде матрицы смежности
        int[][] graph = {
                {0, 4, 7, 1, 10},
                {4, 0, 3, 0, 0},
                {7, 3, 0, 9, 0},
                {1, 0, 9, 0, 5},
                {10, 0, 0, 5, 0}
        };

        // Запуск алгоритма Прима для нахождения минимального остовного дерева
        prim(graph);
    }
}
