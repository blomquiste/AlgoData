import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        /****** LIST ******/


        int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400};
        System.out.printf("#%7s%11s%11s\n", "n", "Unsorted", "Sorted");

        int k = 10000;
        for (int n : sizes) {
            System.out.printf("%8d", n);

            Integer[] prios = new Integer[n];
            Integer[] sp = new Integer[n];

            for (int p = 0; p < n; p++) {
                prios[p] = random.nextInt(0, n*2);
                sp[p] = p;
            }

            double minT = 1000000000;

            List list = new List();
            for ( int j = 0; j < k; j++) {
                long t0 = System.nanoTime();
                for (int i = 0; i < n; i++) {
                    list.add1(prios[i]);
                }
                for (int i = 0; i < n; i++) {
                    list.removen();
                }
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%11.0f", minT);


            minT = 1000000000;
            list.head = null;

            for ( int j = 0; j < k; j++) {
                long t0 = System.nanoTime();
                for (int i = 0; i < n; i++) {
                    list.addn(prios[i]);
                }
                for (int i = 0; i < n; i++) {
                    list.remove1();
                }
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%11.0f\n", minT);
            //System.out.println("\n\n");

        }

/*************** HEAP ************************/

/*
        int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400, 12800, 25600, 100000};
        System.out.printf("#%7s%11s%11s\n", "n", "Push", "Omständing");

        int k = 10000;
        for (int n : sizes) {
            System.out.printf("%8d", n);

            Heap heap = new Heap();
            Heap heapy = new Heap();
            for (int p = 0; p < n; p++) {
                Integer ranP = random.nextInt(0, 10000);
                heap.add(ranP);
                heapy.add(ranP);
            }

            Integer[] incr = new Integer[1023];
            for (int c = 0; c < 1023; c++) {
                incr[c] = random.nextInt(10, 10000);
            }

            double minT = 1000000000;

            for ( int j = 0; j < k; j++) {
                long t0 = System.nanoTime();
                for (int i = 0; i < incr.length; i++) {
                    heap.push(incr[i]);
                }
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%11.0f", minT);
            //System.out.println(time);


            minT = 1000000000;

            for ( int j = 0; j < k; j++) {
                long t0 = System.nanoTime();
                for (int i = 0; i < incr.length; i++) {
                Heap.Node node = heapy.remove();
                node.prio += incr[i];
                heapy.add(node.prio);
                }
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%11.0f\n", minT);
        }
*/
        /************** ARRAY ****************************/
/*
        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 256000};
        System.out.printf("#%7s%11s%11s%11s\n", "n", "Add", "Remove", "AddRemove");

        int k = 10000;
        for (int n : sizes) {
            System.out.printf("%8d", n);

            int[] prios = new int[n];
            //Integer[] sp = new Integer[n];

            for (int p = 0; p < n; p++) {
                prios[p] = random.nextInt(0, n-1);
                //sp[p] = p;
            }

            double minT = 1000000000;

            for ( int j = 0; j < k; j++) {
                Array array = new Array(n);
                long t0 = System.nanoTime();
                for (int i = 0; i < n; i++) {
                    array.bubble(prios[i]);
                }
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%11.0f", minT);


            minT = 1000000000;

            for ( int j = 0; j < k; j++) {
                Array array = new Array(n);
                for (int a = 0; a < n; a++) {
                    array.bubble(a);
                }
                long t0 = System.nanoTime();
                for (int i = 0; i < n; i++) {
                    array.sink();
                }
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%11.0f", minT);


            minT = 1000000000;

            for ( int j = 0; j < k; j++) {
                Array array = new Array(n);
                long t0 = System.nanoTime();
                for (int i = 0; i < n; i++) {
                    array.bubble(prios[i]);
                }
                for (int i = 0; i < n; i++) {
                    array.sink();
                }
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%11.0f\n", minT);
        }*/
    }
}