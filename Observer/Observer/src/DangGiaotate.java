public class DangGiaotate implements OrderState{
    @Override
    public void sendRequest(Order order) {
        System.out.println("Dang giao - > Da giao");
        order.setState(new DaGiaoState());
    }

    @Override
    public void checkStatus() {
        System.out.println("Trang thai : Dang giao hang");
    }
}
