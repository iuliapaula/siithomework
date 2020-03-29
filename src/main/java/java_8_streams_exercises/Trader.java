package java_8_streams_exercises;


public class Trader {
    private final String city;
    private final String name;


    public Trader(String name, String city) {
        this.city = city;
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "city='" + city + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
