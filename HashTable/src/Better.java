import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;

public class Better {
    Node[] table;
    int SIZE = 20000;
    int modulo;

    public class Node {
        String code;
        String name;
        Integer pop;
        Integer key;

        private Node(String code, String name, Integer pop, Integer key) {
            this.code = code;
            this.name = name;
            this.pop = pop;
            this.key = key;
        }
    }

    public Better(String file, int modulo) {
        this.table = new Node[SIZE];
        this.modulo = modulo;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Node node = new Node(row[0], row[1], Integer.valueOf(row[2]), null);
                node.key = Integer.valueOf(row[0].replaceAll("\\s",""));
                Integer index = hashFunction(node.key);
                add(index, node);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Integer hashFunction(Integer key) {
        return (key % modulo);
    }

    public void add(Integer index, Node node) {
        if (table[index] == null) {
            table[index] = node;
        } else {
            while (table[index] != null) {
                index++;
            }
            table[index] = node;
        }
    }

    public Integer lookup(Integer key) {
        int elements = 0;
        Integer wantedIndex = hashFunction(key);
        if (table[wantedIndex] == null) {
            return -1;
        } else if (Objects.equals(table[wantedIndex].key, key)) {
            return elements;
        } else {
            while (!Objects.equals(table[wantedIndex].key, key)) {
                wantedIndex++;
                if (table[wantedIndex] == null) {
                    return -1;
                }
                elements++;
            }
        }
        return elements;
    }
}
