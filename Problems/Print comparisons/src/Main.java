import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(jumpSearch(array, i) + " ");
        }
    }

    public static int jumpSearch(int[] array, int target) {
        int currentRight = 0; // right border of the current block
        int prevRight = 0; // right border of the previous block
        int count = 0;

        /* Check the first element */
        if (array[currentRight] == target) {
            return 1;
        }

        /* Calculating the jump length over array elements */
        int jumpLength = (int) Math.sqrt(array.length);

        /* Finding a block where the element may be present */
        while (currentRight < array.length - 1) {
            count++;
            /* Calculating the right border of the following block */
            currentRight = Math.min(array.length - 1, currentRight + jumpLength);

            if (array[currentRight] >= target) {

                break; // Found a block that may contain the target element
            }

            prevRight = currentRight; // update the previous right block border
        }

        /* If the last block is reached and it cannot contain the target value => not found */
        if ((currentRight == array.length - 1) && target > array[currentRight]) {
            return -1;
        }

        /* Doing linear search in the found block */
        return count + backwardSearch(array, target, prevRight, currentRight);
    }

    public static int backwardSearch(int[] array, int target, int leftExcl, int rightIncl) {
        int count = 0;
        for (int i = rightIncl; i > leftExcl; i--) {
            count++;
            if (array[i] == target) {
                return count;
            }
        }
        return -1;
    }
}