package state;

import model.Product;

public class TaxFreeState implements ProductState {

    @Override
    public void handle(Product context) {
        System.out.println("Sản phẩm miễn thuế");
    }
}