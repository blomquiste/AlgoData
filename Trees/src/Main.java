import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000, 64000};
        System.out.printf("#%7s%8s\n", "n", "Lookup");

        int k = 10000;
        for (int n : sizes) {
            System.out.printf("%8d", n);

            BinaryTree tree = new BinaryTree();
            for (int i = 0; i < n; i++) {
                tree.add(randomKey(), randomValue());
            }

            double minT = 10000000;

            for (int i = 0; i < k; i++) {
                int[] arr = new int[1000];
                for (int l = 0; l < arr.length; l++) {
                    arr[l] = randomKey();
                }
                long t0 = System.nanoTime();
                for (int j = 0; j < arr.length; j++)
                    tree.lookup(arr[j]);
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%8.0f\n", minT);
        }
    }

    private static Integer randomKey() {
        Random random = new Random();
        Integer key = random.nextInt(1, 500000);
        return key;
    }

    private static Integer randomValue() {
        Random random = new Random();
        Integer value = random.nextInt(0, 100);
        return value;
    }
}