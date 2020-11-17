import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] c = str.split(" ");
        int[] array = new int[c.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(c[i]);
        }
        System.out.println(bubbleSort(array));
    }

    public static int bubbleSort(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                /* if a pair of adjacent elements has the wrong order it swaps them */
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    count++;
                }
            }
        }

        return count;
    }
}