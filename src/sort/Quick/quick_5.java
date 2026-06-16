package sort.Quick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class quick_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        System.out.println("문자열를 띄어쓰기 구분하여 입력");
        System.out.println("숫자 입력하고 enter 입력 시 종료");
        while (sc.hasNext("[a-zA-Z가-힣]+")){
            list.add(sc.next());
        }
        String[] arr = list.stream().map(String::valueOf).toArray(String[]::new);
//        String[] arr = {"Banana", "apple", "Cherry", "date", "elderberry"};

        r_pivot_sort(arr,0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
    public static void r_pivot_sort(String[] arr, int low, int high){
        if(low>=high)return;
        int pivot = partition(arr, low, high);

        r_pivot_sort(arr,low,pivot-1);
        r_pivot_sort(arr,pivot+1,high);
    }
    public static int partition(String[] arr, int left, int right){
        int low = left;
        int high = right;
        int pivot = right;

        while (low<high){
            while (low<high && arr[low].compareToIgnoreCase(arr[pivot])<=0)low++;
            while (low<high && arr[high].compareToIgnoreCase(arr[pivot])>=0)high--;
            if(low<high){
                String tmp = arr[high];
                arr[high] = arr[low];
                arr[low] = tmp;
            }
        }
        String tmp = arr[high];
        arr[high] = arr[pivot];
        arr[pivot] = tmp;
        return high;
    }

}
