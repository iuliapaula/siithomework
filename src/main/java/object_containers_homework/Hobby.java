package object_containers_homework;

import java.util.List;

public class Hobby {
    private String nameOfHobby;
    private int frequency;
    private List<Address> listOfAddresses;

    public String getNameOfHobby() {
        return nameOfHobby;
    }

    public int getFrequency() {
        return frequency;
    }

    public List<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    public Hobby(String nameOfHobby, int frequency, List<Address> listOfAddresses) {
        this.nameOfHobby = nameOfHobby;
        this.frequency = frequency;
        this.listOfAddresses = listOfAddresses;
    }
}
