package io_part_two;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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
        System.out.println("10=====");
        System.out.println(Arrays.toString(readContentsToByteArray(System.getProperty("user.dir") + "\\src\\main\\resources\\test.txt")));
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
    public static List<String> readContentsLineByLine(String path) {
        File file = new File(path);
        return new ArrayList<>();
    }
//12. Implement a method to read a plain text file.
//13. Implement a method to read a file line by line and store it into a variable.
//14. Implement a method to store text file content line by line into an array.
//15. Implement a method to write and read a plain text file.
//16. Implement a method to append text to an existing file.
//17. Implement a method to read first 3 lines from a file.
//18. Implement a method to find the longest word in a text file.

}
