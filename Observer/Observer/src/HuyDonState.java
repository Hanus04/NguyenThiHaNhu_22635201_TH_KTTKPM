public class HuyDonState implements OrderState{
    @Override
    public void sendRequest(Order order) {
        System.out.println("Don hang da bi huy");

    }

    @Override
    public void checkStatus() {
        System.out.println("Trang thai : Huy don");
    }
}
