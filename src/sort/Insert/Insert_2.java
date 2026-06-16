package sort.Insert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Insert_2 {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while(true) {
            String input;
            System.out.println("배열 값을 받습니다. 숫자를 입력하세요, 끝낼려면 exit");
            input = sc.nextLine();
            if(input.equals("exit")){
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

        //삽입 정렬 시작(내림차순)
        int j;
        for (int i = n-2; i >= 0; i--) {
            int tmp = arr[i];
            for (j = i+1; j < n; j++) {
                if(arr[j] < tmp) arr[j-1] = arr[j];
                else break;
            }
            arr[j-1] = tmp;
            if(i!=0) System.out.printf("step %d: %s %n", n-i-1, Arrays.toString(arr));
        }
        System.out.println("최종: "+Arrays.toString(arr));
    }
}
