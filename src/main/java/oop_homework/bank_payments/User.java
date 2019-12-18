package oop_homework.bank_payments;

public class User {
    Card[] cards = new Card[30];
    BankAccount[] bankAccounts = new BankAccount[30];

    public void addCard(Card card) {
        int i = 0;
        while (i < cards.length) {
            if (cards[i] != null) {
                i++;
            } else {
                cards[i] = card;
                break;
            }
        }
    }

    public void addBankAccount(BankAccount bankAccount) {
        int i = 0;
        while (i < bankAccounts.length) {
            if (bankAccounts[i] != null) {
                i++;
            } else {
                bankAccounts[i] = bankAccount;
                break;
            }
        }
    }
}
