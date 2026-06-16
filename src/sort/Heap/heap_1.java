package sort.Heap;

public class heap_1 {

    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            // 루트(최대값)랑 마지막 값 교환
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 힙 재구성 (heap size 줄임)
            heapify(arr, i, 0);
        }
    }

    // 힙 구조 유지 (max heap)
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;        // 루트
        int left = 2 * i + 1;   // 왼쪽 자식
        int right = 2 * i + 2;  // 오른쪽 자식

        // 왼쪽 자식이 더 크면
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 오른쪽 자식이 더 크면
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 루트가 최대가 아니면 교환
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // 재귀적으로 heapify
            heapify(arr, n, largest);
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