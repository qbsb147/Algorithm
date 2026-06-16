package sort.Insert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Insert_3 {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while(true) {
            String input;
            System.out.println("배열 값을 받습니다. 숫자를 입력하세요, 끝낼려면 exit");
            input = sc.nextLine();
            if(input.equals("exit")){
                System.out.println(Arrays.toString(list.toArray()));
                break;
            }
            try {
                list.add(Integer.valueOf(input));
            } catch (Exception e) {
                System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요");
            }
        }

        int n = list.size();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = list.get(i);
        }

        //삽입 정렬 시작(오름차순)
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            if(tmp >=arr[i-1]){
                continue;
            }
            int search = binarySearch(arr, i-1, tmp);
            for (int j = i-1; j >= search; j--) {
                arr[j+1] = arr[j];
            }
            arr[search] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int binarySearch(int[] arr,int end, int tmp){
        int start = 0;
        while (start<=end){
            if(start==end)return start;
            int mid = start + (end - start)/2;
            if(arr[mid]<tmp)
                start = mid + 1;
            else if(arr[mid]>tmp)
                end = mid;
            else return mid;
        }
        return -1;
    }
}
