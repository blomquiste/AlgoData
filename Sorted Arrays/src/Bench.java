import java.util.Random;


class Bench {

    private static void linear(int[] array, int[] indx) {
        for (int i = 0; i < indx.length ; i++) {
            Search.linear(array, indx[i]);
        }
    }

    private static void binary(int[] array, int[] indx) {
        for (int i = 0; i < indx.length ; i++) {
            Search.binary(array, indx[i]);
        }
    }

    private static int[] build_sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = rnd.nextInt(10);


        for (int i = 0; i < n ; i++) {
            array[i] = nxt;
            nxt += rnd.nextInt(10) + 1 ;
        }
        return array;
    }

    public static int[] build_unsorted(int len) {
        Random rnd = new Random();
        int[] rand = new int[len];
        for (int i = 0; i < len; i++) {
            rand[i] = rnd.nextInt();
        }
        return rand;
    }

    private static int[] keys(int loop, int n) {
        Random rnd = new Random();
        int[] indx = new int[loop];
        for (int i = 0; i < loop ; i++) {
            indx[i] = rnd.nextInt(n*5);
        }
        return indx;
    }


    public static void main(String[] args) {

        int[] sizes = {100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600};

        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s%8s%8s\n", "n", "unsorted", "linear", "binary");
        for ( int n : sizes) {

            int loop = 10000;

            int[] array = build_sorted(n);
            int[] unsortedArray = build_unsorted(n);
            int[] indx = keys(loop, n);

            System.out.printf("%8d", n);

            int k = 1000;

            double min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                linear(unsortedArray, indx);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f", (min/loop));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                linear(array, indx);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f", (min/loop));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                binary(array, indx);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f\n" , (min/loop));
        }
        System.out.printf("\n\n\n");

        System.out.printf("# searching through two arrays of length n, time in ns\n");
        System.out.printf("#%7s%8s%8s%8s\n", "n", "unsorted", "binary", "superbinary");
        for ( int n : sizes) {

            int loop = 10000;

            int[] arrayX = build_sorted(n);
            int[] arrayY = build_sorted(n);
            int[] unsortedX = build_unsorted(n);
            int[] unsortedY = build_unsorted(n);

            System.out.printf("%8d", n);

            int k = 1000;

            double min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                Search.unsortedDuplicates(unsortedX, unsortedY);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f", (min/loop));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                Search.binaryDuplicates(arrayX, arrayY);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f", (min/loop));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                Search.superBinaryDuplicates(arrayX, arrayY);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f\n" , (min/loop));
        }
    }
}