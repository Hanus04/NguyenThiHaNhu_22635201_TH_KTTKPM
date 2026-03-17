package state;

import model.Product;

public class TaxAppliedState implements ProductState {

    @Override
    public void handle(Product context) {
        System.out.println("Áp dụng thuế cho sản phẩm");
    }
}