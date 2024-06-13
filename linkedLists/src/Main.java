import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int[] sizes = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600};
        System.out.printf("#%7s%8s%8s%8s%8s%8s%8s\n", "n", "L minM", "L an", "L bn", "A minM", "A an", "A bn");

        int k = 100000;
        for (int n : sizes) {
            System.out.printf("%8d", n);

            double minT = 10000000;
            double minM = 10000000;

            for (int i = 0; i < k; i++) {
                long tM = System.nanoTime();
                LinkedList a = new LinkedList(n);
                long timeM = System.nanoTime() - tM;

                LinkedList b = new LinkedList(800);

                long t0 = System.nanoTime();
                a.append(b);
                long time = System.nanoTime() - t0;

                if (timeM < minM)
                    minM = timeM;

                if (time < minT)
                    minT = time;
            }
            //System.out.printf("%8.0f", (minM));
            System.out.printf("%8.0f", (minT));


            minT = 10000000;

            for (int i = 0; i < k; i++) {
                LinkedList a = new LinkedList(800);
                LinkedList b = new LinkedList(n);
                long t0 = System.nanoTime();
                a.append(b);
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%8.0f", minT);

            minT = 10000000;

            long tM = System.nanoTime();
            int[] a1 = new int[n];
            long timeM = System.nanoTime() - tM;
            for (int i = 0; i < a1.length; i++) {
                a1[i] = random.nextInt();
            }
            int[] a2 = new int[800];
            for (int i = 0; i < a2.length; i++) {
                a2[i] = random.nextInt();
            }
            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                appendA(a1, a2);
                long time = System.nanoTime() - t0;

                if (timeM < minM)
                    minM = timeM;

                if (time < minT)
                    minT = time;
            }
            //System.out.printf("%8.0f", minM);
            System.out.printf("%8.0f", minT);

            minT = 10000000;

            a1 = new int[800];
            for (int i = 0; i < a1.length; i++) {
                a1[i] = random.nextInt();
            }
            a2 = new int[n];
            for (int i = 0; i < a2.length; i++) {
                a2[i] = random.nextInt();
            }

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                appendA(a1, a2);
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