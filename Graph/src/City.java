public class City {
    String name;
    Connection[] neighbors = new Connection[20];
    int i = 0;

    public City(String name) {
        this.name = name;
    }

    public void connect(City destination, int distance) {
        Connection connection = new Connection(destination, distance);
        neighbors[i] = connection;
        i++;
    }

}
