package oop_homework.library_catalogue;


import java.util.Arrays;

public class LibraryCatalog implements Library {
    private Book[] bookList = new Book[30];

    @Override
    public void addBook(Book book) {
        int i = 0;
        while (i < bookList.length) {
            if (bookList[i] != null) {
                i++;
            } else {
                bookList[i] = book;
                break;
            }
        }
    }

    @Override
    public boolean deleteBook(String bookName) {
        int i = 0;
        while (i < bookList.length) {
            if (bookList[i] == null) {
                i++;
            } else if (bookList[i].getName().equals(bookName)) {
                bookList[i] = null;
                break;
            } else {
                i++;
            }
        }
        return false;
    }

    @Override
    public Book findByName(String bookName) {
        for (Book book : bookList) {
            if (book != null) {
                if (book.getName().equals(bookName)) {
                    return book;
                }
            }
        }
        return null;
    }

    @Override
    public void printAllBooks() {
        for (Book book : bookList) {
            if (book != null) {
                System.out.println(book.toString());
            }
        }

    }

}
