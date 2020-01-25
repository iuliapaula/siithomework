package object_containers_homework;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import java.util.*;

public class PersoaneCollectionImplementation {
    public static void main(String[] args) {
        Set<Persoane> setPersoane = new TreeSet<>(new ComparatorPersoane());
        Map<Persoane, List<Hobby>> hobbiesMapPerPerson = new HashMap<>();

        Persoane dan = new Persoane("Dan", 32);
        Persoane dan2 = new Persoane("Dan", 20);
        Persoane zoe = new Persoane("Zoe", 19);
        Persoane iulia = new Persoane("Iulia", 32);
        Persoane andreea = new Persoane("Andreea", 42);

        //Add Persoane to the TreeSet; iterate through the treeset and print the name and the age;
        setPersoane.add(dan);
        setPersoane.add(dan2);
        setPersoane.add(zoe);
        setPersoane.add(iulia);
        setPersoane.add(andreea);

        for (Persoane persoana: setPersoane) {
            System.out.println("Name: " + persoana.getName() + ", age: " + persoana.getAge());
        }

        //store some information about some persons: for one person, you need a list of his/her hobbies;
        //Add some information to this map; for a certain Persoana, print the names of the hobbies and the countries where it can be practiced
        Address address1 = new Address("Bucharest", "Romania");
        Address address2 = new Address("Wien", "Austria");
        Address address3 = new Address("Koln", "Germany");
        List<Address> listOfAddressesTennis = new ArrayList<>();
        List<Address> listOfAddressesSwimming = new ArrayList<>();
        listOfAddressesTennis.add(address1);
        listOfAddressesTennis.add(address2);
        listOfAddressesTennis.add(address3);
        listOfAddressesSwimming.add(address1);

        Hobby tennis = new Hobby("Tennis", 2, listOfAddressesTennis);
        Hobby swimming = new Hobby("Swimming", 3, listOfAddressesSwimming);
        Hobby running = new Hobby("Running", 2, listOfAddressesSwimming);

        List<Hobby> danHobbies = new ArrayList<>();
        danHobbies.add(tennis);
        danHobbies.add(swimming);
        List<Hobby> zoeHobbies = new ArrayList<>();
        zoeHobbies.add(swimming);
        zoeHobbies.add(running);

        hobbiesMapPerPerson.put(dan, danHobbies);
        hobbiesMapPerPerson.put(zoe, zoeHobbies);
        System.out.println("=====================================");
        System.out.println("Hobbies for Dan are: ");
        for (Hobby hobby : hobbiesMapPerPerson.get(dan)) {
            System.out.println("Hobby: " + hobby.getNameOfHobby());
            System.out.print("Countries where this hobby may be practiced: ");
            for (Address address : hobby.getListOfAddresses()) {
                System.out.print(address.getCountry() + " ");
            }
            System.out.println();

        }
    }
}
