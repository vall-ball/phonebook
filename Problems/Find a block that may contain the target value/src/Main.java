import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        int find = scanner.nextInt();

        int[] answer = jumpSearch(array, find);
        if (answer[0] == -1) {
            System.out.println(-1);
        } else {
            System.out.println(answer[0] + " " + answer[1]);
        }
    }

    public static int[] jumpSearch(int[] array, int target) {
        int jumpLength = (int) Math.sqrt(array.length);
        int currentRight = Math.min(array.length - 1, jumpLength) - 1; // right border of the current block
        int prevRight = 0; // right border of the previous block


        /* Check the first element */

        /* Calculating the jump length over array elements */


        /* Finding a block where the element may be present */
        while (currentRight < array.length - 1) {
            if (array[currentRight] >= target) {
                break; // Found a block that may contain the target element
            }
            /* Calculating the right border of the following block */
            prevRight = currentRight;
            currentRight = Math.min(array.length - 1, currentRight + jumpLength);




        }
        if ((currentRight == array.length - 1) && target > array[currentRight]) {
            return new int[] {-1, -1};
        } else {

            int[] answer = new int[2];
            if (prevRight == 0) {
                answer[0] = 0;
            } else {
                answer[0] = prevRight + 1;
            }
            answer[1] = currentRight;
            return answer;
        }
    }


}