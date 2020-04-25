package java_8_streams_exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/*
        What are all the unique cities where the traders work?
        Find all traders from Cambridge and sort them by name.
        Return a string of all traders names sorted alphabetically.
        Are any traders based in Milan?
        Print all transactions values from the traders living in Cambridge.
        Whats the highest value of all the transactions?
        Find the transaction with the smallest value.
         */

public class TradingWithStreamsClass {
    List<Transaction> transactions = new ArrayList<>();

    // What are all the unique cities where the traders work?
    public List<String> getUniqueCities(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
    }

    // Find all traders from Cambridge and sort them by name.
    public List<Trader> getTradersFromCambridge(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(toList());
    }

    // Return a string of all traders names sorted alphabetically
    public String tradersNamesSortedAlphabetically(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted((name1, name2) -> name1.compareTo(name2))
                .collect(Collectors.joining(" "));
    }

    //     Are any traders based in Milan?
    public boolean tradersBasedInMilan(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .anyMatch(city -> city.equals("Milan"));
    }

    //    Print all transactions values from the traders living in Cambridge.
    public void transactionValuesTradersFromCambridge(List<Transaction> transactions) {
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .forEach(transaction -> System.out.println("Trader: " + transaction.getTrader().getName() + "; Transaction value: " + transaction.getValue()));
    }

    //    Whats the highest value of all the transactions?
    public Integer highestValueFromTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getValue())
                .max(Comparator.comparingInt(value -> value))
                .get();
    }

    //    Find the transaction with the smallest value.
    public Transaction transactionWithSmallestValue(List<Transaction> transactions) {
        return transactions.stream()
                .min((transaction1, transaction2) -> Integer.compare(transaction1.getValue(), transaction2.getValue()))
                .get();
    }

    public TradingWithStreamsClass(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
