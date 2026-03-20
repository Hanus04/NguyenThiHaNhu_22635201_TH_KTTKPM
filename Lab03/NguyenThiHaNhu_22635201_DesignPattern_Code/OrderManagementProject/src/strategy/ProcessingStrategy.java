package strategy;

public class ProcessingStrategy implements OrderStrategy {
    public void process() {
        System.out.println("Đóng gói và vận chuyển");
    }
}