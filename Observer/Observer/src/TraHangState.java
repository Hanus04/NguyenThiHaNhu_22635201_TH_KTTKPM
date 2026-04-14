public class TraHangState implements OrderState{
    @Override
    public void sendRequest(Order order) {
        System.out.println("Tra hang");

    }

    @Override
    public void checkStatus() {
        System.out.println("Trang thai : Tra Hang");
    }
}
