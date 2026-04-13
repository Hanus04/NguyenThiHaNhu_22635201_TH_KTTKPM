interface PaymentGateway {
    void pay(int amount);
}

class LegacyPaymentAPI {
    public void makePayment(int money) {
        System.out.println("Legacy API xử lý thanh toán: " + money);
    }
}

class PaymentAdapter implements PaymentGateway {
    private final LegacyPaymentAPI api;

    public PaymentAdapter(LegacyPaymentAPI api) {
        this.api = api;
    }

    @Override
    public void pay(int amount) {
        api.makePayment(amount);
    }
}

public class AdapterMain {
    public static void main(String[] args) {
        PaymentGateway gateway = new PaymentAdapter(new LegacyPaymentAPI());
        gateway.pay(300000);
    }
}