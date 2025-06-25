class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int id, String name, double price) {
        this.orderId = id;
        this.customerName = name;
        this.totalPrice = price;
    }
}

public class SortOrders {
    static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
    }

    static void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice < pivot) {
                i++;
                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    static void printOrders(Order[] orders) {
        for (Order o : orders)
            System.out.println(o.orderId + " " + o.customerName + " " + o.totalPrice);
    }

    public static void main(String[] args) {
        Order[] orders1 = {
            new Order(301, "Arun", 2300),
            new Order(302, "Bhavya", 1500),
            new Order(303, "Chitra", 3200),
            new Order(304, "Deepak", 1800)
        };

        Order[] orders2 = orders1.clone();

        bubbleSort(orders1);
        System.out.println("Bubble Sort Result:");
        printOrders(orders1);

        quickSort(orders2, 0, orders2.length - 1);
        System.out.println("Quick Sort Result:");
        printOrders(orders2);
    }
}
