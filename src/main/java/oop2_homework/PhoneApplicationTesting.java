package oop2_homework;

public class PhoneApplicationTesting {
    public static void main(String[] args) {
        Phone phone = new SamsungGalaxy6("asdfsdf");
        phone.viewRemainingBatteryLife();
        phone.addContact("1", "0724098098", "Andreea", "Tudoran");
        phone.listContacts();
        phone.addContact("2", "0710000000", "Ana", "Maria");
        phone.listContacts();
        phone.sendMessage("0724098098", "First message sent");
        phone.viewRemainingBatteryLife();
        phone.listMessages("0724098098");
        phone.sendMessage("0724098098", "Second message sent");
        phone.listMessages("0724098098");
        phone.sendMessage("07298098", "Second message sent");
        phone.listMessages("0724098098");
        phone.call("0724098098");
        phone.call("45645");
        phone.viewHistory();
        phone.viewRemainingBatteryLife();
        phone.call("342");
        phone.call("45646");
    }
}
