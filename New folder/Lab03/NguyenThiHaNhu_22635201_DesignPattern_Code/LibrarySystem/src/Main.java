import book.Book;
import book.BookFactory;
import book.ConcreteBookFactory;
import library.Librarian;
import library.Library;
import library.Member;
import loan.BasicLoan;
import loan.ExtensionDecorator;
import loan.LoanService;
import loan.SpecialEditionDecorator;
import search.TitleSearch;
import search.AuthorSearch;
import search.GenreSearch;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = Library.getInstance();

        // Observer
        library.addObserver(new Librarian());
        library.addObserver(new Member("Alice"));

        // Factory: tạo sách với thông tin cụ thể
        BookFactory factory = new ConcreteBookFactory();
        Book book1 = new book.PaperBook("Java Basics", "John Doe", "Programming");
        Book book2 = new book.EBook("Design Patterns", "Gamma et al.", "Software Engineering");
        Book book3 = new book.AudioBook("Clean Code", "Robert C. Martin", "Programming");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Strategy: tìm kiếm theo tiêu đề
        library.setSearchStrategy(new TitleSearch());
        List<Book> titleResults = library.search("Java");
        System.out.println("Search by Title 'Java':");
        for (Book b : titleResults) {
            System.out.println(" - " + b.getDetails());
        }

        // Strategy: tìm kiếm theo tác giả
        library.setSearchStrategy(new AuthorSearch());
        List<Book> authorResults = library.search("Martin");
        System.out.println("\nSearch by Author 'Martin':");
        for (Book b : authorResults) {
            System.out.println(" - " + b.getDetails());
        }

        // Strategy: tìm kiếm theo thể loại
        library.setSearchStrategy(new GenreSearch());
        List<Book> genreResults = library.search("Programming");
        System.out.println("\nSearch by Genre 'Programming':");
        for (Book b : genreResults) {
            System.out.println(" - " + b.getDetails());
        }

        // Decorator
        LoanService loan = new BasicLoan();
        loan = new ExtensionDecorator(loan);
        loan = new SpecialEditionDecorator(loan);

        System.out.println("\nLoan Service: " + loan.getServiceInfo());
    }
}
