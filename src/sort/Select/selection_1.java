package sort.Select;

import java.util.Arrays;

public class selection_1 {
    public static void main(String[] args) {
        int[] arr = {5,9,17,3,13,1,21,14};
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if(arr[j]< arr[min]){
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
