public class ChoLayHangState implements OrderState{
    @Override
    public void sendRequest(Order order) {
        System.out.println("Cho lay hang - > Dang giao");
        order.setState(new DangGiaotate());
    }

    @Override
    public void checkStatus() {
        System.out.println("Trang thai : Cho lay hang");
    }
    public void cancel (Order order){
        System.out.println("Cho lay hang - > Da huy");
        order.setState(new HuyDonState());
    }
}
