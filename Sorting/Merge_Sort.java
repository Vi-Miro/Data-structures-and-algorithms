public class Merge_Sort {
    public static void merge_sort(int [] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right)/2;

            merge_sort(arr, left, middle);
            merge_sort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for(int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }

        for(int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if(leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            }
            else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while(j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void displayArray(int[] arr) {
        for(int num: arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] massive = {23, 5, 55, 7, 99, 110, 3, 37, 1, 2};
        System.out.println("Unsorted: ");
        displayArray(massive);

        merge_sort(massive, 0, massive.length - 1);
        System.out.println("Sorted: ");
        displayArray(massive);
    }
}
