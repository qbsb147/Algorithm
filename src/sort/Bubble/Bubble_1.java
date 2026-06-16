package sort.Bubble;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Bubble_1 {
    public static void main(String[] args) throws Exception {
        /* 
        [ 문제 설명 ] 

        정수 배열을 버블 정렬 알고리즘을 이용해 오름차순으로 정렬하는 메서드를 작성하라. 

        [ 입력 예시 ] 

        int[] arr = {5, 3, 8, 1, 2} 

        [ 출력 예시 ] 

        [1, 2, 3, 5, 8] 

        [ 조건 ] 

        • 버블 정렬 외의 정렬 알고리즘 사용 금지 

        • Java 내장 sort() 사용 금지 
        */

        int[] arr = new int[]{4, 2, 9, 7, 5, 1};

        int loop = 0;

        int count = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int cnt = 0;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    cnt++;
                }
                count++;
                System.out.printf("i = %d, j = %d %n", arr[i], arr[j]);
            }
            loop++;
            String result = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
                System.out.println("실행 결과 : " + result + ", 실행 횟수 : " + loop + ", 스왑 횟수 : " + cnt);
        }

        String result = Arrays.stream(arr)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(", "));
        System.out.println("실행 결과 : " + result + ", 실행 횟수 : " + loop  + " 총 실행 횟수 : " + count );
    }
}
