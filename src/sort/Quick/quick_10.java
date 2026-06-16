package sort.Quick;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//start_time= 02:12
public class quick_10 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 5, 3, 9, 8, 2};
        int k = 4;

        r_pivot_sort(arr,0, arr.length-1);

        int[] result = new int[k];
        int a = 0;
        for (int i = 0; i < 4; i++) {
            int b = 0;
            while (arr[a]==arr[a+b])b++;
            result[i] = arr[a];
            a = a+b;
        }
        System.out.println(Arrays.toString(result));
    }

    public static void r_pivot_sort(int[] arr, int low, int high){
        if(low>=high)return;

        int pivot = partition(arr,low,high);

        r_pivot_sort(arr,low,pivot-1);
        r_pivot_sort(arr,pivot+1, high);
    }

    public static int partition(int[] arr, int left, int right){
        int low = left;
        int high = right;
        int pivot = right;

        while (low<high){
            while (low<high&&arr[low]>=arr[pivot])low++;
            while (low<high&&arr[high]<=arr[pivot])high--;
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
