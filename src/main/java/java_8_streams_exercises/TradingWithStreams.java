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



    public static void main(String[] args) throws IOException {
        String inputPath = System.getProperty("user.dir") + "\\src\\main\\resources\\streams_application.txt";
        String outputPath = System.getProperty("user.dir") + "\\src\\main\\resources\\streams_application_output.txt";
        filterFileAfterMonth(inputPath, 1, outputPath);
    }


//    By using streams and lambda expressions, implement a small application which:
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

    }

    public static boolean dateMatchesProvidedMonth(String date, int month) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd")).getMonthValue() == month;
    }

    public static String extractNameAndLastName(String inputString) {
        String[] arrayFromString = inputString.split(", ");
        int lengthOfExtractedString = inputString.length() - arrayFromString[2].length() - 2;
        return inputString.substring(0, lengthOfExtractedString);
    }
}
