package sort.Quick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class quick_3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("띄어쓰기로 구분하여 숫자 배열을 입력");
        System.out.println("문자를 입력하고 enter 누르면 입력 종료");
        ArrayList<Integer> segments = new ArrayList<>();
        while (sc.hasNextInt()){
            segments.add(sc.nextInt());
        }
        int[] arr = segments.stream().mapToInt(Integer::intValue).toArray();

//        int[] arr = {7, 2, 1, 6, 5, 3, 4};
        r_pivot_sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void r_pivot_sort(int[] arr, int low, int high){
        if(low>=high)return;
        int pivot = partition(arr, low, high);
        r_pivot_sort(arr, low, pivot-1);
        r_pivot_sort(arr, pivot+1, high);
    }
    public static int partition(int[] arr, int left, int right){
        int pivot = left + ((right-left)/2);
        int temp = arr[pivot];
        arr[pivot] = arr[right];
        arr[right] = temp;
        int low = left;
        int high = right;
        pivot = right;
        while (low<high){
            while (low<high&&arr[low]<=arr[pivot])low++;
            while (low<high&&arr[high]>=arr[pivot])high--;
            if(low<high){
                int tmp     = arr[low];
                arr[low]    = arr[high];
                arr[high]   = tmp;
            }
        }
        int tmp = arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = tmp;

        return high;
    }
}
