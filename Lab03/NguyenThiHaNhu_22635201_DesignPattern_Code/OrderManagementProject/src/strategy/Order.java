package strategy;

public class Order {
    private OrderStrategy strategy;

    public void setStrategy(OrderStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.process();
    }
}