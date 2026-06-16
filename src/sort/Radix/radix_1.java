package sort.Radix;

public class radix_1 {
    public static void main(String[] args) {
        int[] arr = {1,6,2,8,13,16,11,4,22};
        int n = arr.length;
        int radix = 1;
        while (true){
            if( radix >= n )break;
            radix = radix * 10;
        }
        for (int i = 0; i < radix; i *= 10) {
            for(int j = 0; j < n; j++){
                int k;
                if (arr[j] < i) k = 0;
                else k = (arr[j]/i)%10;
            }
        }
    }
}
