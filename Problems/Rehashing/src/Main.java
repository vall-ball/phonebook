import java.util.Scanner;

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

        private int findKey(int key) {
            int hash = key % size;
            //System.out.println("hash initializing " + hash);
            while (!(table[hash] == null || table[hash].getKey() == key)) {
                //System.out.println("in while");
                //
                hash = (hash + 1) % size;

                if (hash == key % size) {
                    //System.out.println("rehash " + key);
                    rehash();
                    return findKey(key);
                    //hash = (hash + 1) % size;
                }
            }
            //System.out.println("key = " + key + " hash = " + hash);
            return hash;
        }

        private void rehash() {
            TableEntry[] oldTable = table;
            size *= 2;
            //System.out.println("size = " + size);
            TableEntry[] newTable = new TableEntry[size];
            //System.arraycopy(table, 0, newTable, 0, size / 2);
            table = newTable;
            for (TableEntry te : oldTable) {
                this.put(te.getKey(), (T) te.getValue());
            }

        }

        @Override
        public String toString() {
            StringBuilder tableStringBuilder = new StringBuilder();

            for (int i = 0; i < table.length; i++) {
                if (table[i] == null) {
                    tableStringBuilder.append(i + ": null");
                } else {
                    tableStringBuilder.append(i + ": key=" + table[i].getKey()
                                                + ", value=" + table[i].getValue());
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
        int l = Integer.parseInt(scanner.nextLine());

        HashTable<String> hashTable = new HashTable<>(5);

        for (int i = 0; i < l; i++) {
            String[] entry = scanner.nextLine().split(" ");
            //System.out.println("i=" + i);
            hashTable.put(Integer.parseInt(entry[0]), entry[1]);
        }
        System.out.println(hashTable);
    }
}