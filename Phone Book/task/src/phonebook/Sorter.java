package phonebook;

import java.util.List;

public class Sorter {

    public boolean bubbleSort(List<String> list) {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < list.size() - 1; i++) {
            long now = System.currentTimeMillis();
            if (now - begin > 61000) {
                return false;
            }
            for (int j = 0; j < list.size() - i - 1; j++) {
                /* if a pair of adjacent elements has the wrong order it swaps them */
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    String temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return true;
    }

    public void quickSort(List<String> list, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(list, left, right); // the pivot is already on its place
            quickSort(list, left, pivotIndex - 1);  // sort the left subarray
            quickSort(list, pivotIndex + 1, right); // sort the right subarray
        }
    }

    private int partition(List<String> list, int left, int right) {
        String pivot = list.get(right);  // choose the rightmost element as the pivot
        int partitionIndex = left; // the first element greater than the pivot

        /* move large values into the right side of the array */
        for (int i = left; i < right; i++) {
            if (list.get(i).compareTo(pivot) <= 0) { // may be used '<' as well
                swap(list, i, partitionIndex);
                partitionIndex++;
            }
        }

        swap(list, partitionIndex, right); // put the pivot on a suitable position

        return partitionIndex;
    }

    private void swap(List<String> list, int i, int j) {
        String temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}