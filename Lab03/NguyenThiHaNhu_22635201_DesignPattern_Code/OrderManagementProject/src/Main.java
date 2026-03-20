import state.*;
import state.Order;
import strategy.*;
import decorator.*;

public class Main {
    public static void main(String[] args) {

        // ===== STATE =====
        System.out.println("=== STATE PATTERN ===");
        Order orderState = new Order();
        orderState.setState(new NewState());
        orderState.process();
        orderState.process();

        // ===== STRATEGY =====
        System.out.println("\n=== STRATEGY PATTERN ===");
        strategy.Order orderStrategy = new strategy.Order();
        orderStrategy.setStrategy(new NewStrategy());
        orderStrategy.execute();

        orderStrategy.setStrategy(new ProcessingStrategy());
        orderStrategy.execute();

        // ===== DECORATOR =====
        System.out.println("\n=== DECORATOR PATTERN ===");
        OrderComponent order = new BasicOrder();
        order = new NewOrderDecorator(order);
        order = new ProcessingOrderDecorator(order);
        order = new DeliveredOrderDecorator(order);

        order.process();
    }
}