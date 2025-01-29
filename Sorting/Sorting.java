import java.util.Arrays;
import java.util.Random;

public class Sorting {
    private int[] array;

    public Sorting(int[] array) {
        this.array = array;
    }

    public static void insertion_sorting(int[] array) {
        for(int i = 1; i<array.length; i++) {
            int key = array[i];
            int j = i-1;

            while(j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }

    public static void selection_sorting(int[] array) {
        for(int i = 0; i< array.length - 1; i++) {
            int minIndex = i;

            for(int j = i + 1; j< array.length; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.println("Array: " + Arrays.toString(arr));

        int[] arr_insert = Arrays.copyOf(arr, arr.length);
        insertion_sorting(arr_insert);
        System.out.println("Sorted Array (insertion): " + Arrays.toString(arr_insert));

        int[] arr_select = Arrays.copyOf(arr, arr.length);
        selection_sorting(arr_select);
        System.out.println("Sorted Array (selection)" + Arrays.toString(arr_select));

        System.out.println();

        int[] sizes = {10, 100, 500, 1000};

        for (int size : sizes) {
            int[] a = new int[size];

            for (int i = 0; i < a.length; i++) {
                a[i] = random.nextInt(100);
            }

            System.out.println("Array (size" + size + "): " + Arrays.toString(a));

            int[] a_Insertion = Arrays.copyOf(a, a.length);
            long startTime = System.nanoTime();
            insertion_sorting(a_Insertion);
            long endTime = System.nanoTime();
            long insertionSortTime = endTime - startTime;

            System.out.println("Sorted (insert): " + Arrays.toString(a_Insertion));
            System.out.println("Time (insert) " + insertionSortTime + " нс");

            int[] a_Selection = Arrays.copyOf(a, a.length);
            startTime = System.nanoTime();
            selection_sorting(a_Selection);
            endTime = System.nanoTime();
            long selectionSortTime = endTime - startTime;

            System.out.println("Sorted (select): " + Arrays.toString(a_Selection));
            System.out.println("Time (select): " + selectionSortTime + " нс");
            System.out.println();

        }
    }
}
