package sort.Insert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Insert_5 {
    public static void main(String[] args) throws Exception {

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int k = 0;
        outer:
        while(true) {
            matrix.add(new ArrayList<>());
            while(true) {
                ArrayList list = matrix.get(k);
                String input;
                System.out.println("숫자를 입력하세요, 다음 줄을 받을려면 next, 끝낼려면 exit");
                input = sc.nextLine();
                if(input.equals("next")){
                    System.out.println(Arrays.toString(matrix.get(k).toArray()));
                    k++;
                    break;
                }
                if(input.equals("exit")){
                    System.out.println(Arrays.toString(matrix.get(k).toArray()));
                    break outer;
                }
                try {
                    list.add(Integer.valueOf(input));
                } catch (Exception e) {
                    System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요");
                }
            }
        }

        int n = matrix.size();

        int[][] arr = new int[n][];

        for (int i = 0; i < n; i++) {
            arr[i] = new int[matrix.get(i).size()];
            for (int j = 0; j < matrix.get(i).size(); j++) {
                arr[i][j] = matrix.get(i).get(j);
            }
        }
        
        //삽입 정렬 시작(오름차순)
        for (int i = 1; i < n; i++) {
            int[] tmp = arr[i];
            if(tmp[0] >=arr[i-1][0]){
                continue;
            }
            int search = binarySearch(arr, i-1, tmp[0]);
            for (int j = i-1; j >= search; j--) {
                arr[j+1] = arr[j];
            }
            arr[search] = tmp;
        }
        System.out.println(Arrays.deepToString(arr));
    }

    public static int binarySearch(int[][] arr,int end, int tmp){
        int start = 0;
        while (start<=end){
            if(start==end)return start;
            int mid = start + (end - start)/2;
            if(arr[mid][0]<tmp)
                start = mid + 1;
            else if(arr[mid][0]>tmp)
                end = mid;
            else return mid;
        }
        return -1;
    }
}
