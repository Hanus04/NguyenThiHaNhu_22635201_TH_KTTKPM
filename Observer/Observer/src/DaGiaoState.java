public class DaGiaoState implements OrderState{
    @Override
    public void sendRequest(Order order) {
        System.out.println("Da giao");
        order.setState(new TraHangState());
    }

    @Override
    public void checkStatus() {
        System.out.println("Trang thai : DaGiao");
    }
}
