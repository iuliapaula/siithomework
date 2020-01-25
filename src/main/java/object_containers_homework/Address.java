package object_containers_homework;

public class Address {
    private String town;
    private String country;

    public Address(String town, String country) {
        this.town = town;
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public String getCountry() {
        return country;
    }
}
