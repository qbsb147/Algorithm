package sort.Merge;

import java.util.Arrays;

public class IterativeMergeSort {

    public static void mergeSort(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];

        // size: 현재 병합할 부분 배열 크기
        for (int size = 1; size < n; size *= 2) {

            // left: 시작 인덱스
            for (int left = 0; left < n - size; left += 2 * size) {

                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);

                merge(arr, temp, left, mid, right);
            }
        }
    }

    // 병합 함수
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;      // 왼쪽 시작
        int j = mid + 1;   // 오른쪽 시작
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        // 복사
        for (int x = left; x <= right; x++) {
            arr[x] = temp[x];
        }
    }

    // 테스트
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        mergeSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}