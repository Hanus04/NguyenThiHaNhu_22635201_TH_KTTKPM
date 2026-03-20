package strategy;

public class DeliveredStrategy implements OrderStrategy {
    public void process() {
        System.out.println("Đã giao hàng");
    }
}