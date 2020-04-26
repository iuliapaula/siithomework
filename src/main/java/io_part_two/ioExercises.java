package io_part_two;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ioExercises {
    public static void main(String[] args) throws IOException {
//        System.out.println("1=====");
//        getListOfFilesNames(System.getProperty("user.dir") + "\\src\\main\\java\\oop2_homework").forEach(System.out::println);
//        System.out.println("2=====");
//        getFilesByExtension(System.getProperty("user.dir") + "\\src\\main\\java\\oop2_homework", ".java").forEach(System.out::println);
//        System.out.println("3=====");
//        System.out.println(checkIfFileExists(System.getProperty("user.dir") + "\\src\\main\\java\\oop2_homework"));
//        System.out.println(checkIfFileExists(System.getProperty("user.dir") + "\\src\\main\\java\\oop3_homework"));
//        System.out.println("4=====");
//        System.out.println(checkIfFileHasReadAndWritePermission(System.getProperty("user.dir") + "\\src\\main\\java\\oop2_homework"));
//        System.out.println("5=====");
//        System.out.println(checkIfFileOrDirectory(System.getProperty("user.dir") + "\\src\\main\\java\\oop2_homework"));
//        System.out.println(checkIfFileOrDirectory(System.getProperty("user.dir") + "\\src\\main\\java\\oop2_homework\\Contact.java"));
//        System.out.println(checkIfFileOrDirectory(System.getProperty("user.dir") + "\\src\\main\\java\\oop2_homework\\Contact2.java"));
//        System.out.println("6=====");
//        compareFilesLexicographically(System.getProperty("user.dir") + "\\src\\main\\resources\\test.txt", System.getProperty("user.dir") + "\\src\\main\\resources\\test2.txt");
//        System.out.println("7=====");
//        getLastModifiedTime(System.getProperty("user.dir") + "\\src\\main\\java\\oop2_homework\\Contact.java");
//        System.out.println("8=====");
//        System.out.println(readInputFromConsole());
//        System.out.println("9=====");
//        getFileSize(System.getProperty("user.dir") + "\\src\\main\\java\\oop2_homework\\Contact.java");
//        System.out.println("10=====");
//        System.out.println(Arrays.toString(readContentsToByteArray(System.getProperty("user.dir") + "\\src\\main\\resources\\test.txt")));
//        System.out.println("11=====");
//        readContentsLineByLine(System.getProperty("user.dir") + "\\src\\main\\resources\\test.txt").forEach(System.out::println);
//        System.out.println("12=====");
//        readTextFile(System.getProperty("user.dir") + "\\src\\main\\resources\\test.txt");
//        System.out.println("13=====");
//        System.out.println(readLineByLineAndStoreInVariable(System.getProperty("user.dir") + "\\src\\main\\resources\\test.txt"));
//        System.out.println("14=====");
//        System.out.println(Arrays.toString(readLineByLineInArray(System.getProperty("user.dir") + "\\src\\main\\resources\\test.txt")));
        System.out.println("15=====");
        writeAndReadAFile(System.getProperty("user.dir") + "\\src\\main\\resources\\test_15.txt", "Line 1\nLine 2\nLine_long 3\nEnd");
//        System.out.println("16=====");
//        appendText(System.getProperty("user.dir") + "\\src\\main\\resources\\test_15.txt", "Appended text");
//        System.out.println("17=====");
//        readFirstThreeLinesFromFile(System.getProperty("user.dir") + "\\src\\main\\resources\\test_15.txt");
        System.out.println("18=====");
        System.out.println(findLongestWordFromFile(System.getProperty("user.dir") + "\\src\\main\\resources\\test_15.txt"));
    }

    //1. Implement a method to get a list of all file/directory names from the given.
    public static List<String> getListOfFilesNames(String pathName) throws IOException {
        Path path = Paths.get(pathName);
        return Files.walk(path)
                .map(e -> e.toString())
                .collect(Collectors.toList());
    }

    //2. Implement a method to get specific files by extensions from a specified folder.
    public static List<String> getFilesByExtension(String directory, String extension) throws IOException {
        Path path = Paths.get(directory);
        return Files.walk(path)
                .map(e -> e.toString())
                .filter(e -> e.endsWith(extension))
                .collect(Collectors.toList());
    }

    //3. Implement a method to check if a file or directory specified by pathname exists or not.
    public static boolean checkIfFileExists(String pathName) {
        Path path = Paths.get(pathName);
        return Files.exists(path);
    }

    //4. Implement a method to check if a file or directory has read and write permission.
    public static boolean checkIfFileHasReadAndWritePermission(String pathname) {
        Path path = Paths.get(pathname);
        return (Files.isReadable(path) && Files.isWritable(path));
    }

    //5. Implement a method to check if given pathname is a directory or a file.
    public static String checkIfFileOrDirectory(String pathname) {
        Path path = Paths.get(pathname);
        if (Files.isDirectory(path)) {
            return "Directory";
        } else if (Files.isRegularFile(path)) {
            return "File";
        } else {
            return "Unknown";
        }
    }

    //6. Implement a method to compare two files lexicographically.
    public static void compareFilesLexicographically(String pathname1, String pathname2) throws IOException {
        File file1 = new File(pathname1);
        File file2 = new File(pathname2);
        int compareResult = file1.compareTo(file2);
        if (compareResult == 0) {
            System.out.println("The two files are equal");
        } else if (compareResult > 0) {
            System.out.println("File " + file1.getName() + " is greater than file " + file2.getName());
        } else {
            System.out.println("File " + file2.getName() + " is greater than file " + file1.getName());
        }
    }

    //In mathematics, the lexicographic or lexicographical order (also known as lexical order, dictionary order,
//alphabetical order or lexicographic(al) product) is a generalization of the way
//the alphabetical order of words is based on the alphabetical order of their component letters.
//This generalization consists primarily in defining a total order over the sequences
//(often called words in computer science) of elements of a finite totally ordered set, often called alphabet.
//
//7. Implement a method to get last modified time of a file.
    public static void getLastModifiedTime(String path) throws IOException {
        File file = new File(path);
        long lastModified = file.lastModified();
        DateFormat formattedLastModified = new SimpleDateFormat("mm/dd/yyyy hh:mm:ss");
        System.out.println("File " + file.getName() + " last modified on " + formattedLastModified.format(lastModified));
//        long lastModified = Files.getLastModifiedTime(Paths.get(path));
    }

    //8. Implement method to read input from java console.
    public static String readInputFromConsole() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            return (scanner.nextLine());
        } else {
            return null;
        }
    }

    //9. Implement a method to get file size in bytes, kb, mb.
    public static void getFileSize(String pathName) throws IOException {
        long sizeInBytes = Files.size(Paths.get(pathName));
        double sizeInKb = (double) (sizeInBytes / 1024);
        double sizeInMb = sizeInKb / 1024;
        System.out.println("Size of file " + Paths.get(pathName).getFileName() + " " + sizeInBytes + " bytes, " + sizeInKb + " kb " + sizeInMb + " mb.");
    }

    //10. Implement a method to read contents from a file into byte array.
    public static byte[] readContentsToByteArray(String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }

    //11. Implement a method to read a file content line by line.
    public static List<String> readContentsLineByLine(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        List<String> readContent = new ArrayList<>();
        while (scanner.hasNextLine()) {
            readContent.add(scanner.nextLine());
        }
        return readContent;
    }

    //12. Implement a method to read a plain text file.
    public static void readTextFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    //13. Implement a method to read a file line by line and store it into a variable.
    public static String readLineByLineAndStoreInVariable(String path) throws FileNotFoundException {
        StringBuilder readLines = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                readLines.append(line);
                readLines.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readLines.toString();

    }

    //14. Implement a method to store text file content line by line into an array.
    public static String[] readLineByLineInArray(String path) {
        List<String> readLines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                readLines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readLines.toArray(String[]::new);
    }

    //15. Implement a method to write and read a plain text file.
    public static void writeAndReadAFile(String path, String textToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(textToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //16. Implement a method to append text to an existing file.
    public static void appendText(String path, String textToAppend) {
        Path path_file = Paths.get(path);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path_file, StandardOpenOption.APPEND)) {
            bufferedWriter.write(textToAppend);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //17. Implement a method to read first 3 lines from a file.
    public static void readFirstThreeLinesFromFile(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            int i = 0;
            String line = null;
            while ((line = bufferedReader.readLine()) != null && i < 3) {
                System.out.println(line);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//18. Implement a method to find the longest word in a text file.
    public static String findLongestWordFromFile(String path) {
        String longestWord = null;
        try {
            longestWord = Files.lines(Paths.get(path))
                    .map(line -> line.split(" "))
                    .flatMap(x -> Arrays.stream(x))
                    .sorted((word1, word2) -> Integer.compare(word2.length(), word1.length()))
                    .findFirst()
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return longestWord;
    }
}
