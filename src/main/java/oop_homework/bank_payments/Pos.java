package oop_homework.bank_payments;

import java.time.LocalDate;

public class Pos {
    private BankAccount[] bankAccounts = new BankAccount[30];

    public BankAccount[] getBankAccounts() {
        return bankAccounts;
    }

    public void addKnownBankAccount(BankAccount bankAccount) {
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

    public void pay(double amount, Card card) {
        BankAccount bankAccount = getBankAccountForCard(card);
        if (bankAccount == null) {
            System.out.println("No money has been withdrawn. Unknown bank account number, please contact customer support service.");
        } else if (card.getExpirationDate().isBefore(LocalDate.now())) {
            System.out.println("The card is expired. No money has been withdrawn");
        } else {
            double balance = bankAccount.getBalance();
            if (amount <= balance) {
                bankAccount.withdrawMoney(amount);
                System.out.println("You have withdrawn the amount " + amount);
            } else {
                System.out.println("The required amount exceeds the available funds. No money has been withdrawn");
            }
        }
    }

    public BankAccount getBankAccountForCard(Card card) {
        BankAccount bankAccount = null;
        for (BankAccount bankAccountSearched : bankAccounts) {
            if (bankAccountSearched != null) {
                String[] listOfCards = bankAccountSearched.getAttachedCardNumbers();
                for (String cardSearchedInBankAccount : listOfCards) {
                    if (card.getCardNumber().equals(cardSearchedInBankAccount)) {
                        bankAccount = bankAccountSearched;
                        break;
                    }
                }
            }

        }
        return bankAccount;
    }

}
