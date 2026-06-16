package sort.Heap;

public class heap_2 {

    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n/2 - 1; i >= 0 ; i--) {
            heapify(arr, n, i);
        }

        for (int i = n-1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            heapify(arr,i,0);
        }
    }

    // 힙 구조 유지 (max heap)
    private static void heapify(int[] arr, int n, int i) {
        int lagister = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left < n && arr[lagister] < arr[left]) lagister = left;
        if(right < n && arr[lagister] < arr[right]) lagister = right;
        if(lagister != i){
            int tmp = arr[lagister];
            arr[lagister] = arr[i];
            arr[i] = tmp;
            heapify(arr, n, lagister);
        }
    }

    // 테스트
    public static void main(String[] args) {
        int[] arr = {21, 10, 12, 20, 25, 13, 15, 22};

        heapSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}