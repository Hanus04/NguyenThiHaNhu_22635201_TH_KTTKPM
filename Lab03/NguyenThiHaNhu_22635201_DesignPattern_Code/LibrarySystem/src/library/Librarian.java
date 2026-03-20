package library;

public class Librarian implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Librarian notified: " + message);
    }
}