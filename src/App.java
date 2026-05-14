import sort.BubbleSort;
import sort.BubbleSortBase;

public class App {
    public static void main(String[] args) throws Exception {
        BubbleSort bubbleSort = new BubbleSortBase();
        ((BubbleSortBase)bubbleSort).run(1);
    }
}
