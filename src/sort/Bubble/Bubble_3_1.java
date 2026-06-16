package sort.Bubble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bubble_3_1 {
    public static void main(String[] args) throws Exception {
        /* 
        문제 3. 내림차순 정렬 + K번째 큰 수 

        [ 문제 설명 ] 

        버블 정렬을 이용해 배열을 내림차순으로 정렬한 후, K번째로 큰 수를 반환하라. 
        
        [ 입력 예시 ] 
        
        int[] arr = {4, 2, 9, 7, 5, 1}, int k = 3 
        
        [ 출력 예시 ] 
        
        5 
        
        [ 조건 ] 
        • 내림차순 정렬 기준 적용 
        • k번째 이후는 정렬하지 않아도 되는 최적화 적용 권장 

        */

        ArrayList<Integer> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int k = 0;

        while(true) {
            String input;
            System.out.println("배열 값을 받습니다. 숫자를 입력하세요, 끝낼려면 exit");
            input = sc.nextLine();
            if(input.equals("exit")){
                String answer = list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
                System.out.println(answer);
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
        
        while (true) {
            System.out.println("찾을 요소의 위치를 입력하세요, 최대 길이 : " + n);
            try {
                k = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
                continue;
            }
        }


        boolean swapped = false;
        int loop = 0;
        do{
            swapped = false;
            for (int i = arr.length-2; i >= 0; i++) {
                if(arr[i] < arr[i+1]){
                    int tmp = arr[i] ;
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    swapped = true;
                }
            }
            n++;
            loop++;
            String answer = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
            System.out.println(answer);
        }while(swapped);
        String result = Arrays.stream(arr)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(", "));
        System.out.println("배열 : " + result + " 실행 결과 : " + arr[k-1] + " 루프 횟수 : " + loop);
    }
}
