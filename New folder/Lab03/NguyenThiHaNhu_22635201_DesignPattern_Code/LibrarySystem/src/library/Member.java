package library;
public class Member implements Observer {
    private String name;

    public Member(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Member " + name + " notified: " + message);
    }
}