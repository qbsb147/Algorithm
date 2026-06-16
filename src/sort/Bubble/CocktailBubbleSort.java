package sort.Bubble;

import java.util.Arrays;

public class CocktailBubbleSort {

    public static void cocktailSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        boolean swapped = true;

        while (left < right && swapped) {
            swapped = false;

            // 👉 1. 최댓값을 오른쪽으로 (정방향)
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
            right--; // 오른쪽 확정

            // 교환 없으면 종료
            if (!swapped) break;

            swapped = false;

            // 👉 2. 최솟값을 왼쪽으로 (역방향)
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                    swapped = true;
                }
            }
            left++; // 왼쪽 확정
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 테스트
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8, 0, 3};

        cocktailSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}