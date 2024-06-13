public class Main {
    public static void main(String[] args) {
        // 10 + 2 * 5
        // 10 2 5 * +   in reversed Polish notation
        /*Item[] expr = {
                new Item(Item.ItemType.VALUE, 10),
                new Item(Item.ItemType.VALUE,2),
                new Item(Item.ItemType.VALUE, 5),
                new Item(Item.ItemType.MUL),
                new Item(Item.ItemType.ADD)
        };

        Calculator calc = new Calculator(expr, dynamic);
        int res = calc.run();
        System.out.println(" Calculator: res = " + res);

        //System.out.println(" Test: " + expr[].getValue());*/

        int runs = 100;
        long[] sTime = new long[runs];
        long sMin = 0;
        long[] dTime = new long[runs];
        long dMin = 0;

        for (int i = 0; i < runs; i++ ) {
            Benchmarks bench = new Benchmarks();
            bench.set();
            sTime[i] = bench.runStatic();
            dTime[i] = bench.runDynamic();
            if (i == 0) {
                sMin = sTime[i];
                dMin = dTime [i];
            } else if (sTime[i] < sMin) {
                sMin = sTime[i];
            } else if (dTime[i] < dMin) {
                dMin = dTime[i];
            }
        }
        System.out.println("Static: " + sMin + "\nDynamic: " + dMin);
    }
}