package sort.Bubble;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Bubble_2 {
    public static void main(String[] args) throws Exception {
        /* 
        [ 문제 설명 ] 

        이미 정렬된 구간이 생기면 즉시 종료하는 최적화 버블 정렬을 구현하고, 정렬 완료까지 실제로 몇 번의 패스(pass)가 수행됐는지 함께 반환하라. 

        [ 입력 예시 ] 

        int[] arr = {1, 2, 5, 3, 4} 

        [ 출력 예시 ] 

        정렬 결과: [1, 2, 3, 4, 5] 패스 횟수: 2 

        [ 조건 ] 

        • swapped 플래그를 활용한 조기 종료 구현 필수 

        • 패스 횟수를 정확히 카운트할 것 
        */

        int[] arr = new int[]{1,2,5,3,4};
        
        int loop = 0;

        int n = arr.length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean swap = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swap = true;
                    System.out.printf("swap!! ");
                }
                count++;
                System.out.printf("j = %d, j+1 = %d %n", arr[j], arr[j+1]);
            }
            loop++;
            if(swap)break;
        }

        String result = Arrays.stream(arr)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(", "));
        System.out.println("실행 결과 : " + result + ", 실행 횟수 : " + loop  + " 총 실행 횟수 : " + count );
    }
}
