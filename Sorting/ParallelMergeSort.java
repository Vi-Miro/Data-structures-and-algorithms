import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

public class ParallelMergeSort {
    // Внутренний класс, представляющий задачу слияния для параллельной сортировки
    private static class MergeSortTask extends RecursiveAction {
        private final int[] array; // Массив, который нужно отсортировать
        private final int left; // Индекс начала подмассива
        private final int right; // Индекс конца подмассива

        // Конструктор задачи слияния
        public MergeSortTask(int[] array, int left, int right) {
            this.array = array;
            this.left = left;
            this.right = right;
        }

        @Override
        protected void compute() {
            // Если подмассив состоит из одного элемента, он уже отсортирован
            if (right - left < 2) {
                return;
            }

            // Находим середину подмассива
            int mid = (left + right) / 2;

            // Создаем задачи для сортировки левой и правой половин
            MergeSortTask leftTask = new MergeSortTask(array, left, mid);
            MergeSortTask rightTask = new MergeSortTask(array, mid, right);

            // Параллельно запускаем задачи для обеих половин
            invokeAll(leftTask, rightTask);

            // Сливаем отсортированные половины в общий массив
            merge(array, left, mid, right);
        }

        // Метод для слияния двух отсортированных подмассивов
        private void merge(int[] array, int left, int mid, int right) {
            // Создаем временные массивы для левой и правой половин
            int[] leftArray = new int[mid - left];
            int[] rightArray = new int[right - mid];

            // Копируем данные в временные массивы
            System.arraycopy(array, left, leftArray, 0, leftArray.length);
            System.arraycopy(array, mid, rightArray, 0, rightArray.length);
            // Индексы для перебора временных массивов и результирующего массива
            int i = 0, j = 0, k = left;

            // Сравниваем элементы из двух массивов и заполняем основной массив
            while (i < leftArray.length && j < rightArray.length) {
                if (leftArray[i] <= rightArray[j]) {
                    array[k++] = leftArray[i++]; // Добавляем элемент из левой половины
                } else {
                    array[k++] = rightArray[j++]; // Добавляем элемент из правой половины
                }
            }

            // Копируем оставшиеся элементы из левой половины (если есть)
            while (i < leftArray.length) {
                array[k++] = leftArray[i++];
            }

            // Копируем оставшиеся элементы из правой половины (если есть)
            while (j < rightArray.length) {
                array[k++] = rightArray[j++];
            }
        }
    }

    // Метод для запуска параллельной сортировки
    public static void parallelSort(int[] array) {
        ForkJoinPool pool = new ForkJoinPool(); // Создаем пул потоков
        pool.invoke(new MergeSortTask(array, 0, array.length)); // Запускаем сортировку
    }

    // Главный метод для тестирования параллельной сортировки
    public static void main(String[] args) {
        int[] array = {15, 3, 8, 1, 5, 7, 0, 4, 10}; // Исходный массив

        System.out.println("Исходный массив:");
        for (int num : array) {
            System.out.print(num + " "); // Выводим исходный массив
        }

        parallelSort(array); // Запускаем параллельную сортировку

        System.out.println("\nОтсортированный массив:");
        for (int num : array) {
            System.out.print(num + " "); // Выводим отсортированный массив
        }
    }
}
