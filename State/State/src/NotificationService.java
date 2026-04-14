import java.util.ArrayList;
import java.util.List;

public class NotificationService implements Subject {
    private List <Observer> observers = new ArrayList<>();
    private String message;

    public NotificationService() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObserver();
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObserver() {
        for(Observer o : observers){
            o.update(message);
        }
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);

    }
}