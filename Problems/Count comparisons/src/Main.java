import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        int find = scanner.nextInt();
        System.out.print(jumpSearch(array, find));
    }

    public static int jumpSearch(int[] array, int target) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int currentRight = 0; // right border of the current block
        int prevRight = 0; // right border of the previous block


        /* Check the first element */
        if (array[currentRight] == target) {
            return 1;
        }
        int count = 1;
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


        /* Doing linear search in the found block */
        //System.out.println("target " + target);
        //System.out.println("count in jumpSearch " + count);
        if (array[currentRight] <= target) {
            return count;
        }
        return count + backwardSearch(array, target, prevRight, currentRight);
    }

    public static int backwardSearch(int[] array, int target, int leftExcl, int rightIncl) {
        int count = 0;
        for (int i = rightIncl - 1; i > leftExcl; i--) {
            count++;
            if (array[i] <= target) {
                //System.out.println("count in backwardSearch " + count);
                return count;
            }
        }
        return count;
    }
}