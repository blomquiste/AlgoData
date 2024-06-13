public class Naive {
    private static Integer shortest(City from, City to, Integer max) {
        if (max < 0) {
            return null;
        }
        if (from == to) {
            return 0;
        }
        Integer shrt = null;
        for (int i = 0; i < from.neighbors.length; i++) {
            if (from.neighbors[i] != null) {
                Connection conn = from.neighbors[i];
                Integer temp = shortest(conn.city, to, (max-conn.distance));
                if (temp != null) {
                    temp += conn.distance;
                    if (shrt == null) {
                        shrt = temp;
                    } else {
                        if (temp < shrt) {
                            shrt = temp;
                        }
                    }
                }
            }
        }
        return shrt;
    }

    public static void main(String[] args) {
        Map map = new Map("/Users/elinblomquist/Desktop/AlgoData/Graph/src/trains.csv");

        String from = "Göteborg";
        String to = "Umeå";
        Integer max = 800;

        long  t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0) / 1_000_000;
        System.out.println("shortest: " + dist + " min (" + time + " ms)");
    }
}
