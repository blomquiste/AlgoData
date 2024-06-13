public class ImprovedPath {
    public static City[] path = new City[54];
    public static int sp = 0;

    public ImprovedPath() {
        path = new City[54];
        sp = 0;
    }
    private static Integer shortest(City from, City to) {
        if (from == to) {
            return 0;
        }
        Integer shrt = null;
        Integer max = null;
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
                    if (temp == 0) {
                        max = shrt;
                    }
                }
            }
        }
        path[sp--] = null;
        return shrt;
    }
    private static Integer shortest(City from, City to, Integer max) {
        if (max != null && max < 0) {
            return null;
        }
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
                if (max == null) {
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
                        if (temp == 0) {
                            max = shrt;
                        }
                    }
                } else {
                    Integer temp = shortest(conn.city, to, (max - conn.distance));
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
        }
        path[sp--] = null;
        return shrt;
    }

    public static void main(String[] args) {
        Map map = new Map("/Users/elinblomquist/Desktop/AlgoData/Graph/src/trains.csv");

        String from = "Stockholm";
        String to = "Sundsvall";
        Integer max = null; //dynamisk: först null och sen shrt efter första hitten

        long  t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0)/1_000_000;
        System.out.println("shortest: " + dist + " min (" + time + " ms)");
    }
}
