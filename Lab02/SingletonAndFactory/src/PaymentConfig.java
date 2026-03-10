public class PaymentConfig {

    private static PaymentConfig instance;

    private PaymentConfig() {
        System.out.println("Load payment configuration...");
    }

    public static PaymentConfig getInstance() {
        if(instance == null) {
            instance = new PaymentConfig();
        }
        return instance;
    }

    public void showConfig() {
        System.out.println("Payment system configuration loaded");
    }
}