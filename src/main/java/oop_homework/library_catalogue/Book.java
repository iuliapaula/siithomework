package oop_homework.library_catalogue;

public class Book {
    private String name;
    private int page_numbers;

    public Book(String name, int page_numbers) {
        this.name = name;
        this.page_numbers = page_numbers;
    }

    public void setPage_numbers(int page_numbers) {
        this.page_numbers = page_numbers;
    }

    public String getName() {
        return name;
    }

    public int getPage_numbers() {
        return page_numbers;
    }
}
