package oop_homework.library_catalogue;

import java.util.Arrays;
import java.util.Comparator;

public class LibraryApp {
    public static void main(String[] args) {
        Book book1 = new Novel("Toate panzele sus", 450, "novel");
        Book book2 = new ArtAlbum("Monet", 45, "Premium");
        Book book3 = new Novel("Bunica mi-a zis sa-ti spun ca-i pare rau", 350, "novel");
        LibraryCatalog libraryCatalog = new LibraryCatalog();

        libraryCatalog.addBook(book1);
        libraryCatalog.addBook(book2);
        libraryCatalog.addBook(book3);
        libraryCatalog.printAllBooks();
        System.out.println();

        System.out.println(libraryCatalog.deleteBook("Toate panzele sus"));
        libraryCatalog.printAllBooks();
        System.out.println();

        System.out.println(libraryCatalog.deleteBook("Adsdss"));
        libraryCatalog.printAllBooks();
        System.out.println();

        System.out.println(libraryCatalog.findByName("Monet").toString());


    }
}
