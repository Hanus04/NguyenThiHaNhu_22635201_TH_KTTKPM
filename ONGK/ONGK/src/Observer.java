import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String news);
}

interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}

class NewsPublisher implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String news;

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }
}

class UserObserver implements Observer {
    private final String name;

    public UserObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " nhận tin: " + news);
    }
}

public class ObserverMain {
    public static void main(String[] args) {
        NewsPublisher publisher = new NewsPublisher();

        Observer u1 = new UserObserver("Hao");
        Observer u2 = new UserObserver("An");

        publisher.attach(u1);
        publisher.attach(u2);

        publisher.setNews("Có bài viết mới về Design Pattern!");
    }
}