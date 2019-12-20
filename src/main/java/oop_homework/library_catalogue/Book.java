package oop_homework.library_catalogue;

public class Book {
    private String name;
    private int page_numbers;

    public Book(String name, int page_numbers) {
        this.name = name;
        this.page_numbers = page_numbers;
    }

    public String getName() {
        return name;
    }

    public int getPageNumbers() {
        return page_numbers;
    }
}
