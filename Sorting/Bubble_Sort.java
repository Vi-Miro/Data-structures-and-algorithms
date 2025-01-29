import java.util.Random;

public class Bubble_Sort {
    private int[] array;

    public Bubble_Sort(int[] array) {
        this.array = array;
    }

    public void sort() {
        for(int i = 0; i<array.length; i++) {
            for(int j = 0; j<array.length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    public void display() {
        for(int value: array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr = new int[10];

        Random random = new Random();
        for(int i = 0; i<10; i++) {
            arr[i] = random.nextInt(100);
        }

        Bubble_Sort sorting = new Bubble_Sort(arr);

        System.out.println("Array: ");
        sorting.display();

        sorting.sort();

        System.out.println("Sorted array: ");
        sorting.display();
    }
}
