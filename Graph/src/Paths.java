public class Paths {
    public static City[] path = new City[54];
    public static int sp = 0;

    public Paths() {
        path = new City[54];
        sp = 0;
    }

    private static Integer shortest(City from, City to) {
        if (from == to) {
            return 0;
        }
        Integer shrt = null;
        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
                return null;
        }
        path[sp++] = from;
        for (int i = 0; i < from.neighbors.length; i++) {
            if (from.neighbors[i] != null) {
                Connection conn = from.neighbors[i];
                Integer temp = shortest(conn.city, to);
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
        path[sp--] = null;
        return shrt;
    }

    public static void main(String[] args) {
        Map map = new Map("/Users/elinblomquist/Desktop/AlgoData/Graph/src/trains.csv");

        String from = "Göteborg";
        String to = "Umeå";

        long  t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to));
        long time = (System.nanoTime() - t0)/1_000_000;
        System.out.println("shortest: " + dist + " min (" + time + " ms)");
    }
}
