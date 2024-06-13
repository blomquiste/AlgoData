import java.util.Random;

public class Benchmarks {
    private Random rand;
    private int[] arr;
    private StaticStack ss;
    private DynamicStack ds;


    public Benchmarks() {
        this.rand = new Random();
        this.arr = new int[1000];
        this.ss = new StaticStack(1024);
        this.ds = new DynamicStack();
    }

    public void set(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt();
        }
    }

    public long runStatic(){
        long t0 = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            ss.push(arr[i]);
        }
        for (int i = arr.length-1; i > -1; i--) {
            ss.pop();
        }
        long t1 = System.nanoTime();
        long time = t1 - t0;
        return time;
    }

    public long runDynamic(){
        long t0 = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            ds.push(arr[i]);
        }
        for (int i = arr.length-1; i > -1; i--) {
            ds.pop();
        }
        long t1 = System.nanoTime();
        long time = t1 - t0;
        return time;
    }
}
