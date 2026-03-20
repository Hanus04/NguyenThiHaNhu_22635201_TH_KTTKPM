import model.Product;
import strategy.*;
import decorator.*;
import state.*;

public class Main {
    public static void main(String[] args) {

        // ===== Strategy cơ bản =====
        TaxStrategy normal = new NormalTaxStrategy();

        // ===== Decorator thêm thuế =====
        TaxStrategy withVAT = new VATDecorator(normal);
        TaxStrategy fullTax = new ConsumptionTaxDecorator(withVAT);

        // ===== Product =====
        Product product = new Product("Laptop", 1000, fullTax);

        // ===== State =====
        product.setState(new TaxAppliedState());

        double finalPrice = product.calculatePrice();

        System.out.println("Giá cuối cùng: " + finalPrice);
    }
}