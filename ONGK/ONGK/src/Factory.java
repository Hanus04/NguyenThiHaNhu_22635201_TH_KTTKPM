interface Notification {
    void send();
}

class EmailNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Gửi thông báo qua Email");
    }
}

class SMSNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Gửi thông báo qua SMS");
    }
}

abstract class NotificationFactory {
    public abstract Notification createNotification();

    public void notifyUser() {
        Notification notification = createNotification();
        notification.send();
    }
}

class EmailFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}

public class FactoryMethodMain {
    public static void main(String[] args) {
        NotificationFactory f1 = new EmailFactory();
        f1.notifyUser();

        NotificationFactory f2 = new SMSFactory();
        f2.notifyUser();
    }
}