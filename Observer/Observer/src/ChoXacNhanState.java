public class ChoXacNhanState implements OrderState{
    @Override
    public void sendRequest(Order order) {
        System.out.println("Xac nhan don -> Cho lay hang");
        order.setState(new ChoLayHangState());
    }

    @Override
    public void checkStatus() {
        System.out.println("Trang thai : Cho xac nhan");
    }
}
