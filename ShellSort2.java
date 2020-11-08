public class ShellSort2 {
    //希尔排序（位移法）
    public static void shellSort2(int[] arr) {
        for(int gap = arr.length / 2;gap > 0;gap /= 2) {
            for(int i = gap;i < arr.length;i++) {
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j - gap]){
                    while(j - gap>= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}