package sort.Bubble;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Bubble_4_ {
    public static void main(String[] args) throws Exception {
        /* 
        ## 문제 4. 문자열 배열 사전순 정렬

        ### 문제 설명

        문자열 배열을 버블 정렬로 사전순(알파벳 오름차순) 정렬하라. 대소문자를 구분하지 않는다.

        ### 입력 예시

        ```java
        String[] arr = {"Banana", "apple", "Cherry", "date"};
        ```

        ### 출력 예시

        ```
        [apple, Banana, Cherry, date]
        ```

        ### 조건

        - compareToIgnoreCase() 사용 권장
        - Java 내장 sort() 사용 금지
        */

        String[] arr = {"Banana", "apple", "Cherry", "date"};

        int loop = 0;

        int n = arr.length;

        int diff = 'a'-'A';

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            outer:
            for (int j = 0; j < n - 1 - i; j++) {
                int min = Math.min(arr[j].length(), arr[j+1].length());
                for (int k = 0; k < min; k++) {
                    int o1 = arr[j].charAt(k);
                    int o2 = arr[j+1].charAt(k);
                    if(arr[j].charAt(k) > 'Z')
                        o1 = arr[j].charAt(k) - diff;
                    if(arr[j+1].charAt(k) > 'Z')
                        o2 = arr[j+1].charAt(k) - diff;
                    String result = Arrays.stream(arr)
                        .collect(Collectors.joining(", "));
                    System.out.println("배열 : " + result);
                    if(o1>o2){
                        System.out.printf("swap!! %s and %s %n", arr[j], arr[j+1]);
                        String tmp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = tmp;
                        cnt++;
                        continue outer;
                    }else if(o1<o2){
                        continue outer;
                    }
                    
                }
                if(arr[j].length()>min){
                    String result = Arrays.stream(arr)
                        .collect(Collectors.joining(", "));
                    System.out.println("배열 : " + result);
                    System.out.printf("swap! %s and %s %n", arr[j], arr[j+1]);
                    String tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    cnt++;
                }
            }
            loop++;
            if(cnt==0)break;
        }
        String result = Arrays.stream(arr)
                    .collect(Collectors.joining(", "));
        System.out.println("배열 : " + result + " 루프 횟수 : " + loop);
    }
}
