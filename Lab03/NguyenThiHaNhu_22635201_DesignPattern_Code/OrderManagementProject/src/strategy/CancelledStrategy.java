package strategy;

public class CancelledStrategy implements OrderStrategy {
    public void process() {
        System.out.println("Hủy đơn và hoàn tiền");
    }
}