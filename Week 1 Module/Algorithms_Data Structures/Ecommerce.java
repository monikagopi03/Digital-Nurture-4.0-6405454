import java.util.Arrays;

class ProductSearch {
    int productId;
    String productName;
    String category;

    ProductSearch(int id, String name, String cat) {
        this.productId = id;
        this.productName = name;
        this.category = cat;
    }
}

class SearchEngine {
    static ProductSearch linearSearch(ProductSearch[] arr, String name) {
        for (ProductSearch p : arr) {
            if (p.productName.equalsIgnoreCase(name)) return p;
        }
        return null;
    }

    static ProductSearch binarySearch(ProductSearch[] arr, String name) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0) return arr[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        ProductSearch[] items = {
            new ProductSearch(201, "Orange", "Fruit"),
            new ProductSearch(202, "Spinach", "Leafy"),
            new ProductSearch(203, "Almond", "Nut"),
            new ProductSearch(204, "Grapes", "Fruit")
        };

        Arrays.sort(items, (a, b) -> a.productName.compareToIgnoreCase(b.productName));

        String target = "Almond";

        ProductSearch result1 = linearSearch(items, target);
        if (result1 != null)
            System.out.println("Linear: " + result1.productId + " " + result1.productName + " " + result1.category);
        else
            System.out.println("Linear: Not found");

        ProductSearch result2 = binarySearch(items, target);
        if (result2 != null)
            System.out.println("Binary: " + result2.productId + " " + result2.productName + " " + result2.category);
        else
            System.out.println("Binary: Not found");
    }
}
