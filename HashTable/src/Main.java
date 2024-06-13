import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        String file = "/Users/elinblomquist/Desktop/AlgoData/HashTable/src/postnummer.csv";

        System.out.printf("#%7s%9s%9s%9s\n", "Postal", "LinearS", "BinaryS", "Index");
        String[] pcS = {"111 15", "984 99"};

        int k = 1000;
        for (String n : pcS) {
            System.out.printf(/*"%8d",*/ n);


            /******** LINEAR *******/
            double minT = 10000000;

            Zip zip = new Zip(file);
            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                zip.linear1(n);
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%9.0f", (minT));

            /********* BINARY **********/
            minT = 10000000;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                zip.binary1(n);
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%9.0f", (minT));

            /********* INDEX **********/
            minT = 10000000;

            Colli zipIndex = new Colli(file);
            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                zipIndex.lookup(n);
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%9.0f\n", (minT));
        }

        System.out.printf("\n#%7s%9s%9s%9s%9s\n", "Postal", "LinearI", "BinaryI", "HashTable", "Better");
        Integer[] pcI = {11115, 11164, 98499, random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499), random.nextInt(11115, 98499)};
        double elements;
        //int k = 1000;
        for (Integer n : pcI) {
            System.out.printf("%8d", n);


            /******** LINEAR *******/
            double minT = 10000000;

            ZipI zipI = new ZipI(file);
            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                zipI.linear2(n);
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%9.0f", (minT));

            /********* BINARY **********/
            minT = 10000000;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                zipI.binary2(n);
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }
            System.out.printf("%9.0f", (minT));

            /********* HASH **********/
            elements = 0;

            HashTable hashTable = new HashTable(file, 20000, 10000);
            for (int i = 0; i < k; i++) {
                elements = hashTable.lookup(n);
            }
            System.out.printf("%9.0f", elements);

            /********* BETTER **********/
            elements = 0;

            Better better = new Better(file, 10000);
            for (int i = 0; i < k; i++) {
                elements = better.lookup(n);

            }
            System.out.printf("%9.0f\n", elements);
        }

        //System.out.printf("\n#%9s%11s\n", "mod", "Collisions");
        Integer[] mod = {10000, 12345, 13513, 13600, 14000, 20000, 30000, 40000, 50000, 60000};

        k = 1;
        for (Integer n : mod) {
            //System.out.printf("%9d", mod);

            /******** COLLISIONS *******/
            double minT = 10000000;
/*
            Colli colli = new Colli(file);
            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                colli.collisions(n);
                long time = System.nanoTime() - t0;

                if (time < minT)
                    minT = time;
            }*/
            //System.out.printf("%11.0f\n", (minT));
        }


        /*Random random = new Random();

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
        }*/
    }

    /*private static void appendA(int[] a1, int[] a2) {
        int[] newArray = new int[a1.length + a2.length];
        int con = a1.length;
        for (int i = 0; i < a1.length; i++) {
            newArray[i] = a1[i];
        }
        for (int i = 0; i < a2.length; i++) {
            newArray[i + a1.length] = a2[i];
        }
    }*/
}