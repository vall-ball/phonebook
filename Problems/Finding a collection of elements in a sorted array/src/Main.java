import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }

        int l = scanner.nextInt();
        int[] find = new int[l];
        for (int i = 0; i < l; i++) {
            find[i] = scanner.nextInt();
        }

        int[] answer = new int[l];

        for (int i = 0; i < l; i++) {
            answer[i] = binarySearch(array, find[i], 0, length - 1);
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }


    public static int binarySearch(int[] array, int elem, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2; // the index of the middle element

            if (elem == array[mid]) {
                return mid + 1; // the element is found, return its index
            } else if (elem < array[mid]) {
                right = mid - 1; // go to the left subarray
            } else {
                left = mid + 1;  // go the the right subarray
            }
        }
        return -1; // the element is not found
    }
}