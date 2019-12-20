package oop_homework.library_catalogue;

public class ArtAlbum extends Book {
    private String paperQuality;

    public ArtAlbum(String name, int page_numbers, String paperQuality) {
        super(name, page_numbers);
        this.paperQuality = paperQuality;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + super.getName() + '\'' +
                ", number of pages: " + super.getPageNumbers() +
                ", paper quality: " + paperQuality +
                '}';
    }
}
