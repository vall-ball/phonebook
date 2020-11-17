import java.util.Scanner;

public class Main {
    private static class TableEntry<T> {
        private final int key;
        private final T value;
        private boolean removed;

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

        public void remove() {
             removed = true;   
        }

        public boolean isRemoved() {
             return removed;   
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
            if (table[idx] == null) {
                table[idx] = new TableEntry(key, value);
                return true;
            }
            return false;
        }

        public T get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (T) table[idx].getValue();
        }

        public void remove(int key) {
            for (int i = 0; i < table.length; i++) {
                if (table[i] != null && table[i].getKey() == key) {
                    table[i].remove();
                    //table[i] = null;
                }
            }
        }

        private int findKey(int key) {
            /*int index = 0;
            while (!(table[index] == null)) {
                index = (index + 1) % size;
            }
            return index;*/
            int hash = key % size;

            while (!(table[hash] == null || table[hash].getKey() == key)) {
                hash = (hash + 1) % size;

                if (hash == key % size) {
                    return -1;
                }
            }

            return hash;
        }

        private void rehash() {
            size *= size * 2;
            TableEntry[] newTable = new TableEntry[size];
            System.arraycopy(table, 0, newTable, 0, size);
            table = newTable;
        }

        @Override
        public String toString() {
            StringBuilder tableStringBuilder = new StringBuilder();

            for (int i = 0; i < table.length; i++) {
                if (table[i] == null) {
                    tableStringBuilder.append(i + ": null");
                } else {
                    tableStringBuilder.append(i + ": key=" + table[i].getKey()
                                                + ", value=" + table[i].getValue()
                                                + ", removed=" + table[i].isRemoved());
                }

                if (i < table.length - 1) {
                    tableStringBuilder.append("\n");
                }
            }

            return tableStringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int add = scanner.nextInt();
        int remove = scanner.nextInt();
        scanner.nextLine();
        int length = 5;
        while (add > length) {
            length *= 2;
        }
        HashTable<String> hashTable = new HashTable<>(length);
        for (int i = 0; i < add; i++) {
            String[] entry = scanner.nextLine().split(" ");
            hashTable.put(Integer.parseInt(entry[0]), entry[1]);
        }

        for (int i = 0; i < remove; i++) {
            hashTable.remove(Integer.parseInt(scanner.nextLine()));
        }

        System.out.println(hashTable);
    }
}