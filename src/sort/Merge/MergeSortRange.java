package sort.Merge;

import java.util.Arrays;

public class MergeSortRange {

    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length]; // 임시 배열 (한 번만 생성)
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    // 분할 재귀
    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        // 왼쪽
        mergeSort(arr, temp, left, mid);

        // 오른쪽
        mergeSort(arr, temp, mid + 1, right);

        // 병합
        merge(arr, temp, left, mid, right);
    }

    // 병합 함수 (핵심)
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;     // 왼쪽 시작
        int j = mid + 1;  // 오른쪽 시작
        int k = left;     // temp 인덱스

        // 두 배열 비교하면서 병합
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 남은 왼쪽
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // 남은 오른쪽
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 원본 배열로 복사
        for (int x = left; x <= right; x++) {
            arr[x] = temp[x];
        }
    }

    // 테스트
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 10};

        mergeSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}