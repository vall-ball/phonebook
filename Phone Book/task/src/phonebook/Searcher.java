package phonebook;

import java.util.List;
import java.util.Map;

public class Searcher {
    public void searchInMap(List<String> find, Map<String, String> dictionary) {
        int count = 0;
        for (String s : find) {
            if (dictionary.containsKey(s)) {
                    count++;
                }
            }
        System.out.print("Found " + count + " / " + find.size() + " entries.");
        }




    public void linearSearch(List<String> find, List<String> dictionary) {
        int count = 0;
        for (String s : find) {
            for (String d : dictionary) {
                if (d.equals(s)) {
                    count++;
                }
            }
        }
        System.out.print("Found " + count + " / " + find.size() + " entries.");
    }

    public void binarySearch(List<String> find, List<String> list) {
        int count = 0;
        for (String s : find) {
            if (binarySearchForOne(list, s, 0, list.size() - 1) != -1) {
                count++;
            }
        }
        System.out.print("Found " + count + " / " + find.size() + " entries.");
    }

    public int binarySearchForOne(List<String> list, String elem, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2; // the index of the middle element

            if (elem.equals(list.get(mid))) {
                return mid; // the element is found, return its index
            } else if (elem.compareTo(list.get(mid)) < 0) {
                right = mid - 1; // go to the left subarray
            } else {
                left = mid + 1;  // go the the right subarray
            }
        }
        return -1; // the element is not found
    }

}


/*
     public void  jumpSearch(List<String> find, List<String> dictionary) {
        int count = 0;
        for (String s : find) {
           if (jumpSearchForOne(dictionary, s) != -1) {
               count++;
           }
        }
        System.out.print("Found " + count + " / " + find.size() + " entries.");
    }

    public int jumpSearchForOne(List<String> list, String target) {
        int currentRight = 0; // right border of the current block
        int prevRight = 0; // right border of the previous block


        /* Check the first element
        if (list.get(0).contains(target)) {
                return 0;
                }

                /* Calculating the jump length over array elements
                int jumpLength = (int) Math.sqrt(list.size());

                /* Finding a block where the element may be present
                while (currentRight < list.size() - 1) {

        /* Calculating the right border of the following block
        currentRight = Math.min(list.size() - 1, currentRight + jumpLength);

        if (list.get(currentRight).equals(target) ||  list.get(currentRight).compareTo(target) > 0) {
        break; // Found a block that may contain the target element
        }

        prevRight = currentRight; // update the previous right block border
        }

        /* If the last block is reached and it cannot contain the target value => not found
        if ((currentRight == list.size() - 1) && target.compareTo(list.get(currentRight)) > 0) {
        return -1;
        }

        Doing linear search in the found block
        return backwardSearch(list, target, prevRight, currentRight);
        }

public static int backwardSearch(List<String> array, String target, int leftExcl, int rightIncl) {
        for (int i = rightIncl; i > leftExcl; i--) {
        if (array.get(i).equals(target)) {
        return i;
        }
        }
        return -1;
        }
 */