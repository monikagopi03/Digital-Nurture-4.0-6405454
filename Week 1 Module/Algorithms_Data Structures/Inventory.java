import java.util.*;

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

    void displayInventory() {
        for (Product p : inventory.values()) {
            System.out.println(p.productId + " - " + p.productName + " | Qty: " + p.quantity + " | Price: " + p.price);
        }
    }

    public static void main(String[] args) {
        Inventory inv = new Inventory();

        inv.addProduct(new Product(1, "Laptop", 10, 75000));
        inv.addProduct(new Product(2, "Mouse", 50, 500));
        inv.addProduct(new Product(3, "Keyboard", 30, 1000));

        System.out.println("All Products:");
        inv.displayInventory();

        System.out.println("\nUpdating Product ID 2...");
        inv.updateProduct(2, 45, 450);

        System.out.println("\nDeleting Product ID 3...");
        inv.deleteProduct(3);

        System.out.println("\nFinal Inventory:");
        inv.displayInventory();
    }
}
