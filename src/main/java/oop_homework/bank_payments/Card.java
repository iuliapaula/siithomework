package oop_homework.bank_payments;

        import java.time.LocalDate;

public class Card {
    private LocalDate expirationDate;
    private String ownerName;
    private String cardNumber;

    public Card(LocalDate expirationDate, String ownerName, String cardNumber) {
        this.expirationDate = expirationDate;
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }
}
