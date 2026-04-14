public interface OrderState {
    void sendRequest(Order order);
    void checkStatus();
}