package decorator;

public class BasicOrder implements OrderComponent {
    public void process() {
        System.out.println("Xử lý đơn hàng cơ bản");
    }
}