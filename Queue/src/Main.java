import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int k = 1600;
        LinkedQueue lq = new LinkedQueue();
        for (int i = 0; i < k; i++) {
            lq.add(random.nextInt(0, 100));
        }
        for (int i = 0; i < k; i++) {
            lq.remove();
        }

        ArrayQueue aq = new ArrayQueue(k/4);
        for (int i = 0; i < k; i++) {
            aq.add(random.nextInt(0, 100));
            System.out.print(i);
        }
        System.out.println("aq.remove()");

        for (int i = 0; i < k; i++) {
            System.out.println(aq.remove() + " " +i + "\n");
        }
    }
}