public class SPC {
    static final int MAX_VALUE = Integer.MAX_VALUE; // Используем максимальное значение для обозначения "бесконечности"

    public static void calculateShortestPaths(int[][] adjacencyMatrix) {
        int vertexCount = adjacencyMatrix.length; // Определяем количество вершин в графе
        int[][] shortestDistances = new int[vertexCount][vertexCount];

        // Инициализация матрицы расстояний
        for (int source = 0; source < vertexCount; source++) {
            for (int target = 0; target < vertexCount; target++) {
                if (source == target) {
                    shortestDistances[source][target] = 0; // Расстояние до самой себя равно 0
                } else if (adjacencyMatrix[source][target] != 0) {
                    shortestDistances[source][target] = adjacencyMatrix[source][target]; // Если имеется ребро
                } else {
                    shortestDistances[source][target] = MAX_VALUE; // Если ребра нет, задаём "бесконечность"
                }
            }
        }

        // Основной алгоритм для нахождения кратчайших путей
        for (int intermediate = 0; intermediate < vertexCount; intermediate++) {
            for (int start = 0; start < vertexCount; start++) {
                for (int end = 0; end < vertexCount; end++) {
                    // Проверяем, можно ли улучшить кратчайшее расстояние через промежуточную вершину
                    if (shortestDistances[start][intermediate] + shortestDistances[intermediate][end] < shortestDistances[start][end]) {
                        shortestDistances[start][end] = shortestDistances[start][intermediate] + shortestDistances[intermediate][end]; // Обновляем расстояние
                    }
                }
            }
        }

        // Печать итоговой матрицы расстояний
        displayResults(shortestDistances);
    }

    // Метод для отображения матрицы кратчайших расстояний
    public static void displayResults(int[][] distances) {
        int vertexCount = distances.length;
        System.out.println("Кратчайшие расстояния между всеми парами вершин:");
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                if (distances[i][j] == MAX_VALUE) {
                    System.out.print("INF "); // Отображаем "INF" для бесконечных расстояний
                } else {
                    System.out.print(distances[i][j] + " "); // Отображаем кратчайшее расстояние
                }
            }
            System.out.println(); // Переход на новую строку после каждой строки матрицы
        }
    }

    // Точка входа в программу
    public static void main(String[] args) {
        // Пример графа, где adjacencyMatrix[i][j] представляет вес ребра от вершины i к вершине j
        // Если ребро отсутствует, устанавливаем 0 (для обозначения отсутствия)
        int[][] adjacencyMatrix = {
                {0, 5, 0, 10},
                {0, 0, 3, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };

        calculateShortestPaths(adjacencyMatrix); // Вызов метода для расчёта кратчайших путей
    }
}

