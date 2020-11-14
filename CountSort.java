public class CountSort {
    //计数排序
    public static void countSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //找数组arr的最大值和最小值的同时复制一份arr到copyArr
        int[] copyArr = new int[arr.length];
        for(int i = 0;i < arr.length;i++) {
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
            copyArr[i] = arr[i];
        }
        //对计数数组count赋值
        int[] count = new int[max - min + 1];
        for(int num : arr) {
            count[num - min]++;
        }
        //计数数组变形，新元素的值是前面元素累加之和的值
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        //遍历copyArr中的元素，填充到arr中去，从后往前遍历
        for(int i = arr.length - 1;i >= 0;i--) {
            arr[count[copyArr[i] - min] - 1] = copyArr[i];
            count[copyArr[i] - min]--;
        }
    }
}
