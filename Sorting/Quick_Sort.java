public class Quick_Sort {
    public static void quick_sort(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(arr, start, end);
            quick_sort(arr, start, pivotIndex - 1);
            quick_sort(arr, pivotIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivotValue = arr[end];
        int smallerElementIndex = start - 1;

        for (int currentIndex = start; currentIndex < end; currentIndex++) {
            if(arr[currentIndex] < pivotValue) {
                smallerElementIndex++;
                swap(arr, smallerElementIndex, currentIndex);
            }
        }
        swap(arr, smallerElementIndex+1, end);
        return smallerElementIndex;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void displayArray(int[] arr) {
        for (int num:arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {55, 3, 7, 37, 90, 5};
        System.out.println("Исходный массив: ");
        displayArray(numbers);

        quick_sort(numbers, 0, numbers.length - 1);

        System.out.println("Отсортированный список");
        displayArray(numbers);
    }
}
