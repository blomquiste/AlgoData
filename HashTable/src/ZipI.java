import javax.print.attribute.IntegerSyntax;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;

public class ZipI {
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

    public ZipI(String file) {
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data[i++] = new Node(Integer.valueOf(row[0].replaceAll("\\s","")), row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(e);
        }
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
