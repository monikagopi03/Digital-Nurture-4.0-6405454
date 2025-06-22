
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
    public static ProductSearch linearSearch(ProductSearch[] arr, String name) {
        for (ProductSearch p : arr) {
            if (p.productName.equalsIgnoreCase(name)) return p;
        }
        return null;
    }

    public static ProductSearch binarySearch(ProductSearch[] arr, String name) {
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
}