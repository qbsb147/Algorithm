package sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSortBase implements BubbleSort {

    @Override
    public void run() {
        int[] list = new int[]{41,12,61,33,7,19,123,55, 4, 1, 9, 7 ,10, 88};

        int cnt = 0;

        for (int i = 0; i < list.length; i++) {
            for (int j = i+1; j < list.length; j++) {
                if(list[i]<list[j])swap(list, i, j);
                cnt++;
            }
        }

        String result = Arrays.stream(list)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(", "));
        System.out.println(result);
        System.out.println("배열 길이 : "+ list.length);
        System.out.println("총 연산 횟수 : "+ cnt);
    }

    public void run(int k) {
        int[] list = new int[]{41,12,61,33,7,19,123,55, 4, 1, 9, 7 ,10, 88};

        int cnt = 0;

        for (int i = 0; i < list.length; i++) {
            for (int j = i+1; j < list.length; j++) {
                if(k>0 ? list[i]<list[j] : list[i]>list[j])swap(list, i, j);
                cnt++;
            }
        }

        String result = Arrays.stream(list)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(", "));
        System.out.println(result);
        System.out.println("배열 길이 : "+ list.length);
        System.out.println("총 연산 횟수 : "+ cnt);
    }

    private void swap(int[] arr, int o1, int o2){
        int temp = arr[o1];
        arr[o1] = arr[o2];
        arr[o2] = temp;
    }
}
