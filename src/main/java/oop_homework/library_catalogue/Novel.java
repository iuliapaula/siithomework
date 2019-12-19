package oop_homework.library_catalogue;

public class Novel extends Book {
    private String type;

    public Novel(String name, int page_numbers, String type) {
        super(name, page_numbers);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + super.getName() + '\'' +
                ", number of pages: " + super.getPage_numbers() +
                ", type: " + type +
                '}';
    }
}
