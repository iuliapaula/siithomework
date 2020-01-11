package oop2_homework;

public class Contact {
    private String index;
    private String phoneNumber;
    private String firstName;
    private String lastName;

    public Contact(String index, String phoneNumber, String firstName, String lastName) {
        this.index = index;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "index='" + index + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
