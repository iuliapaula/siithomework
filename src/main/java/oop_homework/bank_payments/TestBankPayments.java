package oop_homework.bank_payments;

import java.time.LocalDate;
import java.util.Arrays;

public class TestBankPayments {
    public static void main(String[] args) {
        BankAccount bankAccountNumber1 = new BankAccount("A1234");
        System.out.println(bankAccountNumber1.getBalance());
        bankAccountNumber1.addMoney(500);
        bankAccountNumber1.withdrawMoney(300);
        bankAccountNumber1.withdrawMoney(300);

        LocalDate date1 = LocalDate.of(2023, 12, 31);
        LocalDate date2 = LocalDate.of(2018, 12, 31);

        Card card1 = new Card(date1, "Andrei", "Card001");
        Card card2 = new Card(date2, "Andreea", "Card002");
        System.out.println();
        bankAccountNumber1.attachCard(card1.getCardNumber());
        System.out.println(Arrays.toString(bankAccountNumber1.getAttachedCardNumbers()));
        bankAccountNumber1.attachCard(card2.getCardNumber());
        System.out.println(Arrays.toString(bankAccountNumber1.getAttachedCardNumbers()));

        BankAccount bankAccountNumber2 = new BankAccount("B1234");
        bankAccountNumber2.addMoney(500);
        Card card3 = new Card(date1, "Sebastian", "Card003");
        bankAccountNumber2.attachCard(card3.getCardNumber());

        Pos pos = new Pos();
        pos.addKnownBankAccount(bankAccountNumber1);
        pos.addKnownBankAccount(bankAccountNumber2);
        System.out.println(Arrays.toString(pos.getBankAccounts()));
        System.out.println(pos.getBankAccountForCard(card1).toString());
        System.out.println(pos.getBankAccountForCard(card2).toString());
        System.out.println(pos.getBankAccountForCard(card3).toString());

        pos.pay(10, card1);
        pos.pay(191, card1);
        pos.pay(10, card2);
        pos.pay(0, new Card(date1, "Gigi", "sdgfsad"));

        User user1 = new User();
        user1.addBankAccount(bankAccountNumber1);
        System.out.println(Arrays.toString(user1.bankAccounts));
        user1.addCard(card1);
        System.out.println(Arrays.toString(user1.cards));
    }
}
