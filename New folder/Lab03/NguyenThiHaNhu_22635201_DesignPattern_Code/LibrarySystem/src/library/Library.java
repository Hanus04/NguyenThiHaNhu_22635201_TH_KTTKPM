package library;

import book.Book;
import search.SearchStrategy;

import java.util.*;

public class Library {
    private static Library instance;
    private List<Book> books;
    private List<Observer> observers;
    private SearchStrategy searchStrategy;

    private Library() {
        books = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        notifyObservers("New book added: " + book.getDetails());
    }

    public void setSearchStrategy(SearchStrategy strategy) {
        this.searchStrategy = strategy;
    }

    public List<Book> search(String query) {
        return searchStrategy.search(books, query);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer obs : observers) {
            obs.update(message);
        }
    }
}
