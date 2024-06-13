import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;

public class HashTable {
    Bucket[] table;
    int modulo;

    public class Node {
        String code;
        String name;
        Integer pop;

        private Node(String code, String name, Integer pop) {
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
    }

    public class Bucket {
        Integer key;
        Node data;
        Bucket next;

        public Bucket(Integer key, Node data) {
            this.key = key;
            this.data = data;
            this.next = null;
        }
    }

    public HashTable(String file, int tableSize, int modulo) {
        this.table = new Bucket[tableSize];
        this.modulo = modulo;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Node node = new Node(row[0], row[1], Integer.valueOf(row[2]));
                Integer key = Integer.valueOf(row[0].replaceAll("\\s",""));
                Integer index = hashFunction(key);
                add(index, key, node);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Integer hashFunction(Integer key) {
        return key % modulo;
    }

    public void add(Integer index, Integer key, Node node) {
        if (table[index] == null) {
            table[index] = new Bucket(key, node);
        } else {
            Bucket current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Bucket(key, node);
        }
    }

    public Integer lookup(Integer key) {
        int elements = 0;
        Integer row = hashFunction(key);
        if (table[row] == null) {
            elements = -1;
        } else if (Objects.equals(table[row].key, key)) {
                return elements;
        } else {
            Bucket current = table[row];
            while (!Objects.equals(current.key, key)) {
                current = current.next;
                if (current == null) {
                    return -1;
                }
                elements++;
                //System.out.println(elements);

            }
        }
        //System.out.println(elements);
        return elements;
    }
}
