package sort.Quick;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//start_time= 02:12
public class quick_9 {
    static int idx;
    static Map<int[], int[]> map = new HashMap<>();
    public static void main(String[] args) {
        int[][] arr = {{3, 1, 2}, {1, 1, 1}, {2, 3, 4}, {0, 2, 1}};

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],new int[]{i,0});
        }
        r_pivot_sort(arr,0, arr.length-1);
        System.out.println(Arrays.deepToString(arr));
    }

    public static void r_pivot_sort(int[][] arr, int low, int high){
        if(low>=high)return;

        int pivot = partition(arr,low,high);

        r_pivot_sort(arr,low,pivot-1);
        r_pivot_sort(arr,pivot+1, high);
    }

    public static int partition(int[][] arr, int left, int right){
        int low = left;
        int high = right;
        int pivot = right;

        while (low<high){
            while (low<high&&rowSum(arr[low])<rowSum(arr[pivot]))low++;
            while (low<high&&rowSum(arr[high])>rowSum(arr[pivot]))high--;
            if (
                    low<high&&(
                            (
                                    (rowSum(arr[low])!=rowSum(arr[high])) ||
                                    ((rowSum(arr[low])==rowSum(arr[high])) && (map.get(arr[low])[0]>map.get(arr[high])[0]))
                            )
                    )
            ){
                int[] tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
                low++;
                high--;
            }
        }
        int[] tmp = arr[high];
        arr[high] = arr[pivot];
        arr[pivot] = tmp;
        return high;
    }

    public static int rowSum(int[] arr){
        if(map.get(arr)[1]!=0) return map.get(arr)[1];
        int sum = 0;
        for (int i : arr) {
            sum+=i;
        }
        map.get(arr)[1] = sum;
        return sum;
    }
}
