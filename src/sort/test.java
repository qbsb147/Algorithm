package sort;

import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        int[] arr = {3, 5, 3, 9, 3, 1, 5, 7, 3};

        HashMap<Integer, Integer> max = new HashMap<>();
        for (int i : arr) {
            max.put(arr[i], max.getOrDefault(arr[i], 0)+1);
        }

        
    }
    public static void r_pivot_sort(int[] arr, int low, int high){
        if(low>=high)return;
        
        int pivot = partition(arr, low, high, int pivot);
        r_pivot_sort(arr, low, pivot-1);
        r_pivot_sort(arr, pivot+1, high);
    }

    public static int partition(int[] arr, int left, int right, int pivot){
        int low = left;
    }
}
