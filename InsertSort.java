public class InsertSort {
    //插入排序
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insert = arr[i];
            int insertIndex = i - 1;
            while(insertIndex >= 0 && insert < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insert;
        }
    }
}
