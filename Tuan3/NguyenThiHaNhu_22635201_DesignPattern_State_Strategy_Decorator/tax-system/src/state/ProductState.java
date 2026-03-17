package state;

import model.Product;

public interface ProductState {
    void handle(Product context);
}