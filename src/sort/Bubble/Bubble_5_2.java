package sort.Bubble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bubble_5_2 {
    public static void main(String[] args) throws Exception {
        /* 
            문제 5. 2D 배열 행 정렬 후 열 최솟값 추출 

            [ 문제 설명 ] 

            2차원 정수 배열의 각 행을 버블 정렬로 오름차순 정렬한 후, 각 열에서 최솟값을 추출해 배열로 반환하라. 

            [ 입력 예시 ] 

            int[][] matrix = {{3,1,2},{6,4,5},{9,7,8}} 

            [ 출력 예시 ] 

            [1, 2, 3] 

            [ 조건 ] 

            • 각 행마다 별도의 버블 정렬 적용 

            • 열 기준으로 최솟값 추출 
        */
        Scanner sc = new Scanner(System.in);
        int size;
        while (true){
            System.out.println("2차원 버블 정렬을 시작합니다, 총 몇줄을 입력 받겠습니까? (양수로)");
            try {
                size= Integer.parseInt(sc.nextLine());
                if(size<=0){
                    System.out.println("잘 못 입력하셨습니다.");
                    continue;
                }
                break;
            }catch (Exception e){
                System.out.println("잘 못 입력하셨습니다.");
            }
        }
        
        int n;
        while (true){
            System.out.println("한 줄에 몇 칸을 입력받을지 작성하세요(양수로)");
            try {
                n = Integer.parseInt(sc.nextLine());
                if(n<=0){
                    System.out.println("잘 못 입력하셨습니다.");
                    continue;
                }
                break;
            }catch (Exception e){
                System.out.println("잘 못 입력하셨습니다.");
            }
        }

        int[][] matrix = new int[size][n];
        for (int i = 0; i < size; i++) {
            System.out.printf("띄어쓰기로 구분해서 총 %d개의 수를 입력하세요, 그 이상 입력할 시 나머지는 무시됩니다.", n);
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                try {
                    matrix[i][j] = Integer.parseInt(sc.next());
                    cnt++;
                }catch (Exception e) {
                    System.out.println("잘 못 입력하셨습니다.");
                    i--;
                    break;
                }
            }
            sc.nextLine();
        }

        //버블 정렬 시작
        int length = (int)Math.log10(size)+1;
        
        long[] arr = new long[size*n];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < n; j++) {
                arr[i*n+j] = (long)matrix[i][j]*((int)Math.pow(10,length)) + i;
            }
        }

        boolean[] visited = new boolean[size];
        int[] result = new int[size];
        for (int i = 0; i < arr.length-1; i++) {
            boolean swap = false;
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    long tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    swap = true;
                }
            }
            if(!swap)break;
        }
        int cnt=0;
        for (int i = 0; i < arr.length; i++) {
            int pos = (int)arr[i]%((int)Math.pow(10,length));
            if(!visited[pos]){
                result[pos] = (int)arr[i]/((int)Math.pow(10,length));
                cnt++;
                visited[pos] = true;
            }
            if(cnt==size)break;
        }

        String answer = Arrays.toString(result);
        System.out.println(answer);
    }
}
