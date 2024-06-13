import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {
    Node[] data;
    int max;

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

    public Zip(String file) {
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean linear1(String zip) {
        for (int i = 0; i < max; i++) {
            if (data[i].code.equals(zip)) {
                return true;
            }
        }
        return false;
    }

    public boolean binary1(String zip) {
        return (binary1(zip, 0, max-1));
    }

    public boolean binary1(String zip, int min, int max) {
        int mid = (max+min)/2;
        int range = zip.compareTo(data[mid].code);
        if (range == 0) {
            return true;
        } else if (range < 0 && min < mid) {
            return binary1(zip, 0, mid-1);
        } else if (range > 0 && mid < max) {
            return binary1(zip, mid+1, max);
        } else {
            return false;
        }
    }
}
