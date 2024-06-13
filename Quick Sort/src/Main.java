import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] sizes = {32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384};
        //int[] sizes = {100, 200, 400, 600, 800, 1000, 1200, 1400, 1600, 16000};
        System.out.printf("#%7s%8s%8s\n", "n", "Array", "Linked");

        int k = 1000;
        for (int n : sizes) {
            System.out.printf("%8d", n);

            double minT = 10000000;
            double minD = 10000000;

            for (int i = 0; i < k; i++) {
                int[] array = new int[n];
                ListQS listQ = new ListQS();
                for (int j = 0; j < n; j++) {
                    int value = random.nextInt(0, 2*n);
                    array[j] = value;
                    listQ.add(value);
                }

                long t0 = System.nanoTime();
                ArrayQS.sort(array, 0, array.length-1);
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;

                long t1 = System.nanoTime();
                listQ.sort(listQ.head, listQ.tail);
                long timee = System.nanoTime() - t1;

                if (timee < minD)
                    minD = timee;
            }
            System.out.printf("%8.0f", (minT/k));
            System.out.printf("%8.0f\n", minD/k);
        }
    }
}