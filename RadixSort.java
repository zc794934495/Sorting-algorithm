public class RadixSort {
    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        int n = 1;
        int[][] bucket = new int[10][arr.length];
        int[] count = new int[10];
        while(maxLength > 0) {
            for(int num : arr) {
                int bits = num / n % 10;
                bucket[bits][count[bits]] = num;
                count[bits]++;
            }
            int index = 0;
            for(int i = 0;i < 10;i++) {
                if(count[i] != 0) {
                    for (int j = 0; j < count[i]; j++) {
                        arr[index] = bucket[i][j];
                        index++;
                    }
                }
                count[i] = 0;
            }
            n *= 10;
            maxLength--;
        }
    }
}
