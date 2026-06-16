package sort.Quick;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class quick_6 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 3, 9, 3, 1, 5, 7, 3};

        r_pivot_sort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    public static void r_pivot_sort(int[] arr, int low, int high){
        if(low>=high)return;
        int[] pivots = partition(arr, low, high);

        r_pivot_sort(arr, low, pivots[0]);
        r_pivot_sort(arr, pivots[1], high);
    }

    public static int[] partition(int[] arr, int left, int right){
        int low = left;
        int high = right;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = low; i <= high; i++) {
            int in = arr[i];
            map.put(in, map.getOrDefault(in,0) + 1);
        }
        int pivot = 0;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if(value>max){
                max = value;
                pivot = entry.getKey();
            }
        }
        while (low<high){
            while (low<high&&arr[low]<pivot)low++;
            while (low<high&&arr[high]>=pivot)high--;
            if(low<high){
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
            }
        }
        int lt = low;
        high = right;
        while (low<high){
            while (low<high&&arr[low]<=pivot)low++;
            while (low<high&&arr[high]>pivot)high--;
            if(low<high){
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
            }
        }
        int gt = high;

        return new int[]{lt,gt};
    }
}
