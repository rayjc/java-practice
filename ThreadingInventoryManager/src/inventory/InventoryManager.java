package inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryManager {

    List<Product> soldProducts = new CopyOnWriteArrayList<>();
    List<Product> purchasedProducts = new ArrayList<>();


    public void populateSoldProducts() {
        for(int i = 0; i < 1000; i++) {
            Product prod = new Product(i, "test_product_" + i);
            soldProducts.add(prod);
            System.out.println("Added: " + prod);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void displaySoldProducts() {
        for(Product product: soldProducts) {
            System.out.println("Showing sale for " + product);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
