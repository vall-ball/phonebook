import java.util.*;

public class Main {
    private static class TableEntry<T> {
        private final int key;
        private final T value;

        public TableEntry(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }
    }

    private static class HashTable<T> {
        private int size;
        private TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            int idx = findKey(key);

            if (idx == -1) {
                return false;
            }

            table[idx] = new TableEntry(key, value);
            return true;
        }


        public T get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (T) table[idx].getValue();
        }

        public Map<Integer, Set<T>> entrySet() {
            Map<Integer, Set<T>> map = new HashMap<>();
            for (TableEntry t : table) {
                if (map.containsKey(t.getKey())) {
                    map.get(t.getKey()).add((T)t.getValue());
                } else {
                    Set<T> set = new LinkedHashSet<T>();
                    set.add((T)t.getValue());

                    map.put(t.getKey(), set);
                }
            }
            return map;
        }

        private int findKey(int key) {
            int index = 0;
            while (!(table[index] == null)) {
                index = (index + 1) % size;
            }
            return index;
        }

        private void rehash() {
            size *= size * 2;
            TableEntry[] newTable = new TableEntry[size];
            System.arraycopy(table, 0, newTable, 0, size);
            table = newTable;
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();
        HashTable<String> hashTable = new HashTable<>(length);

        for (int i = 0; i < length; i++) {
            String[] s = scanner.nextLine().split(" ");
            int key = Integer.parseInt(s[0]);
            hashTable.put(key, s[1]);
        }
        Map<Integer, Set<String>> map = hashTable.entrySet();
        for (int i : map.keySet()) {
            System.out.print(i + ": ");
            for (String s : map.get(i)) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }
}

/*
int hash = key % size;

            while (!(table[hash] == null)) {
                hash = (hash + 1) % size;

                if (hash == key % size) {
                    return -1;
                }
            }
            return hash;
 */