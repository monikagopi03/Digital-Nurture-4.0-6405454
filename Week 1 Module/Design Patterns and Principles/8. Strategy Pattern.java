
interface Strategy { void sort(int[] arr); }
class BubbleSort implements Strategy {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = tmp;
                }
    }
}
class Context {
    private Strategy strat;
    public Context(Strategy s) { strat = s; }
    public void execute(int[] arr) { strat.sort(arr); }
}
class StrategyTest {
    public static void main(String[] args) {
        int[] a = {5, 2, 8, 1};
        Context c = new Context(new BubbleSort());
        c.execute(a);
        System.out.println(Arrays.toString(a));
    }
}