import java.util.Random;

public class Main {
    public static int[] makeArray(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1, 3000);
        }
        return array;
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        /*int[] n = {16, 32, 64, 128, 256, 512, 1024, 2048};

        for (int i = 0; i < n.length; i++) {
            System.out.println("Selection sort:");
            int[] array = makeArray(n[0]);
            long t0 = System.nanoTime();
            Sorts.selection_sort(array);
            long t1 = System.nanoTime();
            double time1 = t1 - t0;
            System.out.println("Selection sort, n = " + n);
            System.out.println(time1);

            System.out.println("\nInsertion sort:");
            array = makeArray(n[0]);
            t0 = System.nanoTime();
            Sorts.insertion_sort(array);
            t1 = System.nanoTime();
            double time2 = t1 - t0;
            System.out.println("Insertion sort, n = " + n);
            System.out.println(time2);

            System.out.println("\nMerge sort:");
            array = makeArray(n[0]);
            t0 = System.nanoTime();
            Sorts.merge_sort(array);
            t1 = System.nanoTime();
            double time3 = t1 - t0;
            System.out.println("Merge sort, n = " + n);
            System.out.println(time3);
        }*/

        /***************** MANNENS BENCH **************/
        int[] sizes = {100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600};

        System.out.printf("# Sorting an array of length n, time in ns\n");
        System.out.printf("#%7s%8s%8s%8s\n", "n", "Select", "Insert", "Merge");
        for ( int n : sizes) {

            //int loop = 100; //10000 org.??

            int[] array = makeArray(n);

            System.out.printf("%8d", n);

            int k = 1000;

            double min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                Sorts.selection_sort(array);
                long time = System.nanoTime() - t0;
                if (time < min)
                    min = time;
            }

            System.out.printf("%8.0f", min);

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                Sorts.insertion_sort(array);
                long time = System.nanoTime() - t0;
                if (time < min)
                    min = time;
            }

            System.out.printf("%8.0f" , min);

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                Sorts.merge_sort(array);
                long time = System.nanoTime() - t0;
                if (time < min)
                    min = time;
            }

            System.out.printf("%8.0f\n" , min);
        }
    }
}