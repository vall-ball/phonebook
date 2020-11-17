import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.StreamSupport;

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

            table[idx] = new TableEntry(key, value);
            //System.out.println("idx = " + idx);
            return true;
        }

        public T get(int key) {
            int idx = findKey(key);

            if (idx == -1 || table[idx] == null) {
                return null;
            }

            return (T) table[idx].getValue();
        }

        public void remove(int key) {
            if (table[key] != null) {
                table[key].remove();
                table[key] = null;
            }
        }

        private int findKey(int key) {
            /*int index = 0;
            while (!(table[index] == null)) {
                index = (index + 1) % size;
            }*/
            return key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();
        HashTable<String> hashTable = new HashTable<>(length);

        String[] commands = new String[length];
        for (int i = 0; i < length; i++) {
            commands[i] = scanner.nextLine();
        }

        for (String command : commands) {
            String[] c = command.split(" ");

            switch (c[0]) {

                case "put":
                    hashTable.put(Integer.parseInt(c[1]), c[2]);
                    break;

                case "get":
                    if (hashTable.get(Integer.parseInt(c[1])) == null) {
                        System.out.println(-1);
                    } else {
                        System.out.println(hashTable.get(Integer.parseInt(c[1])));
                    }
                    break;

                case "remove":
                    hashTable.remove(Integer.parseInt(c[1]));
                    break;

                default:
                    break;
            }
        }

    }
}