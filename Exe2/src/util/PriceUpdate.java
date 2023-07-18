package util;

import application.Program;
import entities.Product;

import java.util.function.Consumer;

public class PriceUpdate implements Consumer<Product> {

    @Override
    public void accept(Product product) {
        product.setPrice(Double.valueOf(String.format("%.2f", product.getPrice() * 1.1)));
    }
}
