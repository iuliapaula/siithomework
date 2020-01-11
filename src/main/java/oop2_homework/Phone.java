package oop2_homework;

public interface Phone {
    void addContact(String index, String phoneNumber, String firstName, String lastName);

    void listContacts();

    void sendMessage(String phoneNumber, String messageContent);

    void listMessages(String phoneNumber);

    void call(String phoneNumber);

    void viewHistory();

    void viewRemainingBatteryLife();
}
