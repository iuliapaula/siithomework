package oop_homework.library_catalogue;

public interface Library {
    void addBook(Book book);
    boolean deleteBook(String bookName);
    Book findByName(String bookName);
    void printAllBooks();
}
