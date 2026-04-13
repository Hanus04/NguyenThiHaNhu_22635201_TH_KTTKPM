package book;

public class PaperBook implements Book {
    private String title;
    private String author;
    private String genre;

    public PaperBook(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String getTitle() { return title; }

    @Override
    public String getAuthor() { return author; }

    @Override
    public String getGenre() { return genre; }

    @Override
    public String getDetails() {
        return "PaperBook: " + title + " - " + author + " [" + genre + "]";
    }
}
