package book;

public class AudioBook implements Book {
    private String title;
    private String author;
    private String genre;

    public AudioBook(String title, String author, String genre) {
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
        return "AudioBook: " + title + " - " + author + " [" + genre + "]";
    }
}