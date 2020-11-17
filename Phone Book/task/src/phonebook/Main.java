package phonebook;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        List<String> list = new ArrayList<>();
        File directory = new File("D:\\programming\\directory.txt");
        Scanner scanner = new Scanner(directory);
        while (scanner.hasNext()) {
            list.add(scanner.nextLine());
        }
        scanner.close();

        List<String> needFind = new ArrayList<>();
        File find = new File("D:\\programming\\find.txt");
        Scanner scannerFind = new Scanner(find);
        while (scannerFind.hasNext()) {
            needFind.add(scannerFind.nextLine());
        }
        scannerFind.close();

        Handler handler = new Handler();
        List<String> preparedList = handler.getList(list);
        Searcher searcher = new Searcher();
        Sorter sorter = new Sorter();
        TimeHandler timeHandler = new TimeHandler();

        System.out.println("Start searching (linear search)...");

        long beginOfLinearSearch = System.currentTimeMillis();
        searcher.linearSearch(needFind, preparedList);
        long endOfLinearSearch = System.currentTimeMillis();
        System.out.println(" Time taken: " + timeHandler.handle(beginOfLinearSearch, endOfLinearSearch));


        System.out.println("Start searching (bubble sort + jump search)...");
        long beginOfSorting = System.currentTimeMillis();
        if (!sorter.bubbleSort(preparedList)) {
            long endOfSorting = System.currentTimeMillis();

            long beginOfLinear = System.currentTimeMillis();
            searcher.linearSearch(needFind, preparedList);
            long endOfLinear = System.currentTimeMillis();

            System.out.println(" Time taken: " + timeHandler.handle(beginOfSorting, endOfLinear));
            System.out.println("Sorting time: " +  timeHandler.handle(beginOfSorting, endOfSorting));
            System.out.println("Searching time: " + timeHandler.handle(beginOfLinear, endOfLinear));
        }

        System.out.println("Start searching (quick sort + binary search)...");
        long beginOfQuickSorting = System.currentTimeMillis();
        sorter.quickSort(preparedList, 0, preparedList.size() - 1);
        long endOfQuickSorting = System.currentTimeMillis();
        long beginOfBinarySearch = System.currentTimeMillis();
        searcher.binarySearch(needFind, preparedList);
        long endOfBinarySearch = System.currentTimeMillis();

        System.out.println(" Time taken: " + timeHandler.handle(beginOfQuickSorting, endOfBinarySearch));
        System.out.println("Sorting time: " +  timeHandler.handle(beginOfQuickSorting, endOfQuickSorting));
        System.out.println("Searching time: " + timeHandler.handle(beginOfBinarySearch, endOfBinarySearch));

        System.out.println("Start searching (hash table)...");
        long beginCreatingHashTable = System.currentTimeMillis();
        Map<String, String> map = handler.getDictionary(list);
        long endCreatingHashTable = System.currentTimeMillis();
        long beginSearchHashTable = System.currentTimeMillis();
        searcher.searchInMap(needFind, map);
        long endSearchHashTable = System.currentTimeMillis();
        System.out.println(" Time taken: " + timeHandler.handle(beginCreatingHashTable, endSearchHashTable));
        System.out.println("Creating time: " +  timeHandler.handle(beginCreatingHashTable, endCreatingHashTable));
        System.out.println("Searching time: " + timeHandler.handle(beginSearchHashTable, endSearchHashTable));


        /*HashTable<String> hashTable = new HashTable<>(500);

        for (String s : preparedList) {
            String[] arr = s.split(" ");
            if (arr.length == 3) {
                hashTable.put(Integer.parseInt(arr[0]), arr[1] + " " + arr[2]);
            } else {
                hashTable.put(Integer.parseInt(arr[1]), arr[0] + arr[1]);
            }
        }

*/
     }

}
