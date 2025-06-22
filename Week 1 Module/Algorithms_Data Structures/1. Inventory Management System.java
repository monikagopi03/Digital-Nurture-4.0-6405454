

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int id, String name, int qty, double price) {
        this.productId = id;
        this.productName = name;
        this.quantity = qty;
        this.price = price;
    }
}

import java.util.*;

class Inventory {
    Map<Integer, Product> inventory = new HashMap<>();

    void addProduct(Product p) {
        inventory.put(p.productId, p);
    }

    void updateProduct(int id, int newQty, double newPrice) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = newQty;
            p.price = newPrice;
        }
    }

    void deleteProduct(int id) {
        inventory.remove(id);
    }
}