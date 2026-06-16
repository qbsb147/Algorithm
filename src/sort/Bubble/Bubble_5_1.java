package sort.Bubble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bubble_5_1 {
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
                    
                    break outer;
                }
                try {
                    list.add(Integer.valueOf(input));
                } catch (Exception e) {
                    System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요");
                }
            }
        }

        int[][] arr = new int[matrix.size()][];

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                arr[i][j] = matrix.get(i).get(j);
            }
        }

        int n = arr.length;
        int[] result = new int[n];

        //버블 정렬 시작
        for (int t = 0; t < n; t++) {
            int size = arr[t].length;
            for (int i = 0; i < size-1; i++) {
                for (int j = i+1; j < size; j++) {
                    if(arr[t][i]>arr[t][j]){
                        int tmp = arr[t][i];
                        arr[t][i] = arr[t][j];
                        arr[t][j] = tmp;
                    }
                }
            }
            result[t] = arr[t][0];
        }
        String answer = Arrays.stream(result)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(","));
        System.out.println(answer);
    }
}
