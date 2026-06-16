package sort.Quick;

import java.util.Arrays;

public class quick_8 {
    static int idx;
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        idx = arr.length-k;
        r_pivot_sort(arr,0, arr.length-1);

        System.out.println(arr[arr.length-k]);
        System.out.println(Arrays.toString(arr));
    }

    public static void r_pivot_sort(int[] arr, int low, int high){
        if(low>=high)return;

        int pivot = partition(arr, low, high);

        if(arr[pivot]==arr[idx]) return;
        if(pivot<idx){
            r_pivot_sort(arr,low,pivot-1);
        }
        if(pivot>idx){
            r_pivot_sort(arr,pivot+1,high);
        }
    }

    public static int partition(int[] arr, int left, int right){
        int low = left;
        int high = right;
        int pivot = right;

        while (low<high){
            while (low<high&&arr[low]<arr[pivot])low++;
            while (low<high&&arr[high]>arr[pivot])high--;
            if(low<high){
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
            }
        }
        int tmp = arr[high];
        arr[high] = arr[pivot];
        arr[pivot] = tmp;
        return high;
    }
}
