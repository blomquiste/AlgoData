import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int[] sizes = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600, 1700};
        System.out.printf("#%7s%8s%8s%8s%8s\n", "n", "Doubly", "SingleL", "Doubly", "SingleL");

        int k = 100000;
        for (int n : sizes) {
            System.out.printf("%8d", n);

            double minT = 10000000;

            for (int i = 0; i < k; i++) {
                DoubleLinkedLists dl = new DoubleLinkedLists(n);
                DoubleLinkedLists.Cell[] cellPos = dl.cellIndex;
                long t0 = System.nanoTime();
                dl.unlink(cellPos[random.nextInt(0, n)]);
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%8.0f", (minT));

            minT = 10000000;

            for (int i = 0; i < k; i++) {
                LinkedList ll = new LinkedList(n);
                long t0 = System.nanoTime();
                ll.unlink(random.nextInt(0, n));
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%8.0f", minT);

            minT = 10000000;

            for (int i = 0; i < k; i++) {
                DoubleLinkedLists dl = new DoubleLinkedLists(n);
                DoubleLinkedLists.Cell[] cellPos = dl.cellIndex;
                long t0 = System.nanoTime();
                dl.unlink(cellPos[random.nextInt(n/2, n)]);
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%8.0f", (minT));

            minT = 10000000;

            for (int i = 0; i < k; i++) {
                LinkedList ll = new LinkedList(n);
                long t0 = System.nanoTime();
                ll.unlink(random.nextInt(n/2, n));
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%8.0f\n", minT);
        }
    }

    private static void appendA(int[] a1, int[] a2) {
        int[] newArray = new int[a1.length + a2.length];
        int con = a1.length;
        for (int i = 0; i < a1.length; i++) {
            newArray[i] = a1[i];
        }
        for (int i = 0; i < a2.length; i++) {
            newArray[i + a1.length] = a2[i];
        }
    }
}