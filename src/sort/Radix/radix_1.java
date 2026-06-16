package sort.Radix;
import java.util.Arrays;

public class radix_1 {

    // 기수 정렬 메인 함수
    public static void radix_1(int[] arr) {
        int max = getMax(arr);

        // 1의 자리, 10의 자리, 100의 자리 ...
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    // Counting Sort (특정 자릿수 기준)
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // 결과 배열
        int[] count = new int[10]; // 0~9

        // 등장 횟수 카운트
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // 누적합 (위치 계산)
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 뒤에서부터 넣어야 안정 정렬 유지됨
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // 결과 복사
        System.arraycopy(output, 0, arr, 0, n);
    }

    // 최대값 찾기
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    // 테스트
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};

        radix_1(arr);

        System.out.println(Arrays.toString(arr));
    }
}