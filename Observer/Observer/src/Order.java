public class Order {
    private OrderState state;

    public Order(OrderState state) {
        this.state = state;
    }


    public void setState(OrderState state) {
        this.state = state;
    }


    public void sendRequest() {
        state.sendRequest(this);
    }


    public void checkStatus() {
        state.checkStatus();
    }
}
