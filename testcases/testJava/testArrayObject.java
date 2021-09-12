package testJava;

import java.util.ArrayList;

public class testArrayObject {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Macbook Air M1", "26tr"));
        products.add(new Product("Macbook Pro 2020", "35tr"));
        products.add(2, new Product("Macbook Pro M1", "36tr"));

        for (Product a : products) {
            a.display();
        }


        Product[] productList = new Product[3];
        productList[0] = new Product("Macbook Pro M1", "36tr");
        productList[1] = new Product("Macbook Air M1", "26tr");
        productList[2] = new Product("Macbook Pro 2020", "35tr");

        int i;
        for (i = 0; i < productList.length; i++) {
            productList[i].display();
        }
    }
}
