package subject;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;


public class Task implements Subject {
    private String taskName;
    private String status;
    private List<Observer> members = new ArrayList<>();

    public Task(String taskName, String status) {
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public void attach(Observer o) {
        members.add(o);
    }

    @Override
    public void detach(Observer o) {
        members.remove(o);
    }

    @Override
    public void notifyObservers() {
        String message = "Task [" + taskName + "] changed status to: " + status;
        for (Observer member : members) {
            member.update(message);
        }
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }
}