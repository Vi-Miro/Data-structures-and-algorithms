public class Binary_Searching {
    public static int binary_search(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while(left <= right) {
            int mid = left + (right - left)/2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sortedArray = {0, 4, 7, 9, 11, 12, 15, 20, 29};

        int target = 15;
        int result = binary_search(sortedArray, target);

        if (result != -1) {
            System.out.println("Element " + target + " is found by index: " + result);
        } else {
            System.out.println("Element " + target + " not found");
        }


        target = 5;
        result = binary_search(sortedArray, target);

        if (result != -1) {
            System.out.println("Element " + target + " is found by index: " + result);
        } else {
            System.out.println("Element " + target + " not found");
        }
    }

}
