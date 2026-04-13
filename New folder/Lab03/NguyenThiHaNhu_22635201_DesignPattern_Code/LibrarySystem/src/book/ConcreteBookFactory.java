package book;

public class ConcreteBookFactory extends BookFactory {
    @Override
    public Book createBook(String type) {
        switch (type.toLowerCase()) {
            case "paper":
                return new PaperBook("Java Basics", "John Doe", "Programming");
            case "ebook":
                return new EBook("Design Patterns", "Gamma et al.", "Software Engineering");
            case "audio":
                return new AudioBook("Clean Code", "Robert C. Martin", "Programming");
            default:
                throw new IllegalArgumentException("Unknown book type: " + type);
        }
    }
}
