package sort.Quick;

import java.util.Arrays;

public class quick_7 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 2, 9, 4, 6};
        int pivot = numPartition(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        r_pivot_sort(arr, 0, pivot-1);
        r_pivot_sort(arr, pivot, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
    public static int numPartition(int[] arr, int left, int right){
        int low = left;
        int high = right;
        while (low<high){
            while (low<high&&arr[low]%2==0)low++;
            while (low<high&&arr[high]%2!=0)high--;
            if(low<high){
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
            }
        }
        return high;
    }

    public static void r_pivot_sort(int[] arr, int low, int high){
        if(low>=high)return ;
        int pivot = partition(arr, low, high);
        r_pivot_sort(arr,low,pivot-1);
        r_pivot_sort(arr,pivot+1,high);
    }

    public static int partition(int[] arr, int left, int right){
        int low = left;
        int high = right;
        int pivot = right;
        while (low<high){
            while (low<high&&arr[low]<=arr[pivot])low++;
            while (low<high&&arr[high]>=arr[pivot])high--;
            if(low<high){
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
            }
        }
        int tmp = arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = tmp;

        return high;
    }
}
