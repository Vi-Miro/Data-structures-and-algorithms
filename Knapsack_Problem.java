public class Knapsack_Problem {
    // Метод для решения задачи о рюкзаке
    public static int solveKnapsack(int capacity, int[] itemWeights, int[] itemValues, int itemCount) {
        // Создаем таблицу для хранения максимальных значений
        int[][] dpTable = new int[itemCount + 1][capacity + 1];
        // Заполняем таблицу
        for (int i = 0; i <= itemCount; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 | w == 0) {
                    dpTable[i][w] = 0; // если нет предметов или вместимость равна нулю
                } else if (itemWeights[i - 1] <= w) {
                    // выбираем максимум между включением и не включением предмета
                    dpTable[i][w] = Math.max(dpTable[i - 1][w], itemValues[i - 1] + dpTable[i - 1][w - itemWeights[i - 1]]);
                } else {
                    // не можем включить предмет
                    dpTable[i][w] = dpTable[i - 1][w];
                }
            }
        }
        return dpTable[itemCount][capacity]; // возвращаем максимальное значение
    }


    public static void main(String[] args) {
        int[] itemValues = {5, 10, 50, 100}; // стоимости предметов
        int[] itemWeights = {10, 15, 20, 30}; // веса предметов
        int capacity = 50;
        // максимальная вместимость рюкзака
        int itemCount = itemValues.length;
        int maxValue = solveKnapsack(capacity, itemWeights, itemValues, itemCount);
        System.out.println("Максимальная стоимость предметов в рюкзаке: " + maxValue);
    }
}