import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;
import javax.print.attribute.IntegerSyntax;

public class ZipIndex {
    Node[] data;
    int max;

    public class Node {
        Integer code;
        String name;
        Integer pop;

        private Node(Integer code, String name, Integer pop) {
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
    }

    public ZipIndex(String file) {
        data = new Node[100000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Node node = new Node(Integer.valueOf(row[0].replaceAll("\\s","")), row[1], Integer.valueOf(row[2]));
                data[node.code] = node;
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean lookup(String zip) {
        Integer zipI = Integer.valueOf(zip.replaceAll("\\s",""));
        if (data[zipI] != null) {
            return true;
        }
        return false;
    }
    public boolean linear2(Integer zip) {
        boolean ret = false;
        for (int i = 0; i < max; i++) {
            if (Objects.equals(data[i].code, zip)) {
                return true;
            }
        }
        return false;
    }

    public boolean binary2(Integer zip) {
        return (binary2(zip, 0, max-1));
    }

    public boolean binary2(Integer zip, int min, int max) {
        int mid = (max+min)/2;
        if (zip == mid) {
            return true;
        } else if (zip < mid && min < mid) {
            return binary2(zip, 0, mid-1);
        } else if (zip > mid && mid < max) {
            return binary2(zip, mid+1, max);
        } else {
            return false;
        }
    }
}
