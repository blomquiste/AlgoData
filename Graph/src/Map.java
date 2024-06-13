import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;

public class Map {
    public City[] cities;
    private final int mod = 541;

    public Map(String file) {
        cities = new City[mod];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int j = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                for (int i = 0; i < 2; i++) {
                    if (lookup(row[i]) == null) {
                        cities[j] = new City(row[i]);
                        j++;
                    }
                }
                int c1 = getIndex(row[0]);
                int c2 = getIndex(row[1]);
                int distance = Integer.parseInt(row[2]);
                cities[c1].connect(cities[c2], distance);
                cities[c2].connect(cities[c1], distance);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    public int getIndex(String city) {
        int index = 0;
        for (int i = 0; i < cities.length; i++) {
            if (Objects.equals(cities[i].name, city)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public City lookup(String nameOfCity) {
        City city;
        int i = 0;
        while (cities[i] != null) {
            if (cities[i].name.equals(nameOfCity)) {
                city = cities[i];
                return city;
            }
            i++;
        }
        return null;
    }
}
