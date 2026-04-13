package search;

import book.Book;

import java.util.ArrayList;
import java.util.List;
public class AuthorSearch implements SearchStrategy {
    @Override
    public List<Book> search(List<Book> books, String query) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }
}
