//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        Observer ob1 = new UserObserver("Nguyen Van A");
        Observer ob2 = new UserObserver("Nguyen Van B");
        Observer ob3 = new AdminObserver("Nguyen Van C");

        service.attach(ob1);
        service.attach(ob2);
        service.attach(ob3);

        service.setMessage("\nCo bai viet moi");
    }
}