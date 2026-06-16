package sort.Quick;

import java.util.ArrayList;
import java.util.Scanner;

public class quick_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("띄어쓰기로 구분하여 배열 입력");
        System.out.println("문자 입력 후 엔터 누르면 종료");
        while (sc.hasNextInt()){
            list.add(Integer.valueOf(sc.next()));
        }
        sc.nextLine();
        System.out.println("찾을 요소의 위치를 입력하세요");
        System.out.printf("입력 받을 수 있는 최댓값 : %d %n", list.size());
        int k;
        while (true){
            k = sc.nextInt();
            if(k<1 || k>list.size()){
                System.out.println("잘 못 입력하셨습니다. 다시 입력하세요");
            }else {
                break;
            }
        }
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

/*
        int[] arr = {7, 10, 4, 3, 20, 15, 23, 13};
        int k = 5;
*/

        r_pivot_sort(arr, 0, arr.length-1, k);

        System.out.println(arr[k-1]);
    }
    public static void r_pivot_sort(int[] arr, int low, int high, int k){
        if(low>=high)return;
        int pivot = partition(arr,low,high);

        if(k<pivot) r_pivot_sort(arr,low,pivot-1, k);
        else if(k>pivot) r_pivot_sort(arr,pivot+1,high, k);
//        else return;
    }

    public static int partition(int[] arr, int left, int right){
        int low = left;
        int pivot = right;
        int high = right;

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
