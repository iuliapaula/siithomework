package oop2_homework;

import java.util.ArrayList;
import java.util.List;

public abstract class PhoneByBrand implements Phone {
    String brand;
    String model;
    //    int batteryLife;
    int remainingBatteryLife;
    String color;
    String material;
    List<Contact> contactsList = new ArrayList<>();
    List<Message> messagesList = new ArrayList<>();
    List<String> callsHistory = new ArrayList<>();

    public PhoneByBrand() {
        this.remainingBatteryLife = getBatteryLife();
    }

    public void addContact(String index, String phoneNumber, String firstName, String lastName) {
        contactsList.add(new Contact(index, phoneNumber, firstName, lastName));
    }

    public void listContacts() {
        contactsList.forEach(System.out::println);
    }

    public void sendMessage(String phoneNumber, String messageContent) {
        if (remainingBatteryLife < 1) {
            System.out.println("Insufficient battery life to send the message. Please charge your phone!");
        } else if (messageContent.length() > 500) {
            System.out.println("Message has not been sent. The message is too long. Length of the message " + messageContent.length() + " exceeds 500 characters.");
        } else {
            System.out.println("Message sent");
            messagesList.add(new Message(phoneNumber, messageContent));
            remainingBatteryLife -= 1;
        }
    }

    public void listMessages(String phoneNumber) {
        for (Message message : messagesList) {
            if (phoneNumber.equals(message.getPhoneNumber())) {
                System.out.println(message.getMessage());
            }
        }
    }

    public void call(String phoneNumber) {
        if (remainingBatteryLife < 2) {
            System.out.println("Insufficient battery life to make a call. Please charge your phone!");
        } else {
            System.out.println("Call made to number " + phoneNumber);
            callsHistory.add(phoneNumber);
            remainingBatteryLife -= 2;
        }
    }

    public void viewHistory() {
        callsHistory.forEach(System.out::println);
    }

    abstract public int getBatteryLife();

    public void viewRemainingBatteryLife() {
        System.out.println("Remaining battery life: " + remainingBatteryLife);
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
