import java.util.Arrays;

interface Strategy {
    void sort(int[] arr);
}

class BubbleSort implements Strategy {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
    }
}

class SelectionSort implements Strategy {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[min])
                    min = j;
            int tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }
    }
}

class Context {
    private Strategy strat;

    public Context(Strategy s) {
        strat = s;
    }

    public void execute(int[] arr) {
        strat.sort(arr);
    }
}

class StrategyPattern {
    public static void main(String[] args) {
        int[] arr1 = {5, 2, 8, 1};
        int[] arr2 = {9, 4, 3, 7};

        Context bubbleContext = new Context(new BubbleSort());
        bubbleContext.execute(arr1);
        System.out.println("Bubble Sort: " + Arrays.toString(arr1));

        Context selectionContext = new Context(new SelectionSort());
        selectionContext.execute(arr2);
        System.out.println("Selection Sort: " + Arrays.toString(arr2));
    }
}
