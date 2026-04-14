//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Order order = new Order(new ChoXacNhanState());
        order.checkStatus();
        order.sendRequest();
        order.checkStatus();
        order.sendRequest();
        order.checkStatus();
        order.sendRequest();
        order.checkStatus();
        order.sendRequest();
        order.checkStatus();
    }
}