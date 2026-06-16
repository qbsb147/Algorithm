package sort.Bubble;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Bubble_3 {
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

        int[] arr = new int[]{4, 2, 9, 7, 5, 1};

        int k = 3;
        
        int loop = 0;

        int n = arr.length;

        for (int i = 0; i < k; i++) {
            int cnt = 0;
            for (int j = i+1; j < n; j++) {
                if(arr[i]<arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    cnt++;
                }
            }
            loop++;
            if(cnt==0)break;
        }
        String result = Arrays.stream(arr)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(", "));
        System.out.println("배열 : " + result + " 실행 결과 : " + arr[k-1] + " 루프 횟수 : " + loop);
    }
}
