package java_8_streams_exercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TradingWithStreams {


    /*
            Find all transactions in the year 2011 and sort them by value (small to high).
            What are all the unique cities where the traders work?
            Find all traders from Cambridge and sort them by name.
            Return a string of all traders names sorted alphabetically.
            Are any traders based in Milan?
            Print all transactions values from the traders living in Cambridge.
            Whats the highest value of all the transactions?
            Find the transaction with the smallest value.
             */
    public static void main(String[] args) throws IOException {
//        Trader raoul = new Trader("Raoul", "Cambridge");
//        Trader mario = new Trader("Mario", "Milan");
//        Trader alan = new Trader("Alan", "Cambridge");
//        Trader brian = new Trader("Brian", "Cambridge");
//        List<Transaction> transactions = new ArrayList<>();
//        transactions.add(new Transaction(brian, 2011, 300));
//        transactions.add(new Transaction(raoul, 2012, 1000));
//        transactions.add(new Transaction(raoul, 2011, 400));
//        transactions.add(new Transaction(mario, 2012, 710));
//        transactions.add(new Transaction(mario, 2012, 700));
//        transactions.add(new Transaction(alan, 2012, 950));
//
//        System.out.println("=====What are all the unique cities where the traders work?");
//        List<String> uniqueCities = getUniqueCities(transactions);
//        uniqueCities.forEach(System.out::println);
//        System.out.println("=====Find all traders from Cambridge and sort them by name.");
//        List<Trader> tradersFromCambridge = getTradersFromCambridge(transactions);
//        tradersFromCambridge.forEach(System.out::println);
//        System.out.println("=====Return a string of all traders names sorted alphabetically");
//        String tradersNames = tradersNamesSortedAlphabetically(transactions);
//        System.out.println(tradersNames);
//        System.out.println("=====Are any traders based in Milan?");
//        System.out.println(tradersBasedInMilan(transactions));
//        System.out.println("=====Print all transactions values from the traders living in Cambridge.");
//        transactionValuesTradersFromCambridge(transactions);
//        System.out.println("=====Whats the highest value of all the transactions?");
//        System.out.println(highestValueFromTransactions(transactions));
//        System.out.println("=====Find the transaction with the smallest value.");
//        System.out.println(transactionWithSmallestValue(transactions));

        String inputPath = System.getProperty("user.dir") + "\\src\\main\\resources\\streams_application.txt";
        String outputPath = System.getProperty("user.dir") + "\\src\\main\\resources\\streams_application_output.txt";
        filterFileAfterMonth(inputPath, 1, outputPath);
    }

    /**
     * Find all transactions in the year 2011 and sort them by value (small to high).
     * <p>
     * This method returns all transactions from 2011 sorted by value
     *
     * @param transactions
     * @return
     */
    private static List<Transaction> getTransactionsFrom2011SortedByValue(List<Transaction> transactions) {
        return transactions
                .stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
//                .sorted((transaction1, transaction2) -> transaction1.getValue()-transaction2.getValue())
                .collect(toList());
    }

    // What are all the unique cities where the traders work?
    private static List<String> getUniqueCities(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
    }

    // Find all traders from Cambridge and sort them by name.
    private static List<Trader> getTradersFromCambridge(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(toList());
    }

    // Return a string of all traders names sorted alphabetically
    private static String tradersNamesSortedAlphabetically(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted((name1, name2) -> name1.compareTo(name2))
                .collect(Collectors.joining(" "));
    }

    //     Are any traders based in Milan?
    private static boolean tradersBasedInMilan(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .anyMatch(city -> city.equals("Milan"));
    }

    //    Print all transactions values from the traders living in Cambridge.
    private static void transactionValuesTradersFromCambridge(List<Transaction> transactions) {
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .forEach(transaction -> System.out.println("Trader: " + transaction.getTrader().getName() + "; Transaction value: " + transaction.getValue()));
    }

    //    Whats the highest value of all the transactions?
    private static Integer highestValueFromTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getValue())
                .max(Comparator.comparingInt(value -> value))
                .get();
    }

    //    Find the transaction with the smallest value.
    private static Transaction transactionWithSmallestValue(List<Transaction> transactions) {
        return transactions.stream()
                .min((transaction1, transaction2) -> Integer.compare(transaction1.getValue(), transaction2.getValue()))
                .get();
    }

//    By using streams and lamba expressions, implement a small application which:
//        1.load from a file a structure like
//        first name, last name, date of birth
//        2. write back another file containing only
//        first name, last name
//        ordered alphabetically for all the of all matches which have the birthday on a month indicated.
//private static void filterFileAfterMonth(String inputFilename, int targetMonth, String outputFilename)

    private static void filterFileAfterMonth(String inputFilePath, int targetMonth, String outputFilePath) throws IOException {
        Path path = Paths.get(inputFilePath);
        try (Stream<String> streamFromInputFile = Files.lines(path);
             PrintWriter output = new PrintWriter(outputFilePath)) {
            streamFromInputFile
                    .filter(i -> dateMatchesProvidedMonth(i.split(", ")[2], targetMonth))
                    .map(i -> extractNameAndLastName(i))
                    .sorted((s1, s2) -> s1.split(", ")[1].compareTo(s2.split(", ")[1]))
                    .forEach(output::println);
        }
//        Files.lines(path)
//                .filter(i -> dateMatchesProvidedMonth(i.split(", ")[2], targetMonth))
//                .map(i -> extractNameAndLastName(i))
//                .forEach(System.out::println);

    }

    private static boolean dateMatchesProvidedMonth(String date, int month) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd")).getMonthValue() == month;
    }

    private static String extractNameAndLastName(String inputString) {
        String[] arrayFromString = inputString.split(", ");
        int lengthOfExtractedString = inputString.length() - arrayFromString[2].length() - 2;
        return inputString.substring(0, lengthOfExtractedString);
    }
}
