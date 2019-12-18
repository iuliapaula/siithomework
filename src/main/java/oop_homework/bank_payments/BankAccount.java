package oop_homework.bank_payments;

public class BankAccount {
    private String iban;
    private double balance;
    private String[] attachedCardNumbers = new String[30];

    public BankAccount(String iban) {
        this.iban = iban;
        balance = 0;
    }

    public String getIban() {
        return iban;
    }

    public double getBalance() {
        return balance;
    }

    public String[] getAttachedCardNumbers() {
        return attachedCardNumbers;
    }

    public void addMoney(double amount) {
        System.out.println("The initial balance was " + balance);
        balance += amount;
        System.out.println("You added " + amount + " and the final balance is " + balance);

    }

    public void withdrawMoney(double amount) {
        System.out.print("The initial balance was " + balance);
        if (amount <= balance) {
            balance -= amount;
            System.out.println(" The amount withdrew was " + amount);
        }
        System.out.println(" The final balance is " + balance);

    }

    public void attachCard(String cardNumber) {
        int i = 0;
        while (i < attachedCardNumbers.length) {
            if (attachedCardNumbers[i] != null) {
                i++;
            } else {
                attachedCardNumbers[i] = cardNumber;
                break;
            }
        }
    }
}
